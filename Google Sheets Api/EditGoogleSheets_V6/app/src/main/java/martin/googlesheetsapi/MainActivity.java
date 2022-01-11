package martin.googlesheetsapi;

import android.accounts.Account;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;
import com.google.api.client.util.ExponentialBackOff;
import com.google.api.services.sheets.v4.SheetsScopes;

import java.util.Arrays;
import java.util.List;

import martin.googlesheetsapi.services.GoogleSheetsApiService;
import martin.googlesheetsapi.services.UtilService;


public class MainActivity extends AppCompatActivity {

    private static final String SHEET_1 = "Hoja1!";
    private UtilService utilService = new UtilService(this);
    // private GoogleSheetsApiService googleSheetsApiService = new GoogleSheetsApiService(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String ACCOUNT_NAME = "martinrossi9009@gmail.com";
        String APPLICATION_NAME = "martin.googlesheetsapi.v1";

        // GoogleAccountCredential mCredential = GoogleAccountCredential.usingOAuth2(getApplicationContext(), Arrays.asList(SheetsScopes.SPREADSHEETS_READONLY))
        //         .setBackOff(new ExponentialBackOff())
        //         .setSelectedAccount(new Account(ACCOUNT_NAME, APPLICATION_NAME));

        try {

            GoogleSheetsApiService googleSheetsApiService = new GoogleSheetsApiService(this);

            googleSheetsApiService.getDatos(SHEET_1 + "A:Z", values -> {


                if (values == null || values.isEmpty()) {
                    System.out.println("No data found .");
                } else {
                    for (List row : values) {
                        System.out.printf("%s %s from %s\n", row.get(5), row.get(4), row.get(1));
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }


        // utilService.ceateTable(
        //         R.id.table_main
        //         , new String[]{"Titulo Col 1", "Titulo Col 2", "Titulo Col 3", "Titulo Col 4"}
        //         , new String[]{"a1", "a2", "a3", "a4"}
        //         , new String[]{"b1", "b2", "b3", "b4"}
        // );


    }


}
