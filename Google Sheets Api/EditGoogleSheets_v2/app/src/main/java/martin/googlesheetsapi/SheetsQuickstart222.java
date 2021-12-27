package martin.googlesheetsapi;

import android.content.Context;
import android.os.Environment;
import android.os.StrictMode;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;

public class SheetsQuickstart222 {

    //    private static final Sheets sheetsService = null;
    // aca dice que va cualquier nombre, no importa
    private static final String APPLICATION_NAME = "prueba1";
    // private static final String CREDENTIALS_FILE_PATH = "googleSheetsApiCredentialv3EscritorioTutorialVideo.json";
    private static final String CREDENTIALS_FILE_PATH = "OAuthClientForAndroid.json";
    //    private static final String SPREADSHEET_ID = "1E1z-MY5q3jbX0dIX1W8KHxT7mpbwpMeWKYxutdpHd6E";


    private static Credential authorize(Context context) throws IOException, GeneralSecurityException {


        // InputStream in = MainActivity.class.getResourceAsStream(CREDENTIALS_FILE_PATH);

        InputStream in = context.getAssets().open(CREDENTIALS_FILE_PATH);
        File tokenFolder = new File(context.getExternalFilesDir("").getAbsolutePath() + "/tokens");
        // File tokenFolder = new File("tokens");


        // File tokenFolder = new File(Environment.getExternalStorageDirectory() + File.separator + "tokens");

        if (!tokenFolder.exists()) {
            tokenFolder.mkdirs();
        }


        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JacksonFactory.getDefaultInstance(), new InputStreamReader(in));


        List<String> scopes = Arrays.asList(SheetsScopes.SPREADSHEETS);

        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                GoogleNetHttpTransport.newTrustedTransport(),
                JacksonFactory.getDefaultInstance(),
                clientSecrets,
                scopes
                // ).setDataStoreFactory(new FileDataStoreFactory(new File("tokens")))
        ).setDataStoreFactory(new FileDataStoreFactory(tokenFolder))
                .setAccessType("offline")
                .build();


        // Credential credential1 = flow.loadCredential("user"); // we got credential null here
        // Credential credential2 = flow.loadCredential("martinrossi9009@gmail.com"); // we got credential null here

        // Credential credential = new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
        Credential credential = new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");

        return credential;
    }


    public static Sheets getSheetsService(Context context) throws GeneralSecurityException, IOException {
        Credential credential = authorize(context);

        Sheets sheets = new Sheets.Builder(GoogleNetHttpTransport.newTrustedTransport(),
                JacksonFactory.getDefaultInstance(), credential)
                .setApplicationName(APPLICATION_NAME)
                .build();

        return sheets;
    }

}