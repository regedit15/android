package com.example.seccion04v2.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.seccion04v2.R;
import com.example.seccion04v2.adapters.NotaAdapter;
import com.example.seccion04v2.models.Nota;
import com.example.seccion04v2.models.Tablero;

import io.realm.Realm;
import io.realm.RealmList;

public class NotaActivity extends AppCompatActivity {

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
        notas = tablero.getNotas();

        this.setTitle(tablero.getTitulo());

        listView = findViewById(R.id.lvNotas);
        notaAdapter = new NotaAdapter(this, notas, R.layout.list_view_item_nota);
        listView.setAdapter(notaAdapter);

    }

    public void crearNotaClick(View view) {
        showAlertForCreatingNota("Alta de Nota", "Ingrese una descripcion");
    }

    private void showAlertForCreatingNota(String titulo, String mensaje){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        if(titulo != null){
            builder.setTitle(titulo);
        }

        if(mensaje != null){
            builder.setMessage(mensaje);
        }

        View vieyInflatter = LayoutInflater.from(this).inflate(R.layout.popup_alta_nota, null);
        builder.setView(vieyInflatter);

        final EditText input = vieyInflatter.findViewById(R.id.etNotaDescripcion);

        builder.setPositiveButton("Agregar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String titulo = input.getText().toString();

                if(titulo.length() > 0 ){
                    crearNota(titulo);
                }else{
                    Toast.makeText(getApplicationContext(), "La descripcion es requerida", Toast.LENGTH_SHORT);
                }

            }
        });

        builder.create().show();
    }

    private void crearNota(String descripcion) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Nota nota = new Nota(descripcion);
                realm.copyToRealm(tablero);
                tablero.get
            }
        });
    }
}
