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

package excelium.doclet.service;

import java.io.File;
import java.io.Writer;
import java.util.Map;

/**
 * Provides an interface to services for executing template engine against a template file and data model.
 *
 * @author PhungDucKien
 * @since 2018.06.27
 */
public interface TemplateService {

    /**
     * Process a template against the supplied data model and write to the file.
     *
     * @param template Template
     * @param objects  Object model to process template against
     * @param out      File to write to
     */
    void processTemplate(String template, Map<String, Object> objects, File out);

    /**
     * Process a template against the supplied data model and write to the out.
     *
     * @param template Template
     * @param objects  Object model to process template against
     * @param out      Writer object to send output to
     * @throws Exception the exception
     */
    void processTemplate(String template, Map<String, Object> objects, Writer out) throws Exception;
}
