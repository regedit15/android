package martin.googlesheetsapi;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import martin.googlesheetsapi.services.GoogleSheetsApiService;


public class MainActivity extends AppCompatActivity {

    private static final String SHEET_1 = "Hoja1!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        GoogleSheetsApiService googleSheetsApiService = new GoogleSheetsApiService(this);

        googleSheetsApiService.getDatos(SHEET_1 + "A1:C2", values -> {
            if (values == null || values.isEmpty()) {
                System.out.println("No data found .");
            } else {
                for (List row : values) {
                    System.out.printf("%s %s from %s\n", row.get(5), row.get(4), row.get(1));
                }
            }
        });
    }


}