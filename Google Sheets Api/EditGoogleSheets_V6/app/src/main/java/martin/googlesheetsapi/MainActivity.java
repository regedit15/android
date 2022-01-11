package martin.googlesheetsapi;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

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
