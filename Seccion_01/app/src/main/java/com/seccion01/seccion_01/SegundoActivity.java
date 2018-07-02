package com.seccion01.seccion_01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SegundoActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);

        textView = findViewById(R.id.texto1);

        // Tomar datos del indent
        // Bundle, es un objeto que sirve para ser pasado entre activities y llevar informacion. En criollo seria como un "paquete" o "caja" que almacena informacion y se pasa entre activities

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String texto = bundle.getString("clave");
            Toast.makeText(SegundoActivity.this, texto, Toast.LENGTH_LONG).show();
            textView.setText(texto);
        } else {
            Toast.makeText(SegundoActivity.this, "Esta vacio!", Toast.LENGTH_LONG).show();
        }
    }


    public void irATercerActivity(View v) {
        Intent intent = new Intent(SegundoActivity.this, ActivityTres.class);
        startActivity(intent);
    }
}
