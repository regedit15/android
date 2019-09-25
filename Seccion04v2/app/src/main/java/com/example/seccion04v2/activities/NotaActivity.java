package com.example.seccion04v2.activities;

import android.content.DialogInterface;
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
import com.example.seccion04v2.adapters.NotaAdapter;
import com.example.seccion04v2.models.Nota;
import com.example.seccion04v2.models.Tablero;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmList;

public class NotaActivity extends AppCompatActivity implements RealmChangeListener<Tablero> {

	private Realm realm;
	private ListView listView;
	private NotaAdapter notaAdapter;
	private RealmList<Nota> notas;

	private int idNota;
	private Tablero tablero;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nota);

		realm = Realm.getDefaultInstance();


		Bundle bundle = getIntent().getExtras();

		if (bundle != null) {
			idNota = bundle.getInt("idTablero");
		}

		tablero = realm.where(Tablero.class).equalTo("id", idNota).findFirst();
		tablero.addChangeListener(this);
		notas = tablero.getNotas();

		this.setTitle(tablero.getTitulo());

		listView = findViewById(R.id.lvNotas);
		notaAdapter = new NotaAdapter(this, notas, R.layout.list_view_item_nota);
		listView.setAdapter(notaAdapter);


		// --- Registrar el menu al mantener pulsado un item
		registerForContextMenu(listView);
		// ---------------------------------
	}


	// ------------------ Metodos de AMB

	private void crearNota(final String descripcion) {
		realm.executeTransaction(new Realm.Transaction() {
			@Override
			public void execute(Realm realm) {
				Nota nota = new Nota(descripcion);
				realm.copyToRealm(tablero);
				tablero.getNotas().add(nota);
			}
		});
	}

	private void eliminarNota(final Nota nota) {
		realm.executeTransaction(new Realm.Transaction() {
			@Override
			public void execute(Realm realm) {
				nota.deleteFromRealm();
			}
		});
	}

	private void eliminarTodo() {
		realm.executeTransaction(new Realm.Transaction() {
			@Override
			public void execute(Realm realm) {
				tablero.getNotas().deleteAllFromRealm();
			}
		});
	}

	private void editarDescripcionNota(final String descripcion, final Nota nota) {
		realm.executeTransaction(new Realm.Transaction() {
			@Override
			public void execute(Realm realm) {
				nota.setDescripcion(descripcion);
				realm.copyToRealmOrUpdate(nota);
			}
		});
	}
	// ------------------------------------------------------------

	public void crearNotaClick(View view) {
		mostrarAlertCrearNota("Alta de Nota", "Ingrese una descripcion");
	}

	private void mostrarAlertCrearNota(String titulo, String mensaje) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);

		if (titulo != null) {
			builder.setTitle(titulo);
		}

		if (mensaje != null) {
			builder.setMessage(mensaje);
		}

		View vieyInflatter = LayoutInflater.from(this).inflate(R.layout.popup_alta_nota, null);
		builder.setView(vieyInflatter);

		final EditText input = vieyInflatter.findViewById(R.id.etNotaDescripcion);

		builder.setPositiveButton("Agregar", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialogInterface, int i) {
				String titulo = input.getText().toString();

				if (titulo.length() > 0) {
					crearNota(titulo);
				} else {
					Toast.makeText(getApplicationContext(), "La descripcion es requerida", Toast.LENGTH_SHORT);
				}
			}
		});

		builder.create().show();
	}

	private void mostrarAlertEditarNota(String titulo, String mensaje, final Nota nota) {
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
		input.setText(nota.getDescripcion());

		builder.setPositiveButton("Agregar", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialogInterface, int i) {
				String titulo = input.getText().toString();

				if (titulo.length() == 0) {
					Toast.makeText(getApplicationContext(), "El titulo es obligatorio", Toast.LENGTH_SHORT);
				} else if (titulo.equals(nota.getDescripcion())) {
					Toast.makeText(getApplicationContext(), "El titulo es el mismo", Toast.LENGTH_SHORT);
				} else {
					editarDescripcionNota(titulo, nota);
				}

			}
		});

		builder.create().show();
	}

	@Override
	public void onChange(Tablero tablero) {
		notaAdapter.notifyDataSetChanged();
	}

	// --------- Este es el menu desplegable que aparece al dejar presionado un item del listado de tableros
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
		getMenuInflater().inflate(R.menu.context_menu_nota, menu);
	}

	@Override
	public boolean onContextItemSelected(@NonNull MenuItem item) {

		boolean resultado;
		AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
		switch (item.getItemId()) {
			case R.id.itEditarDescripcionNota:
				mostrarAlertEditarNota("Editar nota", "Cambiar la descripcion", notas.get(info.position));
				resultado = true;
				break;
			case R.id.itEliminarNota:
				eliminarNota(notas.get(info.position));
				resultado = true;
				break;
			default:
				resultado = super.onContextItemSelected(item);
				break;
		}
		return resultado;
	}
	// -----------------------------------------------------

	// ---------- Este es el menu de los tres puntitos arriba a la derecha
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_nota, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(@NonNull MenuItem item) {
		boolean resultado;

		switch (item.getItemId()) {
			case R.id.itEliminarNotas:
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

}
