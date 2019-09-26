package com.seccion04.seccion04_ciudades.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.seccion04.seccion04_ciudades.R;
import com.seccion04.seccion04_ciudades.models.Ciudad;

import io.realm.Realm;

public class CrearCiudad extends AppCompatActivity {

    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_ciudad);

        realm = Realm.getDefaultInstance();
    }

    public void crearCiudadClick(View view) {

        final String nombre = ((EditText) findViewById(R.id.etCiudadNombre)).getText().toString();
        final String descripcion = ((EditText) findViewById(R.id.etCiudadDescripcion)).getText().toString();
        final String urlImagen = ((EditText) findViewById(R.id.etCiudadUrlImagen)).getText().toString();

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealm(new Ciudad(nombre, descripcion, urlImagen));
            }
        });


        Intent intent = new Intent(CrearCiudad.this, MainActivity.class);
        // intent.putExtra("idTablero", tableros.get(posicion).getId());
        startActivity(intent);
    }

    public void eliminarCiudadClick(View view) {

    }
}
