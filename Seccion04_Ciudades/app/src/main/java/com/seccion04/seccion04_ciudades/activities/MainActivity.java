package com.seccion04.seccion04_ciudades.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.seccion04.seccion04_ciudades.R;
import com.seccion04.seccion04_ciudades.adapters.TableroAdapter;
import com.seccion04.seccion04_ciudades.app.ApplicationService;
import com.seccion04.seccion04_ciudades.models.Ciudad;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity implements RealmChangeListener<RealmResults<Ciudad>>, AdapterView.OnItemClickListener {

    private Realm realm;
    private ListView listView;
    private TableroAdapter tableroAdapter;
    private RealmResults<Ciudad> ciudades;
    private ApplicationService applicationService = new ApplicationService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Toolbar toolbar = findViewById(R.id.toolbar);
        // setSupportActionBar(toolbar);

        // FloatingActionButton fab = findViewById(R.id.fab);
        // fab.setOnClickListener(new View.OnClickListener() {
        // 	@Override
        // 	public void onClick(View view) {
        // 		Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
        // 	}
        // }

        realm = Realm.getDefaultInstance();
        ciudades = realm.where(Ciudad.class).findAll();

        ciudades.addChangeListener(this);

        tableroAdapter = new TableroAdapter(this, ciudades, R.layout.list_view_item_ciudad);
        listView = findViewById(R.id.lvCiudades);

        listView.setAdapter(tableroAdapter);
        listView.setOnItemClickListener(this);

        // ---------- Borrar todos los datos de la BD
		/*realm.executeTransaction(new Realm.Transaction() {
			@Override
			public void execute(Realm realm) {
				realm.deleteAll();
			}
		});*/
        // ---------------------------------

        // --- Registrar el menu al mantener pulsado un item
        registerForContextMenu(listView);
        // ---------------------------------
    }

    public void irAcrearCiudadClick(View view) {

        // Se cambia al activity de notas pasandole el id del tablero
        Intent intent = new Intent(MainActivity.this, CrearCiudad.class);
        // intent.putExtra("idTablero", tableros.get(posicion).getId());
        startActivity(intent);
    }


    @Override
    public void onChange(RealmResults<Ciudad> ciudades) {
        tableroAdapter.notifyDataSetChanged();
    }

    // ---------- Esto es cuando tocamos un item del listado de tableros
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long id) {

//        // Se cambia al activity de notas pasandole el id del tablero
//        Intent intent = new Intent(MainActivity.this, NotaActivity.class);
//        intent.putExtra("idTablero", tableros.get(posicion).getId());
//        startActivity(intent);
    }
    // ------------------------------------

    // ---------- Este es el menu de los tres puntitos arriba a la derecha
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        boolean resultado;

        switch (item.getItemId()) {
            case R.id.idBorrarTodo:
                applicationService.eliminarTodo();
                resultado = true;
                break;
            default:
                resultado = super.onContextItemSelected(item);
                break;
        }
        return resultado;
    }
    // --------------------------------------------------------------------

}
