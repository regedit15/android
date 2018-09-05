package com.seccion02.seccion02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private ListView listView;
    private List<String> nombres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView = findViewById(R.id.listView);

        nombres = new ArrayList<String>();
        nombres.add("a111");
        nombres.add("222");
        nombres.add("333");
        nombres.add("444");
        nombres.add("555");
        nombres.add("666");
        nombres.add("777");
        nombres.add("888");
        nombres.add("999");
        nombres.add("aaa");
        nombres.add("bbb");
        nombres.add("bbb");
        nombres.add("ccc");
        nombres.add("ddd");
        nombres.add("eee");
        nombres.add("fff");
        nombres.add("ggg");
        nombres.add("hhh");
        nombres.add("iii");
        nombres.add("jjj");
        nombres.add("kkk");

        // Adaptador por defecto (solo una lissta de strings)
        // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, nombres);
        // listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View v, int position, long id) {
                Toast.makeText(ListActivity.this, "Click a: " + nombres.get(position), Toast.LENGTH_SHORT).show();
            }
        });

        // Enlazamos con nuestro adaptador personalizado
        listView.setAdapter(new MyAdapter(this, R.layout.item_lista, nombres));
    }
}
