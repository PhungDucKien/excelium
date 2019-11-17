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

/**
 * Tests for {@link AppType}.
 *
 * @author PhungDucKien
 * @since 2018.03.26
 */
public class AppTypeTest {

    @Test
    public void testFromName() {
        Assert.assertEquals(AppType.WEB, AppType.fromName("WEB"));
        Assert.assertEquals(AppType.MOBILE, AppType.fromName("MOBILE"));
    }

    @Test
    public void testGetListChoice() {
        String[][] listChoice = AppType.getListChoice();
        Assert.assertEquals(2, listChoice.length);
        Assert.assertEquals("WEB", listChoice[0][0]);
        Assert.assertEquals("Web application", listChoice[0][1]);
        Assert.assertEquals("MOBILE", listChoice[1][0]);
        Assert.assertEquals("Mobile application", listChoice[1][1]);
    }
}
