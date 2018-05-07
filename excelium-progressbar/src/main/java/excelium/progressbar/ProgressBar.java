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

import java.io.PrintStream;
import java.time.LocalDateTime;

/**
 * A simple console-based progress bar.
 * @author Tongfei Chen
 */
public class ProgressBar {

    private ProgressState progress;
    private ProgressThread target;
    private Thread thread;

    /**
     * Creates a progress bar with the specific task name and initial maximum value.
     * @param task Task name
     * @param initialMax Initial maximum value
     */
    public ProgressBar(String task, long initialMax) {
        this(task, initialMax, 1000);
    }

    public ProgressBar(String task, long initialMax, int updateIntervalMillis) {
        this(task, initialMax, updateIntervalMillis, ProgressBarStyle.UNICODE_BLOCK);
    }

    public ProgressBar(String task, long initialMax, int updateIntervalMillis, ProgressBarStyle style) {
        this(task, initialMax, updateIntervalMillis, System.err, style);
    }

    /**
     * Creates a progress bar with the specific task name, initial maximum value,
     * customized update interval (default 1000 ms), the PrintStream to be used, and output style.
     * @param task Task name
     * @param initialMax Initial maximum value
     * @param updateIntervalMillis Update interval (default value 1000 ms)
     * @param os Print stream (default value System.err)
     * @param style Output style (default value ProgresBarStyle.UNICODE_BLOCK)
     */
    public ProgressBar(String task, long initialMax, int updateIntervalMillis, PrintStream os, ProgressBarStyle style) {
        this.progress = new ProgressState(task, initialMax);
        this.target = new ProgressThread(progress, style, updateIntervalMillis, os);
        this.thread = new Thread(target);
    }

    /**
     * Starts this progress bar.
     */
    public ProgressBar start() {
        progress.startTime = LocalDateTime.now();
        thread.start();
        return this;
    }

    /**
     * Advances this progress bar by a specific amount.
     * @param n Step size
     */
    public ProgressBar stepBy(long n) {
        progress.stepBy(n);
        return this;
    }

    /**
     * Advances this progress bar to the specific progress value.
     * @param n New progress value
     */
    public ProgressBar stepTo(long n) {
        progress.stepTo(n);
        return this;
    }

    /**
     * Advances this progress bar by one step.
     */
    public ProgressBar step() {
        progress.stepBy(1);
        return this;
    }

    /**
     * Gives a hint to the maximum value of the progress bar.
     * @param n Hint of the maximum value
     */
    public ProgressBar maxHint(long n) {
        if (n < 0)
            progress.setAsIndefinite();
        else {
            progress.setAsDefinite();
            progress.maxHint(n);
        }
        return this;
    }

    /**
     * Stops this progress bar.
     */
    public ProgressBar stop() {
        target.kill();
        try {
            thread.join();
            target.consoleStream.flush();
        }
        catch (InterruptedException ex) { }
        return this;
    }

    /**
     * Sets the extra message at the end of the progress bar.
     * @param msg New message
     */
    public ProgressBar setExtraMessage(String msg) {
        progress.setExtraMessage(msg);
        return this;
    }

	/**
     * Returns the current progress.
     */
    public long getCurrent() {
        return progress.getCurrent();
    }

    /**
     * Returns the maximum value of this progress bar.
     */
    public long getMax() {
        return progress.getMax();
    }

    /**
     * Returns the name of this task.
     */
    public String getTask() {
        return progress.getTask();
    }

    /**
     * Returns the extra message at the end of the progress bar.
     */
    public String getExtraMessage() {
        return progress.getExtraMessage();
    }

}
