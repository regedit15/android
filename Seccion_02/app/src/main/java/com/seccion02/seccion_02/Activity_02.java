package com.seccion02.seccion_02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Activity_02 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_02);

        //activar flecha ir atras
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
}
