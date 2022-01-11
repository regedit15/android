package martin.googlesheetsapi;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
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

                //
                for (List row : values) {
                    //     utilService.addRow2(
                    //             R.id.table_main
                    //             , row
                    //             // , new String[]{"Titulo Col 1", "Titulo Col 2", "Titulo Col 3", "Titulo Col 4"}
                    //     );
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void dibujarTablaEstatica() {
        TableLayout tableLayout = (TableLayout) findViewById(R.id.table_main);

        TableRow tbrow0 = new TableRow(this);

        TextView tv0 = new TextView(this);
        tv0.setText("Titulo Col 1");
        tv0.setTextColor(Color.WHITE);
        tbrow0.addView(tv0);

        TextView tv1 = new TextView(this);
        tv1.setText("Titulo Col 2");
        tv1.setTextColor(Color.WHITE);
        tbrow0.addView(tv1);

        TextView tv2 = new TextView(this);
        tv2.setText("Titulo Col 3");
        tv2.setTextColor(Color.WHITE);
        tbrow0.addView(tv2);

        TextView tv3 = new TextView(this);
        tv3.setText("Titulo Col 4");
        tv3.setTextColor(Color.WHITE);
        tbrow0.addView(tv3);

        tableLayout.addView(tbrow0);

        //------------
        TableRow tbrow1 = new TableRow(this);

        TextView t1v = new TextView(this);
        t1v.setText("a1");
        t1v.setTextColor(Color.WHITE);
        t1v.setGravity(Gravity.CENTER);
        tbrow1.addView(t1v);

        TextView t2v = new TextView(this);
        t2v.setText("a2");
        t2v.setTextColor(Color.WHITE);
        t2v.setGravity(Gravity.CENTER);
        tbrow1.addView(t2v);

        TextView t3v = new TextView(this);
        t3v.setText("a3");
        t3v.setTextColor(Color.WHITE);
        t3v.setGravity(Gravity.CENTER);
        tbrow1.addView(t3v);

        TextView t4v = new TextView(this);
        t4v.setText("a4");
        t4v.setTextColor(Color.WHITE);
        t4v.setGravity(Gravity.CENTER);
        tbrow1.addView(t4v);

        tableLayout.addView(tbrow1);

        // ----------------
        TableRow tbrow2 = new TableRow(this);

        TextView t5v = new TextView(this);
        t5v.setText("b1");
        t5v.setTextColor(Color.WHITE);
        t5v.setGravity(Gravity.CENTER);
        tbrow2.addView(t5v);

        TextView t6v = new TextView(this);
        t6v.setText("b2");
        t6v.setTextColor(Color.WHITE);
        t6v.setGravity(Gravity.CENTER);
        tbrow2.addView(t6v);

        TextView t7v = new TextView(this);
        t7v.setText("b3");
        t7v.setTextColor(Color.WHITE);
        t7v.setGravity(Gravity.CENTER);
        tbrow2.addView(t7v);

        TextView t8v = new TextView(this);
        t8v.setText("b4");
        t8v.setTextColor(Color.WHITE);
        t8v.setGravity(Gravity.CENTER);
        tbrow2.addView(t8v);

        tableLayout.addView(tbrow2);
    }


}
