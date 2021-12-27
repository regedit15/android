package martin.googlesheetsapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private static Sheets sheetsService;
    private static final String SPREADSHEET_ID = "1E1z-MY5q3jbX0dIX1W8KHxT7mpbwpMeWKYxutdpHd6E";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //-----------------------------------------------------

        try {
            sheetsService = SheetsQuickstart222.getSheetsService(this);


            String range = "Hoja1!A1:C2";

            ValueRange response = null;
            response = sheetsService.spreadsheets().values()
                    .get(SPREADSHEET_ID, range)
                    .execute();

            List<List<Object>> values = response.getValues();

            if (values == null || values.isEmpty()) {
                System.out.println("No data found.");
            } else {
                for (List row : values) {
                    //                System.out.printf("%s, %s\n", row.get(0), row.get(4));
                    System.out.printf("%s %s from %s\n", row.get(5), row.get(4), row.get(1));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}