

package martin.googlesheetsapi.v7.services;

import android.accounts.Account;
import android.app.Activity;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.ExponentialBackOff;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.util.Arrays;
import java.util.List;

import martin.googlesheetsapi.v7.classes.CommonAsyncTask;
import martin.googlesheetsapi.v7.interfaces.CommonResultGoogleSheetValuesInterface;

public class GoogleSheetsApiService {


    private static final String ACCOUNT_NAME = "martinrossi9009@gmail.com";
    // private static final String ACCOUNT_NAME = "martin-googlesheetsapi@crack-muse-338016.iam.gserviceaccount.com";
    private static final String APPLICATION_NAME = "martin.googlesheetsapi";
    private static final String SPREADSHEET_ID = "1wxtUzQoKCKDQVqL6ztnRiLIaGiFkD2HwLrfI48_ZFlw";
    private Sheets sheetService;
    private Activity activity;
    GoogleAccountCredential mCredential;

    public GoogleSheetsApiService(Activity activity, int idTabla) {
        try {
            this.activity = activity;

            mCredential = GoogleAccountCredential.usingOAuth2(activity.getApplicationContext(), Arrays.asList(SheetsScopes.SPREADSHEETS))
                    .setBackOff(new ExponentialBackOff())
                    .setSelectedAccount(new Account(ACCOUNT_NAME, APPLICATION_NAME));

            HttpTransport transport = AndroidHttp.newCompatibleTransport();
            JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
            sheetService = new Sheets.Builder(transport, jsonFactory, mCredential).build();


            // // Google Accounts
            // GoogleAccountCredential credential = GoogleAccountCredential.usingOAuth2(activity.getApplicationContext(), Collections.singleton(SheetsScopes.SPREADSHEETS));
            // SharedPreferences settings = activity.getPreferences(Context.MODE_PRIVATE);
            // credential.setSelectedAccountName(settings.getString(ACCOUNT_NAME, null));
            // // Tasks client
            // // service =
            // //         new com.google.api.services.tasks.Tasks.Builder(httpTransport, jsonFactory, credential)
            // //                 .setApplicationName("Google-TasksAndroidSample/1.0").build();
            //
            // sheetService = new Sheets.Builder(transport, jsonFactory, mCredential).build();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void getDatos(String range, CommonResultGoogleSheetValuesInterface commonResultGoogleSheetValuesInterface) {
        new CommonAsyncTask(() -> {
            try {
                ValueRange response = sheetService.spreadsheets().values().get(SPREADSHEET_ID, range).execute();
                List<List<Object>> values = response.getValues();

                commonResultGoogleSheetValuesInterface.excecute(values);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public void setDatos(String range) {
        new CommonAsyncTask(() -> {
            try {

                ValueRange valueRange = new ValueRange();
                valueRange.setValues(Arrays.asList(Arrays.asList("holaaaaaaa")));

                sheetService.spreadsheets().values().update(SPREADSHEET_ID, range, valueRange).setValueInputOption("RAW").execute();

                System.out.println("asasdasd");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }


    private static HttpRequestInitializer setHttpTimeout(final HttpRequestInitializer requestInitializer) {
        return httpRequest -> {

            requestInitializer.initialize(httpRequest);
            // This allows the API to call (and avoid timing out on)
            // functions that take up to 6 minutes to complete (the maximum
            // allowed script run time), plus a little overhead.
            httpRequest.setReadTimeout(380000);
        };
    }

}




