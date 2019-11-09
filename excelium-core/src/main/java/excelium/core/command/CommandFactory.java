/*
 * MIT License
 *
 * Copyright (c) 2018 Excelium
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

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

/**
 * Factory that creates commands.
 *
 * @author PhungDucKien
 * @since 2018.05.07
 */
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
    public static Map<String, Command> createCommandMap(ContextAwareWebDriver webDriver, String baseUrl, Excelium excelium, Project project, boolean forWeb) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        List<CommandExecutor> commandExecutors = getCommandExecutors(webDriver, baseUrl, excelium, project, forWeb);
        return createCommandMap(commandExecutors);
    }

    /**
     * Creates the map of commands from the list of command executors.
     *
     * @param commandExecutors the list of command executors
     * @return the map of commands
     */
    public static Map<String, Command> createCommandMap(List<CommandExecutor> commandExecutors) {
        Map<String, Command> commandMap = new LinkedHashMap<>();
        for (CommandExecutor executor : commandExecutors) {
            List<Command> commands = createCommandList(executor);
            for (Command command : commands) {
                commandMap.put(command.getMethod() + "(" + countParam(command) + ")", command);
            }
        }
        return commandMap;
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
    private static List<CommandExecutor> getCommandExecutors(ContextAwareWebDriver webDriver, String baseUrl, Excelium excelium, Project project, boolean forWeb) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        List<CommandExecutor> commandExecutors = new ArrayList<>();

        List<Class<? extends CommandExecutor>> cached = forWeb ? webCommandExecutorClasses : mobileCommandExecutorClasses;

        if (CollectionUtils.isEmpty(cached)) {
            cached.addAll(getCommandExecutorClasses(forWeb));
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
     * @param forWeb the for web
     * @return the command executor classes
     */
    private static List<Class<? extends CommandExecutor>> getCommandExecutorClasses(boolean forWeb) {
        List<Class<? extends CommandExecutor>> classes = new ArrayList<>();
        ServiceLoader<ExecutorProviderService> serviceLoader = ServiceLoader.load(ExecutorProviderService.class);
        for (ExecutorProviderService service : serviceLoader) {
            List<Class<? extends CommandExecutor>> providedClasses;
            if (forWeb) {
                providedClasses = service.getWebExecutorClasses();
            } else {
                providedClasses = service.getMobileExecutorClasses();
            }
            if (CollectionUtils.isNotEmpty(providedClasses)) {
                classes.addAll(providedClasses);
            }
        }
        return classes;
    }

    /**
     * Creates the list of commands from the command executor.
     *
     * @param executor the command executor
     * @return the list of commands
     */
    private static List<Command> createCommandList(CommandExecutor executor) {
        Map<Method, Action> actions = new LinkedHashMap<>();
        Map<Method, Accessor> accessors = new LinkedHashMap<>();
        for (Method method : executor.getClass().getDeclaredMethods()) {
            if (Modifier.isPublic(method.getModifiers())) {
                Action action = method.getAnnotation(Action.class);
                if (action != null) {
                    if (isCommandAvailable(action, executor.getWebDriver())) {
                        actions.put(method, action);
                    }
                }

                Accessor accessor = method.getAnnotation(Accessor.class);
                if (accessor != null) {
                    if (isCommandAvailable(accessor, executor.getWebDriver())) {
                        accessors.put(method, accessor);
                    }
                }
            }
        }

        List<Command> commands = createCommandsForActions(executor, actions);
        commands.addAll(createCommandsForAccessors(executor, accessors));
        return commands;
    }

    /**
     * Creates the list of commands from actions of the command executor.
     *
     * @param executor the command executor
     * @param actions  the map of actions
     * @return the list of commands
     */
    private static List<Command> createCommandsForActions(CommandExecutor executor, Map<Method, Action> actions) {
        List<Command> commands = new ArrayList<>();
        for (Method method : actions.keySet()) {
            String regex = "^([a-zA-Z].+)$";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(method.getName());

            if (matcher.find()) {
                String baseName = StringUtils.capitalize(matcher.group(1));
                Action action = actions.get(method);

                if (("parentLocator".equals(action.param1()) && "locator".equals(action.param2())) || ("parentLocator".equals(action.param2()) && "locator".equals(action.param3()))) {
                    commands.add(createLocatorCommand(executor, method, action, baseName));
                    if (baseName.startsWith("Verify")) {
                        commands.add(createLocatorCommand(executor, method, action, baseName.replace("Verify", "Assert")));
                    }
                }
                commands.add(createCommand(executor, method, action, baseName));
                if (baseName.startsWith("Verify")) {
                    commands.add(createCommand(executor, method, action, baseName.replace("Verify", "Assert")));
                }
            }
        }
        return commands;
    }

    /**
     * Creates the list of commands from accessors of the command executor.
     *
     * @param executor  the command executor
     * @param accessors the map of accessors
     * @return the list of commands
     */
    private static List<Command> createCommandsForAccessors(CommandExecutor executor, Map<Method, Accessor> accessors) {
        List<Command> storeCommands = new ArrayList<>();
        List<Command> verifyCommands = new ArrayList<>();
        List<Command> verifyNotCommands = new ArrayList<>();
        List<Command> verifyContainCommands = new ArrayList<>();
        List<Command> verifyNotContainCommands = new ArrayList<>();
        List<Command> verifyMatchCommands = new ArrayList<>();
        List<Command> verifyNotMatchCommands = new ArrayList<>();
        List<Command> assertCommands = new ArrayList<>();
        List<Command> assertNotCommands = new ArrayList<>();
        List<Command> assertContainCommands = new ArrayList<>();
        List<Command> assertNotContainCommands = new ArrayList<>();
        List<Command> assertMatchCommands = new ArrayList<>();
        List<Command> assertNotMatchCommands = new ArrayList<>();
        List<Command> waitCommands = new ArrayList<>();
        List<Command> waitNotCommands = new ArrayList<>();
        List<Command> waitContainCommands = new ArrayList<>();
        List<Command> waitNotContainCommands = new ArrayList<>();
        List<Command> waitMatchCommands = new ArrayList<>();
        List<Command> waitNotMatchCommands = new ArrayList<>();
        List<Command> executeCommands = new ArrayList<>();
        List<Command> executeNotCommands = new ArrayList<>();
        List<Command> executeContainCommands = new ArrayList<>();
        List<Command> executeNotContainCommands = new ArrayList<>();
        List<Command> executeMatchCommands = new ArrayList<>();
        List<Command> executeNotMatchCommands = new ArrayList<>();
        for (Method method : accessors.keySet()) {
            String regex = "^(get|is)([A-Z].+)$";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(method.getName());

            if (matcher.find()) {
                String baseName = StringUtils.capitalize(matcher.group(2));
                Accessor accessor = accessors.get(method);
                int paramCount = countParam(accessor);
                boolean isString = "get".equals(matcher.group(1)) && (String.class.equals(method.getReturnType()) || String[].class.equals(method.getReturnType()));
                boolean isBool = "is".equals(matcher.group(1));

                if ("parentLocator".equals(accessor.param1()) && "locator".equals(accessor.param2())) {
                    if (accessor.verifyCmd()) {
                        verifyCommands.add(createLocatorCommandForAccessor(executor, method, accessor, "verify", baseName, isBool));
                        verifyNotCommands.add(createLocatorCommandForAccessor(executor, method, accessor, "verify", invertPredicateName(baseName), isBool));
                        assertCommands.add(createLocatorCommandForAccessor(executor, method, accessor, "assert", baseName, isBool));
                        assertNotCommands.add(createLocatorCommandForAccessor(executor, method, accessor, "assert", invertPredicateName(baseName), isBool));
                    }
                    if (!isBool && accessor.storeCmd()) {
                        storeCommands.add(createLocatorCommandForAccessor(executor, method, accessor, "store", baseName, false));
                    }
                    if (accessor.waitCmd()) {
                        waitCommands.add(createLocatorCommandForAccessor(executor, method, accessor, "waitFor", baseName, isBool));
                        waitNotCommands.add(createLocatorCommandForAccessor(executor, method, accessor, "waitFor", invertPredicateName(baseName), isBool));
                    }
                    if (accessor.executeCmd()) {
                        executeCommands.add(createLocatorCommandForAccessor(executor, method, accessor, "executeIf", baseName, isBool));
                        executeNotCommands.add(createLocatorCommandForAccessor(executor, method, accessor, "executeIf", invertPredicateName(baseName), isBool));
                    }

                    if (isString) {
                        if (accessor.verifyCmd()) {
//                            verifyContainCommands.add(createLocatorCommandForAccessor(executor, method, accessor, "verify", baseName + "Contain", isBool));
//                            verifyNotContainCommands.add(createLocatorCommandForAccessor(executor, method, accessor, "verify", invertPredicateName(baseName + "Contain"), isBool));
//                            assertContainCommands.add(createLocatorCommandForAccessor(executor, method, accessor, "assert", baseName + "Contain", isBool));
//                            assertNotContainCommands.add(createLocatorCommandForAccessor(executor, method, accessor, "assert", invertPredicateName(baseName + "Contain"), isBool));
                            verifyMatchCommands.add(createLocatorCommandForAccessor(executor, method, accessor, "verify", baseName + "Match", isBool));
                            verifyNotMatchCommands.add(createLocatorCommandForAccessor(executor, method, accessor, "verify", invertPredicateName(baseName + "Match"), isBool));
                            assertMatchCommands.add(createLocatorCommandForAccessor(executor, method, accessor, "assert", baseName + "Match", isBool));
                            assertNotMatchCommands.add(createLocatorCommandForAccessor(executor, method, accessor, "assert", invertPredicateName(baseName + "Match"), isBool));
                        }
                        if (accessor.waitCmd()) {
//                            waitContainCommands.add(createLocatorCommandForAccessor(executor, method, accessor, "waitFor", baseName + "Contain", isBool));
//                            waitNotContainCommands.add(createLocatorCommandForAccessor(executor, method, accessor, "waitFor", invertPredicateName(baseName + "Contain"), isBool));
                            waitMatchCommands.add(createLocatorCommandForAccessor(executor, method, accessor, "waitFor", baseName + "Match", isBool));
                            waitNotMatchCommands.add(createLocatorCommandForAccessor(executor, method, accessor, "waitFor", invertPredicateName(baseName + "Match"), isBool));
                        }
                        if (accessor.executeCmd()) {
//                            executeContainCommands.add(createLocatorCommandForAccessor(executor, method, accessor, "executeIf", baseName + "Contain", isBool));
//                            executeNotContainCommands.add(createLocatorCommandForAccessor(executor, method, accessor, "executeIf", invertPredicateName(baseName + "Contain"), isBool));
                            executeMatchCommands.add(createLocatorCommandForAccessor(executor, method, accessor, "executeIf", baseName + "Match", isBool));
                            executeNotMatchCommands.add(createLocatorCommandForAccessor(executor, method, accessor, "executeIf", invertPredicateName(baseName + "Match"), isBool));
                        }
                    }
                }
                if (accessor.verifyCmd()) {
                    verifyCommands.add(createCommandForAccessor(executor, method, accessor, "verify", baseName, isBool));
                    verifyNotCommands.add(createCommandForAccessor(executor, method, accessor, "verify", invertPredicateName(baseName), isBool));
                    assertCommands.add(createCommandForAccessor(executor, method, accessor, "assert", baseName, isBool));
                    assertNotCommands.add(createCommandForAccessor(executor, method, accessor, "assert", invertPredicateName(baseName), isBool));
                }
                if (!"variable".equals(accessor.param1())) {
                    if (!isBool && accessor.storeCmd()) {
                        storeCommands.add(createCommandForAccessor(executor, method, accessor, "store", baseName, false));
                    }
                    if (accessor.waitCmd()) {
                        waitCommands.add(createCommandForAccessor(executor, method, accessor, "waitFor", baseName, isBool));
                        waitNotCommands.add(createCommandForAccessor(executor, method, accessor, "waitFor", invertPredicateName(baseName), isBool));
                    }
                }
                if ((isBool || paramCount < 2) && accessor.executeCmd()) {
                    executeCommands.add(createCommandForAccessor(executor, method, accessor, "executeIf", baseName, isBool));
                    executeNotCommands.add(createCommandForAccessor(executor, method, accessor, "executeIf", invertPredicateName(baseName), isBool));
                }

                if (isString) {
                    if (accessor.verifyCmd()) {
//                        verifyContainCommands.add(createCommandForAccessor(executor, method, accessor, "verify", baseName + "Contain", isBool));
//                        verifyNotContainCommands.add(createCommandForAccessor(executor, method, accessor, "verify", invertPredicateName(baseName + "Contain"), isBool));
//                        assertContainCommands.add(createCommandForAccessor(executor, method, accessor, "assert", baseName + "Contain", isBool));
//                        assertNotContainCommands.add(createCommandForAccessor(executor, method, accessor, "assert", invertPredicateName(baseName + "Contain"), isBool));
                        verifyMatchCommands.add(createCommandForAccessor(executor, method, accessor, "verify", baseName + "Match", isBool));
                        verifyNotMatchCommands.add(createCommandForAccessor(executor, method, accessor, "verify", invertPredicateName(baseName + "Match"), isBool));
                        assertMatchCommands.add(createCommandForAccessor(executor, method, accessor, "assert", baseName + "Match", isBool));
                        assertNotMatchCommands.add(createCommandForAccessor(executor, method, accessor, "assert", invertPredicateName(baseName + "Match"), isBool));
                    }
                    if (!"variable".equals(accessor.param1()) && accessor.waitCmd()) {
//                        waitContainCommands.add(createCommandForAccessor(executor, method, accessor, "waitFor", baseName + "Contain", isBool));
//                        waitNotContainCommands.add(createCommandForAccessor(executor, method, accessor, "waitFor", invertPredicateName(baseName + "Contain"), isBool));
                        waitMatchCommands.add(createCommandForAccessor(executor, method, accessor, "waitFor", baseName + "Match", isBool));
                        waitNotMatchCommands.add(createCommandForAccessor(executor, method, accessor, "waitFor", invertPredicateName(baseName + "Match"), isBool));
                    }
                    if (paramCount < 2 && accessor.executeCmd()) {
//                        executeContainCommands.add(createCommandForAccessor(executor, method, accessor, "executeIf", baseName + "Contain", isBool));
//                        executeNotContainCommands.add(createCommandForAccessor(executor, method, accessor, "executeIf", invertPredicateName(baseName + "Contain"), isBool));
                        executeMatchCommands.add(createCommandForAccessor(executor, method, accessor, "executeIf", baseName + "Match", isBool));
                        executeNotMatchCommands.add(createCommandForAccessor(executor, method, accessor, "executeIf", invertPredicateName(baseName + "Match"), isBool));
                    }
                }
            }
        }
        List<Command> commands = new ArrayList<>();
        commands.addAll(storeCommands);
        commands.addAll(verifyCommands);
        commands.addAll(verifyNotCommands);
        commands.addAll(verifyContainCommands);
        commands.addAll(verifyNotContainCommands);
        commands.addAll(verifyMatchCommands);
        commands.addAll(verifyNotMatchCommands);
        commands.addAll(assertCommands);
        commands.addAll(assertNotCommands);
        commands.addAll(assertContainCommands);
        commands.addAll(assertNotContainCommands);
        commands.addAll(assertMatchCommands);
        commands.addAll(assertNotMatchCommands);
        commands.addAll(waitCommands);
        commands.addAll(waitNotCommands);
        commands.addAll(waitContainCommands);
        commands.addAll(waitNotContainCommands);
        commands.addAll(waitMatchCommands);
        commands.addAll(waitNotMatchCommands);
        commands.addAll(executeCommands);
        commands.addAll(executeNotCommands);
        commands.addAll(executeContainCommands);
        commands.addAll(executeNotContainCommands);
        commands.addAll(executeMatchCommands);
        commands.addAll(executeNotMatchCommands);

        return commands;
    }

    /**
     * Creates a command from an action of the command executor.
     *
     * @param executor the command executor
     * @param method   the method
     * @param action   the action
     * @param baseName the command base name
     * @return the command
     */
    private static Command createCommand(CommandExecutor executor, Method method, Action action, String baseName) {
        int paramCount = countParam(action);
        Command command = new Command();
        command.setName(addSpaceToCamelCase(baseName));
        command.setMethod(StringUtils.uncapitalize(baseName));
        command.setParam1(action.param1());
        command.setParam2(action.param2());
        command.setParam3(action.param3());
        command.setWeb(action.web());
        command.setAndroid(action.android());
        command.setIos(action.ios());
        command.setSourceMethodKey(method.getName() + "(" + method.getParameterCount() + ")");
        command.setConsumer((param1, param2, param3) -> {
            if (paramCount == 0) {
                method.invoke(executor);
            } else if (paramCount == 1) {
                method.invoke(executor, param1);
            } else if (paramCount == 2) {
                method.invoke(executor, param1, param2);
            } else if (paramCount == 3) {
                method.invoke(executor, param1, param2, param3);
            }
        });

        return command;
    }

    /**
     * Creates a command from an action of the command executor.
     * The provided action must have both parentLocator and locator parameters.
     *
     * @param executor the command executor
     * @param method   the method
     * @param action   the action
     * @param baseName the command base name
     * @return the command
     */
    private static Command createLocatorCommand(CommandExecutor executor, Method method, Action action, String baseName) {
        int paramCount = countParam(action);
        Command command = new Command();
        command.setName(addSpaceToCamelCase(baseName));
        command.setMethod(StringUtils.uncapitalize(baseName));
        if ("parentLocator".equals(action.param1())) {
            command.setParam1(action.param2());
            command.setParam2(action.param3());
            command.setParam3("");

            command.setConsumer((param1, param2, param3) -> {
                if (paramCount == 2) {
                    method.invoke(executor, null, param1);
                } else if (paramCount == 3) {
                    method.invoke(executor, null, param1, param2);
                }
            });
        } else if ("parentLocator".equals(action.param2())) {
            command.setParam1(action.param1());
            command.setParam2(action.param3());
            command.setParam3("");

            command.setConsumer((param1, param2, param3) -> method.invoke(executor, param1, null, param2));
        }
        command.setWeb(action.web());
        command.setAndroid(action.android());
        command.setIos(action.ios());
        command.setSourceMethodKey(method.getName() + "(" + method.getParameterCount() + ")");

        return command;
    }

    /**
     * Creates a command from an accessor of the command executor.
     *
     * @param executor the command executor
     * @param method   the method
     * @param accessor the accessor
     * @param baseName the command base name
     * @param isBool   is boolean method
     * @return the command
     */
    private static Command createCommandForAccessor(CommandExecutor executor, Method method, Accessor accessor, String action, String baseName, boolean isBool) {
        int paramCount = countParam(accessor);
        String paramName = action.startsWith("store") ? "variable" : (isBool ? "" : "text");
        Command command = new Command();
        command.setName(addSpaceToCamelCase(StringUtils.capitalize(action) + baseName));
        command.setMethod(action + baseName);
        if (action.startsWith("execute")) {
            command.setParam1("action");
            command.setParam2(paramCount == 0 ? paramName : accessor.param1());
            command.setParam3(paramCount == 1 ? paramName : accessor.param2());

            command.setConsumer((param1, param2, param3) -> {
                try {
                    assertValue(executor, method, baseName, param2, param3, null, paramCount, isBool);
                    executor.runAction((String) param1);
                } catch (AssertFailedException e) {
                    LOG.debug(e.getMessage());
                }
            });
        } else {
            command.setParam1(paramCount == 0 ? paramName : accessor.param1());
            command.setParam2(paramCount == 1 ? paramName : accessor.param2());
            command.setParam3(paramCount == 2 ? paramName : "");

            if (action.startsWith("storePush")) {
//                command.setConsumer((param1, param2, param3) -> storePushValue(executor, method, param1, param2, param3, paramCount));
            } else if (action.startsWith("store")) {
                command.setConsumer((param1, param2, param3) -> storeValue(executor, method, param1, param2, param3, paramCount));
            } else if (action.startsWith("verify") || action.startsWith("assert")) {
                command.setConsumer((param1, param2, param3) -> assertValue(executor, method, baseName, param1, param2, param3, paramCount, isBool));
            } else if (action.startsWith("waitFor")) {
                command.setConsumer((param1, param2, param3) -> {
                    WebDriverWait wait = executor.createWebDriverWait();
                    wait.until(getExpectedCondition(executor, method, baseName, param1, param2, param3, paramCount, isBool));
                });
            }
        }
        command.setWeb(accessor.web());
        command.setAndroid(accessor.android());
        command.setIos(accessor.ios());
        command.setSourceMethodKey(method.getName() + "(" + method.getParameterCount() + ")");

        return command;
    }

    /**
     * Creates a command from an accessor of the command executor.
     * The provided accessor must have both parentLocator and locator parameters.
     *
     * @param executor the command executor
     * @param method   the method
     * @param accessor the accessor
     * @param baseName the command base name
     * @param isBool   is boolean method
     * @return the command
     */
    private static Command createLocatorCommandForAccessor(CommandExecutor executor, Method method, Accessor accessor, String action, String baseName, boolean isBool) {
        String paramName = action.startsWith("store") ? "variable" : (isBool ? "" : "text");
        Command command = new Command();
        command.setName(addSpaceToCamelCase(StringUtils.capitalize(action) + baseName));
        command.setMethod(action + baseName);
        if (action.startsWith("execute")) {
            command.setParam1("action");
            command.setParam2("locator");
            command.setParam3(paramName);

            command.setConsumer((param1, param2, param3) -> {
                try {
                    assertValue(executor, method, baseName, null, param2, param3, 2, isBool);
                    executor.runAction((String) param1);
                } catch (AssertFailedException e) {
                    LOG.debug(e.getMessage());
                }
            });
        } else {
            command.setParam1("locator");
            command.setParam2(paramName);
            command.setParam3("");

            if (action.startsWith("storePush")) {
//                command.setConsumer((param1, param2, param3) -> storePushValue(executor, method, null, param1, param2, 2));
            } else if (action.startsWith("store")) {
                command.setConsumer((param1, param2, param3) -> storeValue(executor, method, null, param1, param2, 2));
            } else if (action.startsWith("verify") || action.startsWith("assert")) {
                command.setConsumer((param1, param2, param3) -> assertValue(executor, method, baseName, null, param1, param2, 2, isBool));
            } else if (action.startsWith("waitFor")) {
                command.setConsumer((param1, param2, param3) -> {
                    WebDriverWait wait = executor.createWebDriverWait();
                    wait.until(getExpectedCondition(executor, method, baseName, null, param1, param2, 2, isBool));
                });
            }
        }
        command.setWeb(accessor.web());
        command.setAndroid(accessor.android());
        command.setIos(accessor.ios());
        command.setSourceMethodKey(method.getName() + "(" + method.getParameterCount() + ")");

        return command;
    }

    /**
     * Checks whether the command is available on the provided environment.
     *
     * @param annotation command annotation. Either action or accessor
     * @param webDriver  the context aware web driver
     * @return true if the command is available, otherwise, false
     */
    private static boolean isCommandAvailable(Object annotation, ContextAwareWebDriver webDriver) {
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
        if (web && webDriver.isWeb()) {
            return true;
        }
        if (android && webDriver.isAndroid()) {
            return true;
        }
        if (ios && webDriver.isIOS()) {
            return true;
        }
        return false;
    }

    /**
     * Inverts predicate name.
     *
     * @param baseName the base name
     * @return inverted name
     */
    private static String invertPredicateName(String baseName) {
        String verbs = "Present|Contain|Match";
        String regex = "^((?:(?!(?:" + verbs + ")).)+)(" + verbs + ")(.*)$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(baseName);

        if (matcher.find()) {
            return matcher.group(1) + "Not" + matcher.group(2) + matcher.group(3);
        }
        return "Not" + baseName;
    }

    /**
     * Count the number of parameters of the action.
     *
     * @param action the action
     * @return the number of parameters
     */
    private static int countParam(Action action) {
        int count = 0;
        if (StringUtils.isNotBlank(action.param1())) count++;
        if (StringUtils.isNotBlank(action.param2())) count++;
        if (StringUtils.isNotBlank(action.param3())) count++;
        return count;
    }

    /**
     * Count the number of parameters of the accessor.
     *
     * @param accessor the accessor
     * @return the number of parameters
     */
    private static int countParam(Accessor accessor) {
        int count = 0;
        if (StringUtils.isNotBlank(accessor.param1())) count++;
        if (StringUtils.isNotBlank(accessor.param2())) count++;
        return count;
    }

    /**
     * Count the number of parameters of the command.
     *
     * @param command the command
     * @return the number of parameters
     */
    private static int countParam(Command command) {
        int count = 0;
        if (StringUtils.isNotBlank(command.getParam1())) count++;
        if (StringUtils.isNotBlank(command.getParam2())) count++;
        if (StringUtils.isNotBlank(command.getParam3())) count++;
        return count;
    }

    /**
     * Gets expected condition.
     *
     * @param executor   the command executor
     * @param method     the method
     * @param baseName   the base name
     * @param param1     the parameter 1
     * @param param2     the parameter 2
     * @param param3     the parameter 3
     * @param paramCount the parameter count
     * @param isBool     is boolean method
     * @return the expected condition
     */
    private static ExpectedCondition<Boolean> getExpectedCondition(CommandExecutor executor, Method method, String baseName, Object param1, Object param2, Object param3, int paramCount, boolean isBool) {
        return driver -> {
            try {
                assertValue(executor, method, baseName, param1, param2, param3, paramCount, isBool);
                return true;
            } catch (Exception e) {
                return false;
            }
        };
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
     * Store value.
     *
     * @param executor   the command executor
     * @param method     the method
     * @param param1     the parameter 1
     * @param param2     the parameter 2
     * @param param3     the parameter 3
     * @param paramCount the parameter count
     * @throws InvocationTargetException the invocation target exception
     * @throws IllegalAccessException    the illegal access exception
     */
    private static void storeValue(CommandExecutor executor, Method method, Object param1, Object param2, Object param3, int paramCount) throws InvocationTargetException, IllegalAccessException {
        Object value = getAccessorValue(executor, method, param1, param2, paramCount);
        if (paramCount == 0) {
            executor.getWebDriver().setVariable(value, (String) param1);
        } else if (paramCount == 1) {
            executor.getWebDriver().setVariable(value, (String) param2);
        } else if (paramCount == 2) {
            executor.getWebDriver().setVariable(value, (String) param3);
        }
    }

    /**
     * Assert value.
     *
     * @param executor   the command executor
     * @param method     the method
     * @param baseName   the base name
     * @param param1     the parameter 1
     * @param param2     the parameter 2
     * @param param3     the parameter 3
     * @param paramCount the parameter count
     * @param isBool     is boolean method
     * @throws IllegalAccessException    the illegal access exception
     * @throws AssertFailedException     the assert failed exception
     * @throws InvocationTargetException the invocation target exception
     */
    private static void assertValue(CommandExecutor executor, Method method, String baseName, Object param1, Object param2, Object param3, int paramCount, boolean isBool) throws IllegalAccessException, AssertFailedException, InvocationTargetException {
        if (baseName.contains("NotContain") && !baseName.contains("NotContainElement")) {
            assertStringNotContain(executor, method, param1, param2, param3, paramCount);
        } else if (baseName.contains("Contain") && !baseName.contains("ContainElement")) {
            assertStringContains(executor, method, param1, param2, param3, paramCount);
        } else if (baseName.contains("NotMatch")) {
            assertStringNotMatch(executor, method, param1, param2, param3, paramCount);
        } else if (baseName.contains("Match")) {
            assertStringMatches(executor, method, param1, param2, param3, paramCount);
        } else if (baseName.contains("Not")) {
            assertValueNotToBe(executor, method, param1, param2, param3, paramCount, isBool);
        } else {
            assertValueToBe(executor, method, param1, param2, param3, paramCount, isBool);
        }
    }

    /**
     * Assert value to be.
     *
     * @param executor   the command executor
     * @param method     the method
     * @param param1     the parameter 1
     * @param param2     the parameter 2
     * @param param3     the parameter 3
     * @param paramCount the parameter count
     * @param isBool     is boolean method
     * @throws InvocationTargetException the invocation target exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws AssertFailedException     the assert failed exception
     */
    private static void assertValueToBe(CommandExecutor executor, Method method, Object param1, Object param2, Object param3, int paramCount, boolean isBool) throws InvocationTargetException, IllegalAccessException, AssertFailedException {
        Object value = getAccessorValue(executor, method, param1, param2, paramCount);
        if (value == null) {
            throw new AssertFailedException("Actual value is null.");
        }
        if (isBool) {
            if (!(Boolean) value) throw new AssertFailedException("Actual value is FALSE.");
        } else {
            if (value instanceof String || value.getClass().equals(String[].class)) {
                String actual = getStringValue(value);
                if (paramCount == 0) {
                    if (!actual.equals(executor.normalizeText((String) param1)))
                        throw new AssertFailedException("Actual text '" + actual + "' did not match '" + param1 + "'");
                } else if (paramCount == 1) {
                    if (!actual.equals(executor.normalizeText((String) param2)))
                        throw new AssertFailedException("Actual text '" + actual + "' did not match '" + param2 + "'");
                } else if (paramCount == 2) {
                    if (!actual.equals(executor.normalizeText((String) param3)))
                        throw new AssertFailedException("Actual text '" + actual + "' did not match '" + param3 + "'");
                } else {
                    throw new AssertFailedException("Number of parameters is invalid. Param count is " + paramCount);
                }
            } else {
                if (paramCount == 0) {
                    if (!checkEquals((String) param1, value))
                        throw new AssertFailedException("Actual value '" + value + "' did not match '" + param1 + "'");
                } else if (paramCount == 1) {
                    if (!checkEquals((String) param2, value))
                        throw new AssertFailedException("Actual value '" + value + "' did not match '" + param2 + "'");
                } else if (paramCount == 2) {
                    if (!checkEquals((String) param3, value))
                        throw new AssertFailedException("Actual value '" + value + "' did not match '" + param3 + "'");
                } else {
                    throw new AssertFailedException("Number of parameters is invalid. Param count is " + paramCount);
                }
            }
        }
    }

    /**
     * Assert value not to be.
     *
     * @param executor   the command executor
     * @param method     the method
     * @param param1     the parameter 1
     * @param param2     the parameter 2
     * @param param3     the parameter 3
     * @param paramCount the parameter count
     * @param isBool     is boolean method
     * @throws InvocationTargetException the invocation target exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws AssertFailedException     the assert failed exception
     */
    private static void assertValueNotToBe(CommandExecutor executor, Method method, Object param1, Object param2, Object param3, int paramCount, boolean isBool) throws InvocationTargetException, IllegalAccessException, AssertFailedException {
        Object value = getAccessorValue(executor, method, param1, param2, paramCount);
        if (value == null) {
            throw new AssertFailedException("Actual value is null.");
        }
        if (isBool) {
            if ((Boolean) value) throw new AssertFailedException("Actual value is TRUE.");
        } else {
            if (value instanceof String || value.getClass().equals(String[].class)) {
                String actual = getStringValue(value);
                if (paramCount == 0) {
                    if (actual.equals(executor.normalizeText((String) param1)))
                        throw new AssertFailedException("Actual text '" + actual + "' did match '" + param1 + "'");
                } else if (paramCount == 1) {
                    if (actual.equals(executor.normalizeText((String) param2)))
                        throw new AssertFailedException("Actual text '" + actual + "' did match '" + param2 + "'");
                } else if (paramCount == 2) {
                    if (actual.equals(executor.normalizeText((String) param3)))
                        throw new AssertFailedException("Actual text '" + actual + "' did match '" + param3 + "'");
                } else {
                    throw new AssertFailedException("Number of parameters is invalid. Param count is " + paramCount);
                }
            } else {
                if (paramCount == 0) {
                    if (checkEquals((String) param1, value))
                        throw new AssertFailedException("Actual value '" + value + "' did match '" + param1 + "'");
                } else if (paramCount == 1) {
                    if (checkEquals((String) param2, value))
                        throw new AssertFailedException("Actual value '" + value + "' did match '" + param2 + "'");
                } else if (paramCount == 2) {
                    if (checkEquals((String) param3, value))
                        throw new AssertFailedException("Actual value '" + value + "' did match '" + param3 + "'");
                } else {
                    throw new AssertFailedException("Number of parameters is invalid. Param count is " + paramCount);
                }
            }
        }
    }

    /**
     * Assert string contains.
     *
     * @param executor   the command executor
     * @param method     the method
     * @param param1     the parameter 1
     * @param param2     the parameter 2
     * @param param3     the parameter 3
     * @param paramCount the parameter count
     * @throws InvocationTargetException the invocation target exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws AssertFailedException     the assert failed exception
     */
    private static void assertStringContains(CommandExecutor executor, Method method, Object param1, Object param2, Object param3, int paramCount) throws InvocationTargetException, IllegalAccessException, AssertFailedException {
        Object value = getAccessorValue(executor, method, param1, param2, paramCount);
        if (value == null) {
            throw new AssertFailedException("Actual value is null.");
        }
        String actual = getStringValue(value);
        if (paramCount == 0) {
            if (!actual.contains(executor.normalizeText((String) param1)))
                throw new AssertFailedException("Actual text '" + actual + "' did not contain '" + param1 + "'");
        } else if (paramCount == 1) {
            if (!actual.contains(executor.normalizeText((String) param2)))
                throw new AssertFailedException("Actual text '" + actual + "' did not contain '" + param2 + "'");
        } else if (paramCount == 2) {
            if (!actual.contains(executor.normalizeText((String) param3)))
                throw new AssertFailedException("Actual text '" + actual + "' did not contain '" + param3 + "'");
        } else {
            throw new AssertFailedException("Number of parameters is invalid. Param count is " + paramCount);
        }
    }

    /**
     * Assert string not contain.
     *
     * @param executor   the command executor
     * @param method     the method
     * @param param1     the parameter 1
     * @param param2     the parameter 2
     * @param param3     the parameter 3
     * @param paramCount the parameter count
     * @throws InvocationTargetException the invocation target exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws AssertFailedException     the assert failed exception
     */
    private static void assertStringNotContain(CommandExecutor executor, Method method, Object param1, Object param2, Object param3, int paramCount) throws InvocationTargetException, IllegalAccessException, AssertFailedException {
        Object value = getAccessorValue(executor, method, param1, param2, paramCount);
        if (value == null) {
            throw new AssertFailedException("Actual value is null.");
        }
        String actual = getStringValue(value);
        if (paramCount == 0) {
            if (actual.contains(executor.normalizeText((String) param1)))
                throw new AssertFailedException("Actual text '" + actual + "' did contain '" + param1 + "'");
        } else if (paramCount == 1) {
            if (actual.contains(executor.normalizeText((String) param2)))
                throw new AssertFailedException("Actual text '" + actual + "' did contain '" + param2 + "'");
        } else if (paramCount == 2) {
            if (actual.contains(executor.normalizeText((String) param3)))
                throw new AssertFailedException("Actual text '" + actual + "' did contain '" + param3 + "'");
        } else {
            throw new AssertFailedException("Number of parameters is invalid. Param count is " + paramCount);
        }
    }

    /**
     * Assert string matches a given pattern.
     *
     * @param executor   the command executor
     * @param method     the method
     * @param param1     the parameter 1
     * @param param2     the parameter 2
     * @param param3     the parameter 3
     * @param paramCount the parameter count
     * @throws InvocationTargetException the invocation target exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws AssertFailedException     the assert failed exception
     */
    private static void assertStringMatches(CommandExecutor executor, Method method, Object param1, Object param2, Object param3, int paramCount) throws InvocationTargetException, IllegalAccessException, AssertFailedException {
        Object value = getAccessorValue(executor, method, param1, param2, paramCount);
        if (value == null) {
            throw new AssertFailedException("Actual value is null.");
        }
        String actual = getStringValue(value);
        if (paramCount == 0) {
            if (!Pattern.compile(executor.normalizeText((String) param1), Pattern.MULTILINE).matcher(actual).find())
                throw new AssertFailedException("Actual text '" + actual + "' did not match '" + param1 + "'");
        } else if (paramCount == 1) {
            if (!Pattern.compile(executor.normalizeText((String) param2), Pattern.MULTILINE).matcher(actual).find())
                throw new AssertFailedException("Actual text '" + actual + "' did not match '" + param2 + "'");
        } else if (paramCount == 2) {
            if (!Pattern.compile(executor.normalizeText((String) param3), Pattern.MULTILINE).matcher(actual).find())
                throw new AssertFailedException("Actual text '" + actual + "' did not match '" + param3 + "'");
        } else {
            throw new AssertFailedException("Number of parameters is invalid. Param count is " + paramCount);
        }
    }

    /**
     * Assert string not match a given pattern.
     *
     * @param executor   the command executor
     * @param method     the method
     * @param param1     the parameter 1
     * @param param2     the parameter 2
     * @param param3     the parameter 3
     * @param paramCount the parameter count
     * @throws InvocationTargetException the invocation target exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws AssertFailedException     the assert failed exception
     */
    private static void assertStringNotMatch(CommandExecutor executor, Method method, Object param1, Object param2, Object param3, int paramCount) throws InvocationTargetException, IllegalAccessException, AssertFailedException {
        Object value = getAccessorValue(executor, method, param1, param2, paramCount);
        if (value == null) {
            throw new AssertFailedException("Actual value is null.");
        }
        String actual = getStringValue(value);
        if (paramCount == 0) {
            if (Pattern.compile(executor.normalizeText((String) param1), Pattern.MULTILINE).matcher(actual).find())
                throw new AssertFailedException("Actual text '" + actual + "' did match '" + param1 + "'");
        } else if (paramCount == 1) {
            if (Pattern.compile(executor.normalizeText((String) param2), Pattern.MULTILINE).matcher(actual).find())
                throw new AssertFailedException("Actual text '" + actual + "' did match '" + param2 + "'");
        } else if (paramCount == 2) {
            if (Pattern.compile(executor.normalizeText((String) param3), Pattern.MULTILINE).matcher(actual).find())
                throw new AssertFailedException("Actual text '" + actual + "' did match '" + param3 + "'");
        } else {
            throw new AssertFailedException("Number of parameters is invalid. Param count is " + paramCount);
        }
    }

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

    /**
     * Returns the string representation of a value.
     * If the given value is in string array format, join the element delimited by new line character.
     *
     * @param value the value object
     * @return the string representation
     */
    private static String getStringValue(Object value) {
        if (value instanceof String) {
            return (String) value;
        } else {
            return StringUtils.join((String[]) value, "\n");
        }
    }
}
