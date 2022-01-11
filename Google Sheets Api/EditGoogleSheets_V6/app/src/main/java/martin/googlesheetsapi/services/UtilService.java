package martin.googlesheetsapi.services;

import android.graphics.Color;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.List;

import martin.googlesheetsapi.MainActivity;

public class UtilService {

    private MainActivity main;

    public UtilService(MainActivity main) {
        this.main = main;
    }

    public void addRow(Integer idTableLayout, String... titulos) {
        TableLayout tableLayout = main.findViewById(idTableLayout);
        TableRow tbrow0 = new TableRow(main);
        TextView textView;

        for (String titulo : titulos) {
            textView = new TextView(main);
            textView.setText(titulo);
            tbrow0.addView(textView);
        }

        tableLayout.addView(tbrow0);
    }

    public void addRow2(Integer idTableLayout, List titulos) {
        TableLayout tableLayout = main.findViewById(idTableLayout);
        TableRow tbrow0 = new TableRow(main);
        TextView textView;

        for (Object titulo : titulos) {
            textView = new TextView(main);
            textView.setText(titulo.toString());
            tbrow0.addView(textView);
        }

        tableLayout.addView(tbrow0);
    }

    public void ceateTable(Integer idTableLayout, String[]... rows) {
        TableLayout tableLayout = main.findViewById(idTableLayout);
        TableRow tableRow;
        TextView textView;
        for (String[] row : rows) {
            tableRow = new TableRow(main);

            for (String cell : row) {
                textView = new TextView(main);
                textView.setText(cell);
                tableRow.addView(textView);
            }
            tableLayout.addView(tableRow);
        }
    }
}
