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

import freemarker.template.*;

import java.io.*;
import java.util.Locale;
import java.util.Map;

/**
 * A template service that uses FreeMarker template engine.
 *
 * @author PhungDucKien
 * @since 2018.06.27
 */
public class FreeMarkerTemplateService implements TemplateService {

    /**
     * FreeMarker configuration
     */
    private Configuration configuration;

    @Override
    public void processTemplate(String template, Map<String, Object> objects, File out) {
        out.getParentFile().mkdirs();

        try (FileOutputStream fileOutputStream = new FileOutputStream(out);
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
             Writer w = new OutputStreamWriter(bufferedOutputStream)) {

            processTemplate(template, objects, w);

            System.out.println("Wrote to " + out.getAbsolutePath());
        } catch (IOException | TemplateException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void processTemplate(String template, Map<String, Object> objects, Writer out) throws IOException, TemplateException {
        Configuration configuration = getConfiguration();
        Template t = configuration.getTemplate(template);
        t.process(objects, out);
    }

    /**
     * Returns the configuration for FreeMarker template engine.
     * Creates the configuration if it is not initialized yet.
     *
     * @return the configuration for FreeMarker template engine
     */
    private Configuration getConfiguration() {
        if (configuration == null) {
            configuration = createConfiguration();
        }
        return configuration;
    }

    /**
     * Initializes the configuration for FreeMarker template engine.
     *
     * @return the configuration for FreeMarker template engine
     */
    private Configuration createConfiguration() {
        Configuration configuration = new Configuration(new Version(2, 3, 28));
        // Where do we load the templates from:
        configuration.setClassForTemplateLoading(FreeMarkerTemplateService.class, "/templates");

        // Some other recommended settings:
        configuration.setDefaultEncoding("UTF-8");
        configuration.setLocale(Locale.US);

        configuration.setBooleanFormat("yes,no");
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        return configuration;
    }
}
