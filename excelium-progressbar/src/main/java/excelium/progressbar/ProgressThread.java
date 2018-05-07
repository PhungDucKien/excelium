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

import excelium.common.StringUtil;
import jline.TerminalFactory;
import org.fusesource.jansi.Ansi;

import java.io.PrintStream;
import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @author Tongfei Chen
 * @since 0.5.0
 */
class ProgressThread implements Runnable {

    volatile boolean killed;
    ProgressBarStyle style;
    ProgressState progress;
    long updateInterval;
    PrintStream consoleStream;

    static int consoleRightMargin = 3;

    int length;

    ProgressThread(ProgressState progress, ProgressBarStyle style, long updateInterval, PrintStream consoleStream) {
        this.progress = progress;
        this.style = style;
        this.updateInterval = updateInterval;
        this.consoleStream = consoleStream;
        this.killed = false;
    }

    // between 0 and 1
    double progress() {
        if (progress.max <= 0) return 0.0;
        else return ((double)progress.current) / progress.max;
    }

    // Number of full blocks
    int progressIntegralPart() {
        return (int)(progress() * length);
    }

    int progressFractionalPart() {
        double p = progress() * length;
        double fraction = (p - Math.floor(p)) * style.fractionSymbols.length();
        return (int) Math.floor(fraction);
    }

    String eta(Duration elapsed) {
        if (progress.max <= 0 || progress.indefinite) return "?";
        else if (progress.current == 0) return "?";
        else return Util.formatDuration(
                elapsed.dividedBy(progress.current)
                        .multipliedBy(progress.max - progress.current));
    }

    String percentage() {
        String res;
        if (progress.max <= 0 || progress.indefinite) res = "? %";
        else res = String.valueOf((int) Math.floor(100.0 * progress.current / progress.max)) + "%";
        return Util.repeat(' ', 4 - res.length()) + res;
    }

    String ratio() {
        String m = progress.indefinite ? "?" : StringUtil.humanReadableByteCount(progress.max, true);
        String c = StringUtil.humanReadableByteCount(progress.current, true);
        return Util.repeat(' ', m.length() - c.length()) + c + "/" + m;
    }

    int consoleWidth() {
        return TerminalFactory.get().getWidth();
    }

    void refresh() {
        consoleStream.print(Ansi.ansi().cursorUp(1));

        LocalDateTime currTime = LocalDateTime.now();
        Duration elapsed = Duration.between(progress.startTime, currTime);

        String prefix = progress.task + " " + percentage() + " " + style.leftBracket;

        int maxSuffixLength = Math.max(0, consoleWidth() - consoleRightMargin - prefix.length() - 10);
        String suffix = style.rightBracket + " " + ratio() + " (" + Util.formatDuration(elapsed) + " / " + eta(elapsed) + ") " + progress.extraMessage;
        if (suffix.length() > maxSuffixLength) suffix = suffix.substring(0, maxSuffixLength);

        length = consoleWidth() - consoleRightMargin - prefix.length() - suffix.length();

        StringBuilder sb = new StringBuilder();
        sb.append(prefix);

        // case of indefinite progress bars
        if (progress.indefinite) {
            int pos = (int)(progress.current % length);
            sb.append(Util.repeat(style.space, pos));
            sb.append(style.block);
            sb.append(Util.repeat(style.space, length - pos - 1));
        }
        // case of definite progress bars
        else {
            sb.append(Util.repeat(style.block, progressIntegralPart()));
            if (progress.current < progress.max) {
                sb.append(style.fractionSymbols.charAt(progressFractionalPart()));
                sb.append(Util.repeat(style.space, length - progressIntegralPart() - 1));
            }
        }
        sb.append(suffix);
        String line = sb.toString();

        consoleStream.println(line);
    }

    void kill() {
    	killed = true;
    }

    public void run() {
        try {
            consoleStream.println();
            while (!killed) {
                refresh();
                Thread.sleep(updateInterval);
            }
            refresh();
            // do-while loop not right: must force to refresh after stopped
        } catch (InterruptedException ex) { }
    }
}