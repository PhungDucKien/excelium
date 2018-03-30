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

package excelium.model.adapter;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Paths;

/**
 * Tests for {@link PathXmlAdapter}.
 *
 * @author PhungDucKien
 * @since 2018.03.27
 */
public class PathXmlAdapterTest {

    @Test
    public void testUnmarshal() {
        PathXmlAdapter adapter = new PathXmlAdapter();
        Assert.assertEquals(Paths.get("path"), adapter.unmarshal("path"));
        Assert.assertNull(adapter.unmarshal(null));
    }

    @Test
    public void testMarshal() {
        PathXmlAdapter adapter = new PathXmlAdapter();
        Assert.assertEquals("path", adapter.marshal(Paths.get("path")));
        Assert.assertNull(adapter.marshal(null));
    }
}
