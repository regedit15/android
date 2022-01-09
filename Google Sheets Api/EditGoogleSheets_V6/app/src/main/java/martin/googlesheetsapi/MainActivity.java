package martin.googlesheetsapi;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import martin.googlesheetsapi.services.GoogleSheetsApiService;


public class MainActivity extends AppCompatActivity {

    private static final String SHEET_1 = "Hoja1!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        GoogleSheetsApiService googleSheetsApiService = new GoogleSheetsApiService(this);
        googleSheetsApiService.getDatos(SHEET_1 + "A1:C2");
    }


}