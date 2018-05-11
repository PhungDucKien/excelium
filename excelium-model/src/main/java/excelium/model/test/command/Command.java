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

package excelium.model.test.command;

import java.util.Map;

/**
 * Represents command model.
 *
 * @author PhungDucKien
 * @since 2018.03.30
 */
public class Command {

    /**
     * Name
     */
    private String name;

    /**
     * Descriptions
     */
    private Map<String, String> descriptions;

    /**
     * Method
     */
    private String method;

    /**
     * Parameter 1
     */
    private String param1;

    /**
     * Parameter 2
     */
    private String param2;

    /**
     * Parameter 3
     */
    private String param3;

    /**
     * Is the command only available in web application
     */
    private boolean webOnly;

    /**
     * Is the command only available in Android application
     */
    private boolean androidOnly;

    /**
     * Is the command only available in iOS application
     */
    private boolean iosOnly;

    /**
     * Consumer that executed when command is called.
     */
    private TriConsumer<Object, Object, Object> consumer;

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets descriptions.
     *
     * @return the descriptions
     */
    public Map<String, String> getDescriptions() {
        return descriptions;
    }

    /**
     * Sets descriptions.
     *
     * @param descriptions the descriptions
     */
    public void setDescriptions(Map<String, String> descriptions) {
        this.descriptions = descriptions;
    }

    /**
     * Gets method.
     *
     * @return the method
     */
    public String getMethod() {
        return method;
    }

    /**
     * Sets method.
     *
     * @param method the method
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * Gets param 1.
     *
     * @return the param 1
     */
    public String getParam1() {
        return param1;
    }

    /**
     * Sets param 1.
     *
     * @param param1 the param 1
     */
    public void setParam1(String param1) {
        this.param1 = param1;
    }

    /**
     * Gets param 2.
     *
     * @return the param 2
     */
    public String getParam2() {
        return param2;
    }

    /**
     * Sets param 2.
     *
     * @param param2 the param 2
     */
    public void setParam2(String param2) {
        this.param2 = param2;
    }

    /**
     * Gets param 3.
     *
     * @return the param 3
     */
    public String getParam3() {
        return param3;
    }

    /**
     * Sets param 3.
     *
     * @param param3 the param 3
     */
    public void setParam3(String param3) {
        this.param3 = param3;
    }

    /**
     * Is web only boolean.
     *
     * @return the boolean
     */
    public boolean isWebOnly() {
        return webOnly;
    }

    /**
     * Sets web only.
     *
     * @param webOnly the web only
     */
    public void setWebOnly(boolean webOnly) {
        this.webOnly = webOnly;
    }

    /**
     * Is android only boolean.
     *
     * @return the boolean
     */
    public boolean isAndroidOnly() {
        return androidOnly;
    }

    /**
     * Sets android only.
     *
     * @param androidOnly the android only
     */
    public void setAndroidOnly(boolean androidOnly) {
        this.androidOnly = androidOnly;
    }

    /**
     * Is ios only boolean.
     *
     * @return the boolean
     */
    public boolean isIosOnly() {
        return iosOnly;
    }

    /**
     * Sets ios only.
     *
     * @param iosOnly the ios only
     */
    public void setIosOnly(boolean iosOnly) {
        this.iosOnly = iosOnly;
    }

    /**
     * Gets consumer.
     *
     * @return the consumer
     */
    public TriConsumer<Object, Object, Object> getConsumer() {
        return consumer;
    }

    /**
     * Sets consumer.
     *
     * @param consumer the consumer
     */
    public void setConsumer(TriConsumer<Object, Object, Object> consumer) {
        this.consumer = consumer;
    }
}
