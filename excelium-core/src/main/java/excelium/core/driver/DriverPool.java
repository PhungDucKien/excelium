/*
 * MIT License
 *
 * Copyright (c) 2019 Excelium
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

package excelium.core.driver;

import excelium.model.project.Project;
import excelium.model.test.config.Environment;
import excelium.model.test.config.MobileAppEnvironment;
import excelium.model.test.config.MobileWebEnvironment;
import excelium.model.test.config.PcEnvironment;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DriverPool {

    private DriverAlivenessChecker alivenessChecker = new DriverAlivenessChecker();
    private Map<String, RemoteWebDriver> drivers = new HashMap<>();
    private DriverFactory driverFactory = new DriverFactory();

    private static final DriverPool INSTANCE = new DriverPool();

    private DriverPool() {
        Runtime.getRuntime().addShutdownHook(new Thread(DriverPool.this::dismissAll));
    }

    public static DriverPool getInstance() {
        return INSTANCE;
    }

    public RemoteWebDriver getDriver(Environment environment, Project project) throws IOException {
        String driverKey = createKey(environment);
        if (!drivers.keySet().contains(driverKey)) {
            createNewDriver(environment, project);
        } else {
            RemoteWebDriver driver = drivers.get(driverKey);

            if (driver == null) {
                createNewDriver(environment, project);
            } else {
                // Check the web driver is alive
                if (!alivenessChecker.isAlive(driver)) {
                    dismissDriver(driver);
                    createNewDriver(environment, project);
                }
            }
        }

        return drivers.get(driverKey);
    }

    protected String createKey(Environment environment) {
        StringBuilder keyBuilder = new StringBuilder();
        if (environment instanceof PcEnvironment) {
            if (environment.getPlatform() != null) {
                keyBuilder.append(environment.getPlatform().getText());
            } else {
                keyBuilder.append("null");
            }
            keyBuilder.append("-");
            keyBuilder.append(environment.getPlatformVersion());
            keyBuilder.append("-");
            if (((PcEnvironment) environment).getBrowser() != null) {
                keyBuilder.append(((PcEnvironment) environment).getBrowser().getText());
            } else {
                keyBuilder.append("null");
            }
            keyBuilder.append("-");
            keyBuilder.append(((PcEnvironment) environment).getBrowserVersion());
            keyBuilder.append("-");
            keyBuilder.append(((PcEnvironment) environment).getResolution());
        } else if (environment instanceof MobileWebEnvironment) {
            if (environment.getPlatform() != null) {
                keyBuilder.append(environment.getPlatform().getText());
            } else {
                keyBuilder.append("null");
            }
            keyBuilder.append("-");
            keyBuilder.append(environment.getPlatformVersion());
            keyBuilder.append("-");
            keyBuilder.append(((MobileWebEnvironment) environment).getDeviceName());
            keyBuilder.append("-");
            keyBuilder.append(((MobileWebEnvironment) environment).getUdid());
            keyBuilder.append("-");
            keyBuilder.append(((MobileWebEnvironment) environment).getOrientation());
            keyBuilder.append("-");
            if (((MobileWebEnvironment) environment).getBrowser() != null) {
                keyBuilder.append(((MobileWebEnvironment) environment).getBrowser().getText());
            } else {
                keyBuilder.append("null");
            }
            keyBuilder.append("-");
            keyBuilder.append(((MobileWebEnvironment) environment).getBrowserVersion());
        } else if (environment instanceof MobileAppEnvironment) {
            if (environment.getPlatform() != null) {
                keyBuilder.append(environment.getPlatform().getText());
            } else {
                keyBuilder.append("null");
            }
            keyBuilder.append("-");
            keyBuilder.append(environment.getPlatformVersion());
            keyBuilder.append("-");
            keyBuilder.append(((MobileAppEnvironment) environment).getDeviceName());
            keyBuilder.append("-");
            keyBuilder.append(((MobileAppEnvironment) environment).getUdid());
            keyBuilder.append("-");
            keyBuilder.append(((MobileAppEnvironment) environment).getOrientation());
            keyBuilder.append("-");
            keyBuilder.append(((MobileAppEnvironment) environment).getAppPath());
            keyBuilder.append("-");
            keyBuilder.append(((MobileAppEnvironment) environment).getAppActivity());
            keyBuilder.append("-");
            keyBuilder.append(((MobileAppEnvironment) environment).getAppPackage());
            keyBuilder.append("-");
            keyBuilder.append(((MobileAppEnvironment) environment).getAppWaitActivity());
            keyBuilder.append("-");
            keyBuilder.append(((MobileAppEnvironment) environment).getAppWaitPackage());
            keyBuilder.append("-");
            keyBuilder.append(((MobileAppEnvironment) environment).getBundleId());
        }
        return keyBuilder.toString();
    }

    public void dismissDriver(RemoteWebDriver driver) {
        if (!drivers.containsValue(driver)) {
            throw new Error("The driver is not owned by the pool: " + driver);
        }
        for (String key : drivers.keySet()) {
            if (driver.equals(drivers.get(key))) {
                quitDriver(driver);
                drivers.remove(driver);
                break;
            }
        }
    }

    public void dismissAll() {
        for (RemoteWebDriver driver : drivers.values()) {
            quitDriver(driver);
        }
        drivers.clear();
    }

    private void quitDriver(RemoteWebDriver driver) {
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
            }
        }
    }

    public boolean isEmpty() {
        return drivers.isEmpty();
    }

    private void createNewDriver(Environment environment, Project project) throws IOException {
        String driverKey = createKey(environment);
        RemoteWebDriver driver = driverFactory.createDriver(environment, project);
        drivers.remove(driverKey);
        drivers.put(driverKey, driver);
    }
}
