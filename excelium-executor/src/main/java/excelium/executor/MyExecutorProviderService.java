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

package excelium.executor;

import excelium.core.CommandExecutor;
import excelium.core.driver.ContextAwareWebDriver;
import excelium.core.service.ExecutorProviderService;
import excelium.executor.mobile.app.ActivityCommandExecutor;
import excelium.executor.mobile.app.AppCommandExecutor;
import excelium.executor.mobile.app.DeviceCommandExecutor;
import excelium.executor.mobile.common.GestureCommandExecutor;
import excelium.executor.mobile.common.SessionCommandExecutor;
import excelium.executor.web.common.CookieCommandExecutor;
import excelium.executor.web.common.LogCommandExecutor;
import excelium.executor.web.common.TableCommandExecutor;
import excelium.executor.web.common.WindowCommandExecutor;
import excelium.executor.web.pc.FileCommandExecutor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Custom implementation of {@link ExecutorProviderService}.
 *
 * @author PhungDucKien
 * @since 2018.05.29
 */
public class MyExecutorProviderService implements ExecutorProviderService {

    @Override
    public List<Class<? extends CommandExecutor>> getWebExecutorClasses(ContextAwareWebDriver driver) {
        List<Class<? extends CommandExecutor>> executorClasses = new ArrayList<>(Arrays.asList(
                // Web
                CookieCommandExecutor.class,
                LogCommandExecutor.class,
                TableCommandExecutor.class,

                // Common
                AlertCommandExecutor.class,
                AttributeCommandExecutor.class,
                CollectionCommandExecutor.class,
                DatabaseCommandExecutor.class,
                DateCommandExecutor.class,
                DebugCommandExecutor.class,
                ElementCommandExecutor.class,
                EvalCommandExecutor.class,
                EventCommandExecutor.class,
                ExecuteCommandExecutor.class,
                NavigateCommandExecutor.class,
                PageCommandExecutor.class,
                ScreenshotCommandExecutor.class,
                StoreCommandExecutor.class,
                WaitCommandExecutor.class
        ));

        // File
        if (driver.isPC()) {
            executorClasses.add(FileCommandExecutor.class);
        }

        // Mobile Common
        if (driver.isMobile()) {
            executorClasses.add(GestureCommandExecutor.class);
            executorClasses.add(SessionCommandExecutor.class);
        }

        // Web Common
        if (driver.isWebApp()) {
            executorClasses.add(WindowCommandExecutor.class);
        }

        // Context
        if (driver.isMobileApp()) {
            executorClasses.add(ContextCommandExecutor.class);
        }

        return executorClasses;
    }

    @Override
    public List<Class<? extends CommandExecutor>> getMobileExecutorClasses(ContextAwareWebDriver driver) {
        List<Class<? extends CommandExecutor>> executorClasses = new ArrayList<>(Arrays.asList(
                // Mobile
                AppCommandExecutor.class,
                DeviceCommandExecutor.class,

                // Mobile Common
                GestureCommandExecutor.class,
                SessionCommandExecutor.class,

                // Context
                ContextCommandExecutor.class,

                // Common
                AlertCommandExecutor.class,
                AttributeCommandExecutor.class,
                CollectionCommandExecutor.class,
                DatabaseCommandExecutor.class,
                DateCommandExecutor.class,
                DebugCommandExecutor.class,
                ElementCommandExecutor.class,
                EvalCommandExecutor.class,
                EventCommandExecutor.class,
                ExecuteCommandExecutor.class,
                NavigateCommandExecutor.class,
                PageCommandExecutor.class,
                ScreenshotCommandExecutor.class,
                StoreCommandExecutor.class,
                WaitCommandExecutor.class
        ));

        // Android
        if (driver.isAndroid()) {
            executorClasses.add(ActivityCommandExecutor.class);
        }

        return executorClasses;
    }
}
