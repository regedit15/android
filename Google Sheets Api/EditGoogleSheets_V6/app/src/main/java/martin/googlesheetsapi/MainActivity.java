package martin.googlesheetsapi;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import martin.googlesheetsapi.services.UtilService;


public class MainActivity extends AppCompatActivity {

    private static final String SHEET_1 = "Hoja1!";
    private UtilService utilService = new UtilService(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // GoogleSheetsApiService googleSheetsApiService = new GoogleSheetsApiService(this);
        //
        // googleSheetsApiService.getDatos(SHEET_1 + "A1:C2", values -> {
        //     if (values == null || values.isEmpty()) {
        //         System.out.println("No data found .");
        //     } else {
        //         for (List row : values) {
        //             System.out.printf("%s %s from %s\n", row.get(5), row.get(4), row.get(1));
        //         }
        //     }
        // });


        utilService.ceateTable(
                R.id.table_main
                , new String[]{"Titulo Col 1", "Titulo Col 2", "Titulo Col 3", "Titulo Col 4"}
                , new String[]{"a1", "a2", "a3", "a4"}
                , new String[]{"b1", "b2", "b3", "b4"}
        );


    }


}