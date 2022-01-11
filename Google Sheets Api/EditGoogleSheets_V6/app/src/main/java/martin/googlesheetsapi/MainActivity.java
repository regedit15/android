package martin.googlesheetsapi;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import martin.googlesheetsapi.services.GoogleSheetsApiService;
import martin.googlesheetsapi.services.UtilService;


public class MainActivity extends AppCompatActivity {

    private static final String SHEET_1 = "Hoja1!";
    private UtilService utilService = new UtilService(this);
    private GoogleSheetsApiService googleSheetsApiService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // utilService.addRow(
        //         R.id.table_main
        //         , new String[]{"Titulo Col 1", "Titulo Col 2"}
        //         , new String[]{"a1", "a2"}
        //         , new String[]{"b1", "b2"}
        // );
        // utilService.ceateTable(
        //         R.id.table_main
        //         , new String[]{"Titulo Col 1", "Titulo Col 2", "Titulo Col 3"}
        //         , new String[]{"a1", "a2", "a3"}
        //         , new String[]{"b1", "b2", "b3"}
        // );


        try {
            googleSheetsApiService = new GoogleSheetsApiService(this, R.id.table_main);

            googleSheetsApiService.getDatos(SHEET_1 + "A:Z", values -> {
                runOnUiThread(() -> {
                    for (List row : values) {
                        utilService.addRow2(
                                R.id.table_main
                                , row
                        );
                    }
                });
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
