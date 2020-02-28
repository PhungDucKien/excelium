package excelium.core;

import excelium.common.NumberUtil;
import excelium.core.driver.ContextAwareWebDriver;
import excelium.model.project.Project;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommandExecutor {

    /**
     * Base URL
     */
    protected final String baseUrl;

    /**
     * Excelium object
     */
    protected final Excelium excelium;

    public CommandExecutor(ContextAwareWebDriver webDriver, String baseUrl, Excelium excelium, Project project) {
        this.baseUrl = baseUrl;
        this.excelium = excelium;
    }

    /**
     * Run an action.
     *
     * @param actionName the action name
     * @throws Exception the exception
     */
    public void runAction(String actionName) throws Exception {
        if (excelium != null) {
            excelium.runAction(actionName);
        } else {
            throw new Exception("The command executor can not run an action.");
        }
    }

    public String normalizeText(String text) {
        if (webDriver.isNativeContext()) {
            text = text.replace("\n", "&#10;");
        }
    }

    /**
     * Create web driver wait with the default timeout.
     *
     * @return the web driver wait
     */
    public WebDriverWait createWebDriverWait() {
        WebDriverWait wait = new WebDriverWait(webDriver, 0);
        wait.withTimeout(Duration.ofMillis(webDriver.getTimeout()));
        return wait;
    }

    /**
     * Create web driver wait with the custom timeout.
     *
     * @param timeOutInMilliseconds The timeout in milliseconds when an expectation is called
     * @return the web driver wait
     */
    public WebDriverWait createWebDriverWait(String timeOutInMilliseconds) {
        long timeout = toPositiveInteger(timeOutInMilliseconds, webDriver.getTimeout());
        WebDriverWait wait = new WebDriverWait(webDriver, 0);
        wait.withTimeout(Duration.ofMillis(timeout));
        return wait;
    }

    /**
     * Get the absolute URL from the given URL.
     *
     * @param url the URL
     * @return the absolute URL
     */
    protected String getAbsoluteUrl(String url) {
        return baseUrl != null && !url.contains("://") ?
                baseUrl + (!url.startsWith("/") ? "/" : "") + url :
                url;
    }

    /**
     * Parse the given {@code text} into a positive {@link Integer} instance.
     *
     * @param value the text value
     * @param defaultValue the default value
     * @return an integer
     */
    protected int toPositiveInteger(String value, int defaultValue) {
        // Of course, a non-breaking space doesn't count as whitespace.
        value = value.replace('\u00A0',' ').trim();
        return NumberUtil.parsePositiveInteger(value, defaultValue);
    }

    /**
     * Parse the given {@code text} into an {@link Integer} instance.
     *
     * @param value the text value
     * @param defaultValue the default value
     * @return an integer
     */
    protected int toInteger(String value, int defaultValue) {
        // Of course, a non-breaking space doesn't count as whitespace.
        value = value.replace('\u00A0',' ').trim();
        return NumberUtil.parseInteger(value, defaultValue);
    }
}
