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

package excelium.progressbar;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author bwittwer
 */
public class Issue13Test {

	private static final int NBR_ELEMENTS = 100;
	private static final int PROGRESSBAR_GRACE_PERIOD = 1000;

	@Test
	public void testOk() {
		ProgressBar pb = new ProgressBar("Test", NBR_ELEMENTS);
		pb.start();

		pb.maxHint(200);

		Assert.assertEquals("Test", pb.getTask());
		Assert.assertEquals(200, pb.getMax());

		try {
			Thread.sleep(PROGRESSBAR_GRACE_PERIOD);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		for (int i = 0; i < 100; i++) {
			pb.setExtraMessage("Test " + i).step();
			Assert.assertEquals(i + 1, pb.getCurrent());
			Assert.assertEquals("Test " + i, pb.getExtraMessage());
		}

		pb.stepBy(2);

		Assert.assertEquals(102, pb.getCurrent());

		pb.stepTo(200);

		Assert.assertEquals(200, pb.getCurrent());

		pb.stop();
	}

	@Test
	public void testKo() {
		ProgressBar pb = new ProgressBar("Test", NBR_ELEMENTS);
		pb.start();
		pb.maxHint(-1);

		for (int i = 0; i < 100; i++) {
			pb.step();
		}

		pb.stop();
	}

}
