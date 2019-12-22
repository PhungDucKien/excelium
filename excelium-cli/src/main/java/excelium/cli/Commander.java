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

package excelium.cli;

import com.beust.jcommander.JCommander;
import excelium.cli.annotation.Bean;
import excelium.cli.annotation.Command;
import excelium.cli.annotation.Controller;
import excelium.cli.annotation.Injectable;
import excelium.cli.controller.BaseController;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Extends {@link JCommander} class.
 * Allows to use object class to add commands via registerControllers method.
 *
 * @author PhungDucKien
 * @since 2018.04.10
 */
public class Commander extends JCommander {

    /**
     * Default object key
     */
    private static final String DEFAULT_OBJECT = "DEFAULT_OBJECT";

    /**
     * Controller instances
     */
    private Map<String, BaseController> controllerObjects = new HashMap<>();

    /**
     * Bean factory instance
     */
    private Object beanFactoryObject;

    /**
     * Mapping bean class type to bean factory method
     */
    private Map<Class, Method> beanMethodMap = new HashMap<>();

    /**
     * Map of bean class type to bean instantiated object
     */
    private Map<Class, Object> beanMap = new HashMap<>();

    /**
     * Registers controllers by using an array of controller classes.
     * Controllers must be annotated with {@link Controller}
     * and their commands must be annotated with {@link Command}.
     * This method constructs and stores controller instances for later command executions.
     *
     * @param classes an array of controller classes
     * @throws IllegalAccessException if an exception is thrown by an illegal access
     * @throws InstantiationException if an exception is thrown by an invoked constructor
     */
    void registerControllers(Class<? extends BaseController>... classes) throws IllegalAccessException, InstantiationException {
        for (Class<? extends BaseController> clazz : classes) {
            Controller controller = clazz.getDeclaredAnnotation(Controller.class);
            if (controller != null) {
                String controllerName = controller.name();
                BaseController controllerObject = clazz.newInstance();
                if (StringUtils.isBlank(controllerName)) {
                    controllerObjects.put(DEFAULT_OBJECT, controllerObject);
                    addObject(controllerObject);
                } else {
                    controllerObjects.put(controllerName, controllerObject);

                    JCommander controllerCommander = addCommand(this, controllerName, controllerObject);
                    for (Method method : clazz.getDeclaredMethods()) {
                        if (Modifier.isPublic(method.getModifiers())) {
                            Command command = method.getDeclaredAnnotation(Command.class);
                            if (command != null) {
                                String commandName = command.name();
                                addCommand(controllerCommander, commandName, controllerObject);
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Registers bean factory by using bean factory class.
     * Provided class must contains methods annotated with {@link Bean}.
     * This method constructs bean factory instance and bean method mappings for latter bean injection.
     *
     * @param beanFactoryClass Bean factory class
     * @throws IllegalAccessException if an exception is thrown by an illegal access
     * @throws InstantiationException if an exception is thrown by an invoked constructor
     */
    void registerBeanFactory(Class beanFactoryClass) throws IllegalAccessException, InstantiationException {
        for (Method method : beanFactoryClass.getDeclaredMethods()) {
            if (Modifier.isPublic(method.getModifiers())) {
                Bean bean = method.getDeclaredAnnotation(Bean.class);
                if (bean != null) {
                    beanMethodMap.put(method.getReturnType(), method);
                }
            }
        }
        beanFactoryObject = beanFactoryClass.newInstance();
    }

    /**
     * Parses the provided arguments, injects the beans and executes corresponding commands.
     *
     * @param args Command line arguments
     * @throws InvocationTargetException if an exception is thrown by an invoked method or constructor
     * @throws IllegalAccessException    if an exception is thrown by an illegal access
     */
    final void execute(String... args) throws InvocationTargetException, IllegalAccessException {
        super.parse(args);

        String controller = getParsedCommand();
        String command = getExecutionCommand();
        BaseController controllerObject;
        if (StringUtils.isBlank(controller)) {
            controllerObject = controllerObjects.get(DEFAULT_OBJECT);
        } else {
            controllerObject = controllerObjects.get(controller);
        }

        if (controllerObject.isHelp()) {
            if (StringUtils.isBlank(controller)) {
                usage();
            } else {
                usage(controller);
            }
            return;
        }

        if (!CollectionUtils.isEmpty(controllerObject.getProperties())) {
            controllerObject.getProperties().forEach(System::setProperty);
        }

        // Finds injectable fields
        List<Field> injectableFields = new ArrayList<>();
        for (Field field : controllerObject.getClass().getDeclaredFields()) {
            Injectable inject = field.getDeclaredAnnotation(Injectable.class);
            if (inject != null) {
                boolean shouldIgnore = StringUtils.isNotBlank(command) && Stream.of(inject.ignore()).anyMatch(command::equals);
                if (!shouldIgnore) {
                    injectableFields.add(field);
                }
            }
        }

        // Injects the beans
        for (Field field : injectableFields) {
            boolean accessible = field.isAccessible();
            if (!accessible) field.setAccessible(true);

            if (beanMap.containsKey(field.getType())) {
                field.set(controllerObject, beanMap.get(field.getType()));
            } else {
                Method beanMethod = beanMethodMap.get(field.getType());
                Object value = invokeBeanMethod(beanMethod);
                field.set(controllerObject, value);
            }

            if (!accessible) field.setAccessible(false);
        }

        // Executes corresponding commands
        for (Method method : controllerObject.getClass().getDeclaredMethods()) {
            if (Modifier.isPublic(method.getModifiers())) {
                Command cmd = method.getDeclaredAnnotation(Command.class);
                if (cmd != null) {
                    if ((StringUtils.isBlank(cmd.name()) && StringUtils.isBlank(command)) || cmd.name().equals(command)) {
                        method.invoke(controllerObject);
                    }
                }
            }
        }
    }

    /**
     * Invokes bean method.
     * If the method depends on other beans, those beans will be resolved before invoking the method.
     *
     * @param method bean method
     * @return the result of the method
     * @throws InvocationTargetException if an exception is thrown by an invoked method or constructor
     * @throws IllegalAccessException    if an exception is thrown by an illegal access
     */
    private Object invokeBeanMethod(Method method) throws InvocationTargetException, IllegalAccessException {
        Class[] parameterTypes = method.getParameterTypes();
        Object[] parameters = new Object[parameterTypes.length];

        int i = 0;
        for (Class type : parameterTypes) {
            if (beanMap.containsKey(type)) {
                parameters[i] = beanMap.get(type);
            } else {
                Method m = beanMethodMap.get(type);
                Object value = invokeBeanMethod(m);
                parameters[i] = value;
            }
            i++;
        }

        Object value = method.invoke(beanFactoryObject, parameters);
        beanMap.put(method.getReturnType(), value);
        return value;
    }

    /**
     * Adds a command to {@link Commander} instance.
     *
     * @param parentCommander Parent JCommander instance
     * @param commandName     Command name
     * @param commandObject   Command object
     * @return Child JCommander instance
     */
    private JCommander addCommand(JCommander parentCommander, String commandName, Object commandObject) {
        parentCommander.addCommand(commandName, commandObject);
        return parentCommander.getCommands().get(commandName);
    }

    /**
     * Get the command name that would be executed.
     *
     * @return Command name
     */
    private String getExecutionCommand() {
        JCommander commander = getCommands().get(getParsedCommand());
        return commander != null ? commander.getParsedCommand() : null;
    }
}
