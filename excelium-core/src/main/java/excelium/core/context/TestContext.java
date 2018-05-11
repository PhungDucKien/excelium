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

package excelium.core.context;

import org.apache.commons.jexl3.JexlContext;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * The context that stores test variables and their values.
 * The context also contains some inline functions such as date calculations, etc.
 *
 * @author PhungDucKien
 * @since 2018.05.10
 */
public class TestContext implements JexlContext, JexlContext.NamespaceResolver {

    /**
     * Function namespace
     */
    private final FunctionNamespace functionNamespace;

    /**
     * Map of variables and their values
     */
    private final Map<String, Object> map;

    /**
     * Map of reserved variables
     */
    private final Map<String, Supplier> reservedVariables = new HashMap<String, Supplier>() {{
        put("current_date", LocalDate::now);
        put("current_time", LocalTime::now);
        put("current_timestamp", LocalDateTime::now);
    }};

    /**
     * Instantiates a new Test context.
     */
    public TestContext() {
        functionNamespace = new FunctionNamespace();
        map = new HashMap<>();
    }

    /**
     * Clear variables.
     */
    public void clear() {
        map.clear();
    }

    @Override
    public boolean has(String name) {
        return isReservedVariable(name) || map.containsKey(name.toLowerCase());
    }

    @Override
    public Object get(String name) {
        if (isReservedVariable(name)) {
            return reservedVariables.get(name.toLowerCase()).get();
        }
        return map.get(name.toLowerCase());
    }

    @Override
    public void set(String name, Object value) {
        if (!isReservedVariable(name)) {
            map.put(name.toLowerCase(), value);
        }
    }

    @Override
    public Object resolveNamespace(String name) {
        if (StringUtils.isBlank(name)) {
            return functionNamespace;
        } else {
            return null;
        }
    }

    /**
     * Checks whether the variable name is reserved.
     *
     * @param name the variable name
     * @return true if the name is reserved, otherwise, false
     */
    private boolean isReservedVariable(String name) {
        return reservedVariables.keySet().contains(name.toLowerCase());
    }
}

