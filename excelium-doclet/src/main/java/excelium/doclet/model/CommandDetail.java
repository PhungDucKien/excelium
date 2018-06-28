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

package excelium.doclet.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Command detail data model.
 *
 * @author PhungDucKien
 * @since 2018.06.27
 */
public class CommandDetail {

    /**
     * Name
     */
    private String name;

    /**
     * Method
     */
    private String method;

    /**
     * Usages
     */
    private List<String> usages = new ArrayList<>();

    /**
     * Description
     */
    private String description;

    /**
     * Parameter tags
     */
    private List<ParameterTag> parameterTags;

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
     * Gets usages.
     *
     * @return the usages
     */
    public List<String> getUsages() {
        return usages;
    }

    /**
     * Sets usages.
     *
     * @param usages the usages
     */
    public void setUsages(List<String> usages) {
        this.usages = usages;
    }

    /**
     * Add usage.
     *
     * @param usage the usage
     */
    public void addUsage(String usage) {
        this.usages.add(usage);
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets parameter tags.
     *
     * @return the parameter tags
     */
    public List<ParameterTag> getParameterTags() {
        return parameterTags;
    }

    /**
     * Sets parameter tags.
     *
     * @param parameterTags the parameter tags
     */
    public void setParameterTags(List<ParameterTag> parameterTags) {
        this.parameterTags = parameterTags;
    }
}
