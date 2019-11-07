/*
 * MIT License
 *
 * Copyright (c) 2019 Excelium
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

package excelium.core;

import excelium.progressbar.ProgressBar;
import excelium.progressbar.ProgressBarStyle;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Downloader {

    /**
     * Size of the buffer
     */
    private static final int BUFFER_SIZE = 1024;

    /**
     * Get Github latest tag.
     *
     * @param repository the Github repository
     * @return Github latest tag
     * @throws IOException the io exception
     */
    protected String getGithubLatestTag(String repository) throws IOException {
        URL obj = new URL("https://github.com/" + repository + "/releases/latest");
        URLConnection conn = obj.openConnection();
        conn.getHeaderFields();
        String tagUrl = conn.getURL().getPath();
        return tagUrl.substring(tagUrl.lastIndexOf("/") + 1);
    }

    /**
     * Read string from an URL.
     *
     * @param requestURL the request URL
     * @return the URL content
     * @throws IOException the io exception
     */
    protected String readStringFromURL(String requestURL) throws IOException {
        try (InputStream is = new URL(requestURL).openStream();
             Scanner scanner = new Scanner(is, StandardCharsets.UTF_8.toString())) {
            scanner.useDelimiter("\\A");
            return scanner.hasNext() ? scanner.next() : "";
        }
    }

    /**
     * Download the archive file and extract the desired file to the specified path.
     *
     * @param downloadUrl     the download URL
     * @param extractFileName the file name to extract
     * @param path            the path to save
     * @throws IOException the io exception
     */
    protected void downloadAndExtract(String downloadUrl, String extractFileName, String path) throws IOException {
        byte[] data = new byte[BUFFER_SIZE];

        URL url = new URL(downloadUrl);
        URLConnection connection = url.openConnection();
        connection.connect();

        int contentLength = connection.getContentLength();

        try (InputStream is = url.openStream();
             BufferedInputStream bis = new BufferedInputStream(is);
             ByteArrayOutputStream os = new ByteArrayOutputStream()) {

            ProgressBar pb = new ProgressBar(FilenameUtils.getName(url.getPath()), contentLength, 500, ProgressBarStyle.ASCII);
            pb.start();

            int dataRead;
            while ((dataRead = bis.read(data, 0, BUFFER_SIZE)) > 0) {
                os.write(data, 0, dataRead);
                pb.stepBy(dataRead);
            }

            os.flush();
            pb.stop();

            try (ByteArrayInputStream bais = new ByteArrayInputStream(os.toByteArray())) {
                if (downloadUrl.endsWith(".tar.gz")) {
                    extractTarGz(bais, extractFileName, path);
                } else {
                    extractZip(bais, extractFileName, path);
                }
            }
        }
    }

    /**
     * Extract the desired file archived in a Zip file to the specified path.
     *
     * @param is              the Zip file InputStream
     * @param extractFileName the file name to extract
     * @param path            the path to save
     * @throws IOException the io exception
     */
    private void extractZip(InputStream is, String extractFileName, String path) throws IOException {
        try (ZipInputStream zis = new ZipInputStream(is)) {
            ZipEntry entry;

            boolean extracted = false;

            while ((entry = zis.getNextEntry()) != null) {
                if (!entry.isDirectory()) {
                    if (entry.getName().equals(extractFileName)) {
                        File source = new File(extractFileName);
                        File target = new File(path);
                        if (target.exists() && target.isDirectory()) {
                            target = Paths.get(path).resolve(source.getName()).toFile();
                        }
                        try (FileOutputStream fos = new FileOutputStream(target)) {
                            IOUtils.copy(zis, fos);
                        }
                        extracted = true;
                        break;
                    } else if (entry.getName().startsWith(extractFileName)) {
                        String relativePath = entry.getName().replace(extractFileName, "");
                        if (relativePath.startsWith("/")) {
                            relativePath = relativePath.substring(1);
                        }
                        Path target = Paths.get(path).resolve(relativePath);
                        Files.createDirectories(target.getParent());
                        try (FileOutputStream fos = new FileOutputStream(target.toFile())) {
                            IOUtils.copy(zis, fos);
                        }
                        extracted = true;
                    }
                }
            }

            if (extracted) {
                System.out.println("Extracted " + extractFileName + " to " + path);
            }

            zis.closeEntry();
        }
    }

    /**
     * Extract the desired file archived in a Tar Gz file to the specified path.
     *
     * @param is              the Tar Gz file InputStream
     * @param extractFileName the file name to extract
     * @param path            the path to save
     * @throws IOException the io exception
     */
    private void extractTarGz(InputStream is, String extractFileName, String path) throws IOException {
        try (GzipCompressorInputStream gzipIn = new GzipCompressorInputStream(is);
             TarArchiveInputStream tarIn = new TarArchiveInputStream(gzipIn)) {
            ArchiveEntry entry;

            boolean extracted = false;

            while ((entry = tarIn.getNextEntry()) != null) {
                if (!entry.isDirectory()) {
                    if (entry.getName().equals(extractFileName)) {
                        File source = new File(extractFileName);
                        File target = new File(path);
                        if (target.exists() && target.isDirectory()) {
                            target = Paths.get(path).resolve(source.getName()).toFile();
                        }
                        try (FileOutputStream fos = new FileOutputStream(target)) {
                            IOUtils.copy(tarIn, fos);
                        }
                        extracted = true;
                        break;
                    } else if (entry.getName().startsWith(extractFileName)) {
                        String relativePath = entry.getName().replace(extractFileName, "");
                        if (relativePath.startsWith("/")) {
                            relativePath = relativePath.substring(1);
                        }
                        Path target = Paths.get(path).resolve(relativePath);
                        Files.createDirectories(target.getParent());
                        try (FileOutputStream fos = new FileOutputStream(target.toFile())) {
                            IOUtils.copy(tarIn, fos);
                        }
                        extracted = true;
                    }
                }
            }

            if (extracted) {
                System.out.println("Extracted " + extractFileName + " to " + path);
            }
        }
    }
}
