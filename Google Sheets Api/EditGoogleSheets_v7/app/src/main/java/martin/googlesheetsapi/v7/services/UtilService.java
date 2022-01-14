package martin.googlesheetsapi.v7.services;

import android.app.Activity;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.List;

public class UtilService {

    private Activity activity;

    public UtilService(Activity activity) {
        this.activity = activity;
    }

    public void addRow(Integer idTableLayout, String... titulos) {
        TableLayout tableLayout = activity.findViewById(idTableLayout);
        TableRow tbrow0 = new TableRow(activity);
        TextView textView;

        for (String titulo : titulos) {
            textView = new TextView(activity);
            TableRow.LayoutParams p = new TableRow.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            p.weight = 1;
            textView.setLayoutParams(p);
            textView.setGravity(Gravity.CENTER);
            textView.setText(titulo);
            tbrow0.addView(textView);
        }

        tableLayout.addView(tbrow0);
    }

    public void addRow2(Integer idTableLayout, List titulos) {
        TableLayout tableLayout = activity.findViewById(idTableLayout);
        TableRow tbrow0 = new TableRow(activity);
        TextView textView;

        for (Object titulo : titulos) {
            textView = new TextView(activity);
            textView.setText(titulo.toString());
            TableRow.LayoutParams p = new TableRow.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            p.weight = 1;
            textView.setLayoutParams(p);
            textView.setGravity(Gravity.CENTER);

            tbrow0.addView(textView);
        }

        tableLayout.addView(tbrow0);
    }

    public void ceateTable(Integer idTableLayout, String[]... rows) {
        TableLayout tableLayout = activity.findViewById(idTableLayout);
        TableRow tableRow;
        TextView textView;
        for (String[] row : rows) {
            tableRow = new TableRow(activity);

            for (String cell : row) {
                textView = new TextView(activity);
                TableRow.LayoutParams p = new TableRow.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                p.weight = 1;
                textView.setLayoutParams(p);
                textView.setGravity(Gravity.CENTER);
                textView.setText(cell);
                tableRow.addView(textView);
            }
            tableLayout.addView(tableRow);
        }
    }
}
