package excelium.core.command;

import excelium.core.CommandExecutor;
import excelium.core.Excelium;
import excelium.core.driver.ContextAwareWebDriver;
import excelium.core.exception.AssertFailedException;
import excelium.core.service.ExecutorProviderService;
import excelium.model.project.Project;
import excelium.model.test.command.Command;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static excelium.common.ObjectUtil.checkEquals;
import static excelium.common.StringUtil.addSpaceToCamelCase;

public class CommandFactory {

    /**
     * Logger
     */
    private static final Logger LOG = LogManager.getLogger();

    /**
     * Web command executor classes
     */
    private static List<Class<? extends CommandExecutor>> webCommandExecutorClasses = new ArrayList<>();

    /**
     * Mobile command executor classes
     */
    private static List<Class<? extends CommandExecutor>> mobileCommandExecutorClasses = new ArrayList<>();

    /**
     * Creates the map of commands from the list of command executors.
     *
     * @return the map of commands
     */
    public static Map<String, Command> createCommandMap(ContextAwareWebDriver webDriver, String baseUrl, Excelium excelium, Project project, boolean webContext) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        List<CommandExecutor> commandExecutors = getCommandExecutors(webDriver, baseUrl, excelium, project, webContext);
        return createCommandMap(commandExecutors, webContext);
    }

    /**
     * Get the list of command executors of current environment
     *
     * @return the list of command executors
     * @throws NoSuchMethodException     the no such method exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws InvocationTargetException the invocation target exception
     * @throws InstantiationException    the instantiation exception
     */
    private static List<CommandExecutor> getCommandExecutors(ContextAwareWebDriver webDriver, String baseUrl, Excelium excelium, Project project, boolean webContext) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        List<CommandExecutor> commandExecutors = new ArrayList<>();

        List<Class<? extends CommandExecutor>> cached = webContext ? webCommandExecutorClasses : mobileCommandExecutorClasses;

        if (CollectionUtils.isEmpty(cached)) {
            cached.addAll(getCommandExecutorClasses(webDriver, webContext));
        }
        for (Class<? extends CommandExecutor> clazz : cached) {
            CommandExecutor commandExecutor = clazz.getConstructor(ContextAwareWebDriver.class, String.class, Excelium.class, Project.class)
                    .newInstance(webDriver, baseUrl, excelium, project);
            commandExecutors.add(commandExecutor);
        }

        return commandExecutors;
    }

    /**
     * Gets command executor classes.
     *
     * @param webContext the web context
     * @return the command executor classes
     */
    private static List<Class<? extends CommandExecutor>> getCommandExecutorClasses(ContextAwareWebDriver webDriver, boolean webContext) {
        List<Class<? extends CommandExecutor>> classes = new ArrayList<>();
        ServiceLoader<ExecutorProviderService> serviceLoader = ServiceLoader.load(ExecutorProviderService.class);
        for (ExecutorProviderService service : serviceLoader) {
            List<Class<? extends CommandExecutor>> providedClasses;
            if (webContext) {
                providedClasses = service.getWebExecutorClasses(webDriver);
            } else {
                providedClasses = service.getMobileExecutorClasses(webDriver);
            }
            if (CollectionUtils.isNotEmpty(providedClasses)) {
                classes.addAll(providedClasses);
            }
        }
        return classes;
    }

    /**
     * Checks whether the command is available on the provided environment.
     *
     * @param annotation command annotation. Either action or accessor
     * @param webDriver  the context aware web driver
     * @return true if the command is available, otherwise, false
     */
    private static boolean isCommandAvailable(Object annotation, ContextAwareWebDriver webDriver, boolean webContext) {
        boolean web = true;
        boolean android = true;
        boolean ios = true;
        if (annotation instanceof Action) {
            Action action = (Action) annotation;
            web = action.web();
            android = action.android();
            ios = action.ios();
        } else if (annotation instanceof Accessor) {
            Accessor accessor = (Accessor) annotation;
            web = accessor.web();
            android = accessor.android();
            ios = accessor.ios();
        }
        if (web && webContext) {
            return true;
        }
        if (android && !webContext && webDriver.isAndroid()) {
            return true;
        }
        if (ios && !webContext && webDriver.isIOS()) {
            return true;
        }
        return false;
    }

//    /**
//     * Store push value.
//     *
//     * @param executor   the command executor
//     * @param method     the method
//     * @param param1     the parameter 1
//     * @param param2     the parameter 2
//     * @param param3     the parameter 3
//     * @param paramCount the parameter count
//     * @throws InvocationTargetException the invocation target exception
//     * @throws IllegalAccessException    the illegal access exception
//     */
//    private static void storePushValue(CommandExecutor executor, Method method, Object param1, Object param2, Object param3, int paramCount) throws InvocationTargetException, IllegalAccessException {
//        Object value = getAccessorValue(executor, method, param1, param2, paramCount);
//        if (paramCount == 0) {
//            executor.getWebDriver().pushVariable(value, (String) param1);
//        } else if (paramCount == 1) {
//            executor.getWebDriver().pushVariable(value, (String) param2);
//        } else if (paramCount == 2) {
//            executor.getWebDriver().pushVariable(value, (String) param3);
//        }
//    }

    /**
     * Invokes accessor method and return the result.
     *
     * @param executor   the command executor
     * @param method     the method
     * @param param1     the parameter 1
     * @param param2     the parameter 2
     * @param paramCount the parameter count
     * @return the result of invocation
     * @throws InvocationTargetException the invocation target exception
     * @throws IllegalAccessException    the illegal access exception
     */
    private static Object getAccessorValue(CommandExecutor executor, Method method, Object param1, Object param2, int paramCount) throws InvocationTargetException, IllegalAccessException {
        if (paramCount == 0) {
            return method.invoke(executor);
        } else if (paramCount == 1) {
            return method.invoke(executor, param1);
        } else if (paramCount == 2) {
            return method.invoke(executor, param1, param2);
        }
        return null;
    }
}
