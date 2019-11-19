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
import excelium.executor.mobile.*;
import excelium.executor.web.*;

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
                WindowCommandExecutor.class,
                PageCommandExecutor.class,
                WebElementCommandExecutor.class,
                EventCommandExecutor.class,
                TableCommandExecutor.class,
                CookieCommandExecutor.class,
                FileCommandExecutor.class,

                // Common
                AlertCommandExecutor.class,
                NavigateCommandExecutor.class,
                ScreenshotCommandExecutor.class,
                AttributeCommandExecutor.class,
                StoreCommandExecutor.class,
                ExecuteCommandExecutor.class,
                WaitCommandExecutor.class,
                DatabaseCommandExecutor.class,
                CollectionCommandExecutor.class,
                DateCommandExecutor.class,
                EvalCommandExecutor.class,
                DebugCommandExecutor.class
        ));

        if (driver.isMobileApp()) {
            executorClasses.add(ContextCommandExecutor.class);
        }

        return executorClasses;
    }

    @Override
    public List<Class<? extends CommandExecutor>> getMobileExecutorClasses(ContextAwareWebDriver driver) {
        return new ArrayList<>(Arrays.asList(
                // Mobile
                SessionCommandExecutor.class,
                DeviceCommandExecutor.class,
                MobilePageCommandExecutor.class,
                MobileElementCommandExecutor.class,
                InteractionCommandExecutor.class,

                // Common
                AlertCommandExecutor.class,
                NavigateCommandExecutor.class,
                ScreenshotCommandExecutor.class,
                AttributeCommandExecutor.class,
                StoreCommandExecutor.class,
                ExecuteCommandExecutor.class,
                WaitCommandExecutor.class,
                DatabaseCommandExecutor.class,
                CollectionCommandExecutor.class,
                DateCommandExecutor.class,
                EvalCommandExecutor.class,
                DebugCommandExecutor.class,
                ContextCommandExecutor.class
        ));
    }
}
