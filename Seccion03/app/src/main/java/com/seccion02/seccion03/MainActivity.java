package com.seccion02.seccion03;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import adapters.MyAdapter;

public class MainActivity extends AppCompatActivity {

    private List<String> nombres;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setearLista();
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);

        adapter = new MyAdapter(nombres, R.layout.recycler_view_item, new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String nombre, int position) {
                Toast.makeText(MainActivity.this, nombre + " - " + position, Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void setearLista() {
        nombres = new ArrayList<String>();
        nombres.add("Martin");
        nombres.add("Vidal");
        nombres.add("Pepe");
        nombres.add("Massa");
        nombres.add("Pedro");
        nombres.add("Pepin");
        nombres.add("Gonzalo");
        nombres.add("Macri");
        nombres.add("Del Caño");
    }
}
