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

package excelium.sheets.connection;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.util.store.FileDataStoreFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

import static excelium.common.CiInfoUtil.isCI;

/**
 * Implements {@link GoogleConnection} for uses in command line applications.
 *
 * @author PhungDucKien
 * @since 2018.04.10
 */
public class GoogleConnectionService extends GoogleConnection {

    /**
     * Logger
     */
    private static final Logger LOG = LogManager.getLogger();

    /**
     * Command line client secret json file
     */
    private static final String CLIENT_SECRETS = "installed_client_secret.json";

    /**
     * Directory to store user credentials for this application.
     */
    private static final File DATA_STORE_DIR = new File(
            System.getProperty("user.home"), ".credentials/sheets.googleapis.com-excelium");

    /**
     * Global instance of the {@link FileDataStoreFactory}.
     */
    private static FileDataStoreFactory DATA_STORE_FACTORY;

    /**
     * Client secrets
     */
    private static GoogleClientSecrets clientSecrets;

    /**
     * Credential
     */
    private Credential credential;

    /**
     * Constructs a command line Google connection.
     */
    public GoogleConnectionService() {
        super();

        try {
            DATA_STORE_FACTORY = new FileDataStoreFactory(DATA_STORE_DIR);
        } catch (Throwable t) {
            LOG.error(t.getMessage(), t);
            System.exit(9);
        }
    }

    /**
     * Get client secret json file input stream.
     *
     * @return Client secret json file input stream
     * @throws IOException if IOException occurs during file loading
     */
    private InputStream getSecretFile() throws FileNotFoundException {
        InputStream in;
        File userDefinedSecret = new File("config/" + CLIENT_SECRETS);
        if (userDefinedSecret.exists()) {
            in = new FileInputStream(userDefinedSecret);
        } else {
            LOG.warn(CLIENT_SECRETS + " not found in Excelium config folder. Load default secret.");
            in = GoogleConnection.class.getResourceAsStream("/" + CLIENT_SECRETS);
        }
        return in;
    }

    @Override
    GoogleClientSecrets getClientSecrets() {
        if (clientSecrets == null) {
            try {
                // load client secrets
                InputStreamReader clientSecretsReader = new InputStreamReader(getSecretFile());
                clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, clientSecretsReader);
            } catch (IOException e) {
                LOG.error(e.getMessage(), e);
                System.exit(9);
            }
        }

        return clientSecrets;
    }

    @Override
    public Credential getCredential() throws IOException {
        if (credential == null) {
            if (isCI()) {
                credential = GoogleCredential.fromStream(getClass().getClassLoader().getResourceAsStream("service_account.json"))
                     .createScoped(SCOPES);
            } else {
                // Build flow and trigger user authorization request.
                GoogleAuthorizationCodeFlow flow =
                        new GoogleAuthorizationCodeFlow.Builder(
                                HTTP_TRANSPORT, JSON_FACTORY, getClientSecrets(), SCOPES)
                                .setDataStoreFactory(DATA_STORE_FACTORY)
                                .setAccessType("offline")
                                .build();
                credential = new AuthorizationCodeInstalledApp(
                        flow, new LocalServerReceiver()).authorize("user");
                LOG.info("Credentials saved to " + DATA_STORE_DIR.getAbsolutePath());
            }
        }

        return credential;
    }
}
