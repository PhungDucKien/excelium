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

import excelium.core.Excelium;
import excelium.core.driver.ContextAwareWebDriver;
import excelium.model.project.Project;

import java.lang.reflect.InvocationTargetException;

public class <#if isWeb>Web<#else>Mobile</#if>Excelium extends Excelium {

    public <#if isWeb>Web<#else>Mobile</#if>Excelium(ContextAwareWebDriver webDriver, String baseUrl, Project project) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        super(webDriver, baseUrl, project);
    }

    protected void setWebContext() {
        super.setWebContext();
    }

    protected void setNativeContext() {
        super.setNativeContext();
    }

<#list items>
<#items as command>
    public void ${command.getMethod()}(<#if command.getParam1()?has_content>String ${(command.getParam1())!}</#if><#if command.getParam2()?has_content>, String ${(command.getParam2())!}</#if><#if command.getParam3()?has_content>, String ${(command.getParam3())!}</#if>) throws Throwable {
        runCommand("${command.getMethod()}", <#if command.getParam1()?has_content>${(command.getParam1())!}<#else>null</#if>, <#if command.getParam2()?has_content>${(command.getParam2())!}<#else>null</#if>, <#if command.getParam3()?has_content>${(command.getParam3())!}<#else>null</#if>);
    }

</#items>
</#list>
}
