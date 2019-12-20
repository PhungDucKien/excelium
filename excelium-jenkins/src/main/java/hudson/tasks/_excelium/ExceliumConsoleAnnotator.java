/*
 * The MIT License
 *
 * Copyright (c) 2004-2010, Sun Microsystems, Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package hudson.tasks._excelium;

import hudson.console.ConsoleLogFilter;
import hudson.console.LineTransformationOutputStream;
import hudson.model.Run;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;

/**
 * @author Kohsuke Kawaguchi
 * @since 1.349
 */
public class ExceliumConsoleAnnotator extends LineTransformationOutputStream {
    private final OutputStream out;

    public ExceliumConsoleAnnotator(OutputStream out) {
        this.out = out;
    }

    @Override
    protected void eol(byte[] b, int len) throws IOException {
        out.write(b, 0, len);
    }

    @Override
    public void flush() throws IOException {
        out.flush();
    }

    @Override
    public void close() throws IOException {
        super.close();
        out.close();
    }

    public static ConsoleLogFilter asConsoleLogFilter() {
        return new ConsoleLogFilterImpl();
    }

    private static class ConsoleLogFilterImpl extends ConsoleLogFilter implements Serializable {
        private static final long serialVersionUID = 1;

        @Override
        public OutputStream decorateLogger(Run build, OutputStream logger) {
            return new ExceliumConsoleAnnotator(logger);
        }
    }

}
