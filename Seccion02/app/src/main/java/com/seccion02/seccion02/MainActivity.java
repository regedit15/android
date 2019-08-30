package com.seccion02.seccion02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import adapters.GenericAdapter;
import models.Frutas;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listView;
    private GridView gridView;
    private GenericAdapter listAdapter;
    private GenericAdapter gridAdapter;
    private List<Frutas> frutas = new ArrayList<Frutas>();
    private int contador = 0;
    private final int CAMBIAR_LIST_VIEW = 1;
    private final int CAMBIAR_GRID_VIEW = 2;

    private MenuItem menuItemList;
    private MenuItem menuItemGrid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        agregarFrutas();

        listView = findViewById(R.id.listView);
        gridView = findViewById(R.id.gridView);

        listView.setOnItemClickListener(this);
        gridView.setOnItemClickListener(this);

        listAdapter = new GenericAdapter(this, R.layout.item_lista, frutas);
        gridAdapter = new GenericAdapter(this, R.layout.grid_item, frutas);

        listView.setAdapter(listAdapter);
        gridView.setAdapter(gridAdapter);

        registerForContextMenu(listView);
        registerForContextMenu(gridView);
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
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(MainActivity.this, "Click a: " + frutas.get(position).getNombre(), Toast.LENGTH_SHORT).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar_menu, menu);
        menuItemList = menu.findItem(R.id.itemVistaLista);
        menuItemGrid = menu.findItem(R.id.itemVistaGrid);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean resultado;

        switch (item.getItemId()) {
            case R.id.itemAgregarFruta:
                frutas.add(new Frutas("Fruta Nro: " + contador++, "Soy una rica frutita!", R.drawable.question));
                // refrezca el cambio
                listAdapter.notifyDataSetChanged();
                gridAdapter.notifyDataSetChanged();
                resultado = true;
                break;
            case R.id.itemVistaLista:
                cambiarListaOGrilla(CAMBIAR_LIST_VIEW);
                resultado = true;
                break;
            case R.id.itemVistaGrid:
                cambiarListaOGrilla(CAMBIAR_GRID_VIEW);
                resultado = true;
                break;
            default:
                resultado = super.onOptionsItemSelected(item);
                break;
        }
        return resultado;
    }

    private void cambiarListaOGrilla(int cambiar_grid_view) {
        switch (cambiar_grid_view) {
            case CAMBIAR_LIST_VIEW:
                listView.setVisibility(View.VISIBLE);
                gridView.setVisibility(View.INVISIBLE);
                menuItemList.setVisible(false);
                menuItemGrid.setVisible(true);
                break;
            case CAMBIAR_GRID_VIEW:
                listView.setVisibility(View.INVISIBLE);
                gridView.setVisibility(View.VISIBLE);
                menuItemList.setVisible(true);
                menuItemGrid.setVisible(false);
                break;
        }
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
                listAdapter.notifyDataSetChanged();
                gridAdapter.notifyDataSetChanged();
                resultado = true;
                break;
            default:
                resultado = super.onContextItemSelected(item);
        }
        return resultado;
    }
}
