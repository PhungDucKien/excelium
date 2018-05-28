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

package excelium.cli;

import excelium.cli.controller.*;
import mockit.Mocked;
import mockit.Verifications;
import org.junit.Test;

/**
 * Tests for {@link Application}.
 *
 * @author PhungDucKien
 * @since 2018.04.11
 */
public class ApplicationTest {

    @Mocked
    private ProjectController projectController;

    @Mocked
    private TemplateController templateController;

    @Mocked
    private TestFileController testFileController;

    @Mocked
    private TestController testController;

    @Mocked
    private DataSourceController dataSourceController;

    @Test
    public void testProjectCreate() throws Exception {
        Application.main(new String[]{"project", "create"});

        new Verifications() {{
            projectController.create();
        }};
    }

    @Test
    public void testTemplateImport() throws Exception {
        Application.main(new String[]{"template", "import"});

        new Verifications() {{
            templateController.importTemplate();
        }};
    }

    @Test
    public void testTemplateRemove() throws Exception {
        Application.main(new String[]{"template", "remove"});

        new Verifications() {{
            templateController.remove();
        }};
    }

    @Test
    public void testTestFileAdd() throws Exception {
        Application.main(new String[]{"test", "add"});

        new Verifications() {{
            testFileController.add();
        }};
    }

    @Test
    public void testTestFileRemove() throws Exception {
        Application.main(new String[]{"test", "remove"});

        new Verifications() {{
            testFileController.remove();
        }};
    }

    @Test
    public void testTestExecute() throws Exception {
        Application.main(new String[]{});

        new Verifications() {{
            testController.execute();
        }};
    }

    @Test
    public void testDataSourceAdd() throws Exception {
        Application.main(new String[]{"ds", "add"});

        new Verifications() {{
            dataSourceController.add();
        }};
    }

    @Test
    public void testDataSourceRemove() throws Exception {
        Application.main(new String[]{"ds", "remove"});

        new Verifications() {{
            dataSourceController.remove();
        }};
    }
}
