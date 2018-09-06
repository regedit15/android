package com.seccion02.seccion02;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import adapters.MyGridAdapter;
import models.Frutas;

public class GridActivity extends AppCompatActivity {

    private List<Frutas> frutas = new ArrayList<Frutas>();
    private GridView gridView;
    private MyGridAdapter adaptador;
    private int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        gridView = findViewById(R.id.gridView);
        agregarFrutas();

        // Adaptador por defecto (solo una lissta de strings)
        // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, nombres);
        // listView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View v, int position, long id) {
                Toast.makeText(GridActivity.this, "Click a: " + frutas.get(position).getNombre(), Toast.LENGTH_SHORT).show();
            }
        });

        adaptador = new MyGridAdapter(this, R.layout.grid_item, frutas);

        // Enlazamos con nuestro adaptador personalizado
        gridView.setAdapter(adaptador);

        // Le decimos a nuestro gridView que va a tener un context menu
        registerForContextMenu(gridView);
    }


    // El xml action_bar_menu lo creamos haciendo boton derecho en la carpeta
    // resource --> new --> Android Resource Directory. Le ponemos el nombre y
    // en "Resource Type" le ponemos el valor "menu". Despues boton derecho en
    // la carpeta menu --> new --> Menu Resource File
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean resultado;

        switch (item.getItemId()) {
            case R.id.agregar_item:
                // nombres.add("Nuevo item Nro: " + contador++);
                frutas.add(new Frutas("Nuevo item Nro: " + contador++, "Soy una rica frutita!", R.drawable.question));
                // refrezca el cambio
                adaptador.notifyDataSetChanged();
                resultado = true;
                break;
            case R.id.vistaLista:
                startActivity(new Intent(GridActivity.this, ListActivity.class));
                resultado = true;
                break;
            default:
                resultado = super.onOptionsItemSelected(item);
                break;
        }
        return resultado;
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        menu.setHeaderTitle(frutas.get(info.position).getNombre());
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        boolean resultado;

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()) {
            case R.id.eliminar_item:
                frutas.remove(info.position);
                // refrezca el cambio
                adaptador.notifyDataSetChanged();
                resultado = true;
                break;
            default:
                resultado = super.onContextItemSelected(item);
        }
        return resultado;
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

}
