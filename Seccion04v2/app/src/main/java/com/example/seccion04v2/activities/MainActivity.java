package com.example.seccion04v2.activities;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.seccion04v2.R;
import com.example.seccion04v2.adapters.TableroAdapter;
import com.example.seccion04v2.models.Tablero;

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

		/*realm.executeTransaction(new Realm.Transaction() {
			@Override
			public void execute(Realm realm) {
				realm.deleteAll();
			}
		});*/
	}

	public void crearTableroClick(View view) {
		showAlertForCreatingBoard("Alta de Tablero", "Ingrese el título");
	}

	private void showAlertForCreatingBoard(String titulo, String mensaje){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);

		if(titulo != null){
			builder.setTitle(titulo);
		}

		if(mensaje != null){
			builder.setMessage(mensaje);
		}

		View vieyInflatter = LayoutInflater.from(this).inflate(R.layout.popup_alta_tablero, null);
		builder.setView(vieyInflatter);

		final EditText input = vieyInflatter.findViewById(R.id.etTableroTitulo);

		builder.setPositiveButton("Agregar", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialogInterface, int i) {
				String titulo = input.getText().toString();

				if(titulo.length() > 0 ){
					crearTablero(titulo);
				}else{
					Toast.makeText(getApplicationContext(), "El titulo es requerido", Toast.LENGTH_SHORT);
				}

			}
		});

		 builder.create().show();
	}

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

	@Override
	public void onChange(RealmResults<Tablero> tableros) {
		tableroAdapter.notifyDataSetChanged();
	}

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long id) {
        Intent intent = new Intent(MainActivity.this, NotaActivity.class);
        intent.putExtra( "idTablero", tableros.get(posicion).getId());
        startActivity(intent);
    }
}
