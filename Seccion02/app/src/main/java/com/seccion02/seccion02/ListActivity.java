package com.seccion02.seccion02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import models.Frutas;

public class ListActivity extends AppCompatActivity {

    private ListView listView;
    // private List<String> nombres;
    private List<Frutas> frutas = new ArrayList<Frutas>();
    // private MyAdapter adaptador;
    private int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        listView = findViewById(R.id.listView);
        // adaptador = new MyAdapter(this, R.layout.item_lista, frutas);

        // nombres = new ArrayList<String>();
        // nombres.add("a111");
        // nombres.add("222");
        // nombres.add("333");
        // nombres.add("444");
        // nombres.add("555");
        // nombres.add("666");
        // nombres.add("777");
        // nombres.add("888");
        // nombres.add("999");
        // nombres.add("aaa");
        // nombres.add("bbb");
        // nombres.add("bbb");
        // nombres.add("ccc");
        // nombres.add("ddd");
        // nombres.add("eee");
        // nombres.add("fff");
        // nombres.add("ggg");
        // nombres.add("hhh");
        // nombres.add("iii");
        // nombres.add("jjj");
        // nombres.add("kkk");

        agregarFrutas();

        // Adaptador por defecto (solo una lissta de strings)
        // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, nombres);
        // listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View v, int position, long id) {
                Toast.makeText(ListActivity.this, "Click a: " + frutas.get(position).getNombre(), Toast.LENGTH_SHORT).show();
            }
        });

        // Enlazamos con nuestro adaptador personalizado
        listView.setAdapter(new MyAdapter(this, R.layout.grid_item, frutas));
    }

    private void agregarFrutas() {
        frutas.add(new Frutas("Manzana", "Soy una rica manzanita", R.drawable.manzana));
        frutas.add(new Frutas("Banana", "Soy una rica bananita", R.drawable.banana));
        frutas.add(new Frutas("Naranja", "Soy una rica naranjita", R.drawable.naranja));
        frutas.add(new Frutas("Ananá", "Soy una rica ananita", R.drawable.anana));
        frutas.add(new Frutas("Pera", "Soy una rica perita", R.drawable.pera));
        frutas.add(new Frutas("Kiwi", "Soy un rica kiwicito", R.drawable.kiwi));
        frutas.add(new Frutas("Uva", "Soy una rica uvita", R.drawable.uva));
        frutas.add(new Frutas("Limón", "Soy un rico limoncito", R.drawable.limon));
        frutas.add(new Frutas("Tomate", "Soy un rico tomatito", R.drawable.tomate));
        frutas.add(new Frutas("Lechuga", "Soy una rica lechuguita", R.drawable.lechuga));
        frutas.add(new Frutas("Morron", "Soy un rico morroncito", R.drawable.morron));
        frutas.add(new Frutas("Sandía", "Soy una rica sandiita", R.drawable.sandia));
        frutas.add(new Frutas("Chile", "Soy un rico chilecito", R.drawable.pimiento));
        frutas.add(new Frutas("Pepino", "Soy un rico pepinito", R.drawable.pepino));
        frutas.add(new Frutas("Brocoli", "Soy un rico brocolito", R.drawable.brocoli));
        frutas.add(new Frutas("Cebolla", "Soy una rica cebollita", R.drawable.cebolla));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // boolean resultado;

        switch (item.getItemId()) {
            case R.id.agregar_item:
                frutas.add(new Frutas("Nuevo item Nro: " + contador++, "Soy una rica frutita!", R.drawable.question));
                // refrezca el cambio
                // adaptador.notifyDataSetChanged();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
        // return resultado;
    }

}
