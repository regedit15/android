package com.seccion02.seccion02;

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

public class GridActivity extends AppCompatActivity {

    private List<String> nombres;
    private GridView gridView;
    private MyAdapter adaptador;
    private int contador = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        gridView = findViewById(R.id.gridView);

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

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View v, int position, long id) {
                Toast.makeText(GridActivity.this, "Click a: " + nombres.get(position), Toast.LENGTH_SHORT).show();
            }
        });

        adaptador = new MyAdapter(this, R.layout.grid_item, nombres);

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
                nombres.add("Nuevo item Nro: " + contador++);
                // refrezca el cambio
                adaptador.notifyDataSetChanged();
                resultado = true;
                break;
            default:
                resultado = super.onOptionsItemSelected(item);
        }
        return resultado;
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        menu.setHeaderTitle(nombres.get(info.position));
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        boolean resultado;

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()) {
            case R.id.eliminar_item:
                nombres.remove(info.position);
                // refrezca el cambio
                adaptador.notifyDataSetChanged();
                resultado = true;
                break;
            default:
                resultado = super.onContextItemSelected(item);
        }
        return resultado;
    }
}
