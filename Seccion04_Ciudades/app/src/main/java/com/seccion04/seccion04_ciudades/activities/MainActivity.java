package com.seccion04.seccion04_ciudades.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.seccion04.seccion04_ciudades.R;
import com.seccion04.seccion04_ciudades.adapters.CiudadAdapter;
import com.seccion04.seccion04_ciudades.app.ApplicationService;
import com.seccion04.seccion04_ciudades.models.Ciudad;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity implements RealmChangeListener<RealmResults<Ciudad>> {

	private Realm realm;
	private RecyclerView recyclerView;
	private CiudadAdapter ciudadAdapter;
	private RealmResults<Ciudad> ciudades;
	private RecyclerView.LayoutManager mLayoutManager;
	private FloatingActionButton floatingActionButton;
	private ApplicationService applicationService = new ApplicationService();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// setHasOptionsMenu(true);
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

		// ---------- Borrar todos los datos de la BD
		// realm.executeTransaction(new Realm.Transaction() {
		//     @Override
		//     public void execute(Realm realm) {
		//         realm.deleteAll();
		//     }
		// });
		// ---------------------------------

		ciudades = realm.where(Ciudad.class).findAll();
		ciudades.addChangeListener(this);


		recyclerView = findViewById(R.id.rvListadoCiudades);
		recyclerView.setHasFixedSize(true);
		recyclerView.setItemAnimator(new DefaultItemAnimator());
		mLayoutManager = new LinearLayoutManager(this);
		recyclerView.setLayoutManager(mLayoutManager);


		floatingActionButton = findViewById(R.id.btAgregarCiudad);

		recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
			@Override
			public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
				if (dy > 0) {
					floatingActionButton.hide();
				} else if (dy < 0) {
					floatingActionButton.show();
				}
			}
		});


		ciudadAdapter = new CiudadAdapter(ciudades, R.layout.list_view_item_ciudad, new CiudadAdapter.OnItemClickListener() {
			@Override
			public void onItemClick(Ciudad ciudad, int position) {
				Intent intent = new Intent(MainActivity.this, CrearCiudad.class);
				intent.putExtra("idCiudad", ciudad.getId());
				startActivity(intent);
			}
		}, new CiudadAdapter.OnButtonClickListener() {
			@Override
			public void onButtonClick(Ciudad ciudad, int position) {
				mostrarPopupEliminarCiudad("Eliminar ciudad", "Esta seguro que desea eliminar la ciudad " + ciudad.getNombre() + "?", position);
			}
		});

		recyclerView.setAdapter(ciudadAdapter);
		ciudades.addChangeListener(this);


		// ---------- Borrar todos los datos de la BD
		/*realm.executeTransaction(new Realm.Transaction() {
			@Override
			public void execute(Realm realm) {
				realm.deleteAll();
			}
		});*/
		// ---------------------------------

		// --- Registrar el menu al mantener pulsado un item
		// registerForContextMenu(listView);
		// ---------------------------------
	}

	private void mostrarPopupEliminarCiudad(String title, String message, final int position) {

		new AlertDialog.Builder(this).setTitle(title).setMessage(message).setPositiveButton("Eliminar", new DialogInterface.OnClickListener() {

			public void onClick(DialogInterface dialog, int whichButton) {
				applicationService.eliminarCiudad(ciudades.get(position));
				Toast.makeText(MainActivity.this, "La ciudad ha sido elimindada", Toast.LENGTH_SHORT).show();
			}
		}).setNegativeButton("Cancelar", null).show();
	}

	@Override
	public void onChange(RealmResults<Ciudad> ciudades) {
		ciudadAdapter.notifyDataSetChanged();
	}

	// // ---------- Esto es cuando tocamos un item del listado de tableros
	// @Override
	// public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long id) {
	//
	// 	// Se cambia al activity de notas pasandole el id del tablero
	// 	Intent intent = new Intent(MainActivity.this, CrearCiudad.class);
	// 	intent.putExtra("idCiudad", ciudades.get(posicion).getId());
	// 	startActivity(intent);
	// }
	// // ------------------------------------

	// ---------- Este es el menu de los tres puntitos arriba a la derecha
	// @Override
	// public boolean onCreateOptionsMenu(Menu menu) {
	// 	getMenuInflater().inflate(R.menu.menu_main, menu);
	// 	return super.onCreateOptionsMenu(menu);
	// }
	//
	// @Override
	// public boolean onOptionsItemSelected(@NonNull MenuItem item) {
	// 	boolean resultado;
	//
	// 	switch (item.getItemId()) {
	// 		case R.id.idBorrarTodo:
	// 			applicationService.eliminarTodo();
	// 			resultado = true;
	// 			break;
	// 		default:
	// 			resultado = super.onContextItemSelected(item);
	// 			break;
	// 	}
	// 	return resultado;
	// }
	// --------------------------------------------------------------------

	public void irAGuardarCiudadClick(View view) {
		Intent intent = new Intent(MainActivity.this, CrearCiudad.class);
		startActivity(intent);
	}

}
