package com.example.seccion04v2.activities;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.seccion04v2.R;
import com.example.seccion04v2.adapters.TableroAdapter;
import com.example.seccion04v2.models.Tablero;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity implements RealmChangeListener<RealmResults<Tablero>>, AdapterView.OnItemClickListener {

	private Realm realm;
	private ListView listView;
	private TableroAdapter tableroAdapter;
	private RealmResults<Tablero> tableros;

	@SuppressLint("WrongViewCast")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		realm = Realm.getDefaultInstance();
		tableros = realm.where(Tablero.class).findAll();

		tableros.addChangeListener(this);

		tableroAdapter = new TableroAdapter(this, tableros, R.layout.list_view_item_tablero);
		listView = findViewById(R.id.lvTableros);

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

	public void crearTableroClick(View view) {
		mostrarAlertAltaTablero("Alta de Tablero", "Ingrese el título");
	}

	private void mostrarAlertAltaTablero(String titulo, String mensaje) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);

		if (titulo != null) {
			builder.setTitle(titulo);
		}

		if (mensaje != null) {
			builder.setMessage(mensaje);
		}

		View vieyInflatter = LayoutInflater.from(this).inflate(R.layout.popup_alta_tablero, null);
		builder.setView(vieyInflatter);

		final EditText input = vieyInflatter.findViewById(R.id.etTableroTitulo);

		builder.setPositiveButton("Agregar", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialogInterface, int i) {
				String titulo = input.getText().toString();

				if (titulo.length() > 0) {
					crearTablero(titulo);
				} else {
					Toast.makeText(getApplicationContext(), "El titulo es requerido", Toast.LENGTH_SHORT);
				}

			}
		});

		builder.create().show();
	}

	private void mostrarAlertEditarTablero(String titulo, String mensaje, final Tablero tablero) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);

		if (titulo != null) {
			builder.setTitle(titulo);
		}

		if (mensaje != null) {
			builder.setMessage(mensaje);
		}

		View vieyInflatter = LayoutInflater.from(this).inflate(R.layout.popup_alta_tablero, null);
		builder.setView(vieyInflatter);

		final EditText input = vieyInflatter.findViewById(R.id.etTableroTitulo);
		input.setText(tablero.getTitulo());

		builder.setPositiveButton("Agregar", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialogInterface, int i) {
				String titulo = input.getText().toString();

				if (titulo.length() == 0) {
					Toast.makeText(getApplicationContext(), "El titulo es obligatorio", Toast.LENGTH_SHORT);
				} else if (titulo.equals(tablero.getTitulo())) {
					Toast.makeText(getApplicationContext(), "El titulo es el mismo", Toast.LENGTH_SHORT);
				} else {
					editarTituloTablero(titulo, tablero);
				}

			}
		});

		builder.create().show();
	}

	// ------------------ Metodos de AMB
	private void crearTablero(final String titulo) {

		// Se puede hacer de esta forma
		//realm.beginTransaction();
		//realm.commitTransaction();

		// O de esta
		realm.executeTransaction(new Realm.Transaction() {
			@Override
			public void execute(Realm realm) {
				Tablero tablero = new Tablero(titulo);
				realm.copyToRealm(tablero);
			}
		});
	}

	private void eliminarTablero(final Tablero tablero) {
		realm.executeTransaction(new Realm.Transaction() {
			@Override
			public void execute(Realm realm) {
				tablero.deleteFromRealm();
			}
		});
	}

	private void eliminarTodo() {
		realm.executeTransaction(new Realm.Transaction() {
			@Override
			public void execute(Realm realm) {
				realm.deleteAll();
			}
		});
	}

	private void editarTituloTablero(final String titulo, final Tablero tablero) {
		realm.executeTransaction(new Realm.Transaction() {
			@Override
			public void execute(Realm realm) {
				tablero.setTitulo(titulo);
				realm.copyToRealmOrUpdate(tablero);
			}
		});
	}
	// ------------------------------------------------------------

	@Override
	public void onChange(RealmResults<Tablero> tableros) {
		tableroAdapter.notifyDataSetChanged();
	}

	// ---------- Esto es cuando tocamos un item del listado de tableros
	@Override
	public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long id) {

		// Se cambia al activity de notas pasandole el id del tablero
		Intent intent = new Intent(MainActivity.this, NotaActivity.class);
		intent.putExtra("idTablero", tableros.get(posicion).getId());
		startActivity(intent);
	}
	// ------------------------------------

	// ---------- Este es el menu de los tres puntitos arriba a la derecha
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_tablero, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(@NonNull MenuItem item) {
		boolean resultado;

		switch (item.getItemId()) {
			case R.id.itEliminarTableros:
				eliminarTodo();
				resultado = true;
				break;
			default:
				resultado = super.onContextItemSelected(item);
				break;
		}
		return resultado;
	}
	// --------------------------------------------------------------------

	// --------- Este es el menu desplegable que aparece al dejar presionado un item del listado de tableros
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
		AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
		menu.setHeaderTitle(tableros.get(info.position).getTitulo());
		getMenuInflater().inflate(R.menu.context_menu_tablero, menu);
	}

	@Override
	public boolean onContextItemSelected(@NonNull MenuItem item) {

		boolean resultado;
		AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
		switch (item.getItemId()) {
			case R.id.itEditarNombreTablero:
				mostrarAlertEditarTablero("Editar tablero", "Cambiar el nombre del tablero", tableros.get(info.position));
				resultado = true;
				break;
			case R.id.itEliminarTablero:
				eliminarTablero(tableros.get(info.position));
				resultado = true;
				break;
			default:
				resultado = super.onContextItemSelected(item);
				break;
		}
		return resultado;
	}
	// -----------------------------------------------------
}
