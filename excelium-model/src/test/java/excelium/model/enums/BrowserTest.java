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

package excelium.model.enums;

import org.junit.Assert;
import org.junit.Test;


public class BrowserTest {

    @Test
    public void testGetListChoice() {
        String[][] listChoice = Browser.getListChoice();
        Assert.assertEquals(8, listChoice.length);
        Assert.assertEquals("CHROME", listChoice[0][0]);
        Assert.assertEquals("Chrome", listChoice[0][1]);
        Assert.assertEquals("FIREFOX", listChoice[1][0]);
        Assert.assertEquals("Firefox", listChoice[1][1]);
        Assert.assertEquals("IE", listChoice[2][0]);
        Assert.assertEquals("Internet Explorer", listChoice[2][1]);
        Assert.assertEquals("EDGE", listChoice[3][0]);
        Assert.assertEquals("Microsoft Edge", listChoice[3][1]);
        Assert.assertEquals("SAFARI", listChoice[4][0]);
        Assert.assertEquals("Safari", listChoice[4][1]);
        Assert.assertEquals("OPERA", listChoice[5][0]);
        Assert.assertEquals("Opera", listChoice[5][1]);
        Assert.assertEquals("CHROMIUM", listChoice[6][0]);
        Assert.assertEquals("Chromium", listChoice[6][1]);
        Assert.assertEquals("BROWSER", listChoice[7][0]);
        Assert.assertEquals("Browser", listChoice[7][1]);
    }
}
