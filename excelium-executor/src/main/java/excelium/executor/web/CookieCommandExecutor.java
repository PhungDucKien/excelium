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

package excelium.executor.web;

import com.thoughtworks.selenium.SeleniumException;
import excelium.core.command.Accessor;
import excelium.core.command.Action;
import excelium.core.driver.ContextAwareWebDriver;
import excelium.core.Excelium;
import excelium.core.CommandExecutor;
import excelium.model.project.Project;
import org.openqa.selenium.Cookie;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents a class which contains commands for controlling cookies.
 *
 * @author PhungDucKien
 * @since 2018.06.27
 */
public class CookieCommandExecutor extends CommandExecutor {

    private final Pattern NAME_VALUE_PAIR_PATTERN =
            Pattern.compile("([^\\s=\\[\\]\\(\\),\"\\/\\?@:;]+)=([^\\[\\]\\(\\),\"\\/\\?@:;]*)");
    private static final Pattern MAX_AGE_PATTERN = Pattern.compile("max_age=(\\d+)");
    private static final Pattern PATH_PATTERN = Pattern.compile("path=([^\\s,]+)[,]?");

    /**
     * Instantiates a new Cookie command executor.
     *
     * @param webDriver the web driver
     * @param baseUrl   the base url
     * @param excelium  the excelium
     * @param project   the project
     */
    public CookieCommandExecutor(ContextAwareWebDriver webDriver, String baseUrl, Excelium excelium, Project project) {
        super(webDriver, baseUrl, excelium, project);
    }

    /**
     * Create a new cookie whose path and domain are same with those of current page under test.
     *
     * @param nameValuePair name and value of the cookie in a format "name=value"
     */
    @Action(param1 = "nameValuePair")
    public void createCookie(String nameValuePair) {
        createCookie(nameValuePair, "");
    }

    /**
     * Create a new cookie whose path and domain are same with those of current page under test,
     * unless you specified a path for this cookie explicitly.
     *
     * @param nameValuePair name and value of the cookie in a format "name=value"
     * @param optionsString options for the cookie. Currently supported options include 'path',
     *        'max_age' and 'domain'. the optionsString's format is
     *        "path=/path/, max_age=60, domain=.foo.com". The order of options are irrelevant, the
     *        unit of the value of 'max_age' is second. Note that specifying a domain that isn't a
     *        subset of the current domain will usually fail.
     */
    @Action(param1 = "nameValuePair", param2 = "optionsString")
    public void createCookie(String nameValuePair, String optionsString) {
        Matcher nameValuePairMatcher = NAME_VALUE_PAIR_PATTERN.matcher(nameValuePair);
        if (!nameValuePairMatcher.find())
            throw new SeleniumException("Invalid parameter: " + nameValuePair);

        String name = nameValuePairMatcher.group(1);
        String value = nameValuePairMatcher.group(2);

        Matcher maxAgeMatcher = MAX_AGE_PATTERN.matcher(optionsString);
        Date maxAge = null;

        if (maxAgeMatcher.find()) {
            maxAge =
                    new Date(System.currentTimeMillis() + Integer.parseInt(maxAgeMatcher.group(1)) * 1000);
        }

        String path = null;
        Matcher pathMatcher = PATH_PATTERN.matcher(optionsString);
        if (pathMatcher.find()) {
            path = pathMatcher.group(1);
            try {
                if (path.startsWith("http")) {
                    path = new URL(path).getPath();
                }
            } catch (MalformedURLException e) {
                // Fine.
            }
        }

        Cookie cookie = new Cookie(name, value, path, maxAge);
        webDriver.manage().addCookie(cookie);
    }

    /**
     * Calls deleteCookie with recurse=true on all cookies visible to the current page. As noted on
     * the documentation for deleteCookie, recurse=true can be much slower than simply deleting the
     * cookies using a known domain/path.
     */
    @Action
    public void deleteAllVisibleCookies() {
        webDriver.manage().deleteAllCookies();
    }

    /**
     * Delete a named cookie with specified path and domain. Be careful; to delete a cookie, you need
     * to delete it using the exact same path and domain that were used to create the cookie. If the
     * path is wrong, or the domain is wrong, the cookie simply won't be deleted. Also note that
     * specifying a domain that isn't a subset of the current domain will usually fail.
     *
     * Since there's no way to discover at runtime the original path and domain of a given cookie,
     * we've added an option called 'recurse' to try all sub-domains of the current domain with all
     * paths that are a subset of the current path. Beware; this option can be slow. In big-O
     * notation, it operates in O(n*m) time, where n is the number of dots in the domain name and m is
     * the number of slashes in the path.
     *
     * @param name the name of the cookie to be deleted
     */
    @Action(param1 = "name")
    public void deleteCookie(String name) {
        Cookie cookie = webDriver.manage().getCookieNamed(name);

        if (cookie != null) {
            webDriver.manage().deleteCookieNamed(name);
        }
    }

    /**
     * Return all cookies of the current page under test.
     *
     * @return all cookies of the current page under test
     */
    @Accessor
    public String getCookie() {
        StringBuilder builder = new StringBuilder();
        for (Cookie c : webDriver.manage().getCookies()) {
            builder.append(c.toString());
            builder.append("; ");
        }
        return builder.toString();
    }

    /**
     * Returns the value of the cookie with the specified name, or throws an error if the cookie is
     * not present.
     *
     * @param name the name of the cookie
     * @return the value of the cookie
     */
    @Accessor(param1 = "name")
    public String getCookieByName(String name) {
        Cookie cookie = webDriver.manage().getCookieNamed(name);
        return cookie == null ? null : cookie.getValue();
    }

    /**
     * Returns true if a cookie with the specified name is present, or false otherwise.
     *
     * @param name the name of the cookie
     * @return true if a cookie with the specified name is present, or false otherwise.
     */
    @Accessor(param1 = "name")
    public boolean isCookiePresent(String name) {
        return webDriver.manage().getCookieNamed(name) != null;
    }
}
