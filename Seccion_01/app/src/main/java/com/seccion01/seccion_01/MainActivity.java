package com.seccion01.seccion_01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1 Manera de realizar el onClick
        // private Button btn;
        //
        // btn = findViewById(R.id.button01);
        // btn.setOnClickListener(new View.OnClickListener() {
        //     @Override
        //     public void onClick(View v) {
        //
        //     }
        // });
    }


    public void clickBoton4(View v) {
        // System.out.println("sdasdas223");

        // Toast.makeText(MainActivity.this, "sdas", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(MainActivity.this, SegundoActivity.class);
        intent.putExtra("clave", "holaaa");
        startActivity(intent);

    }


}
