package com.seccion02.seccion02;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void irAListViewClick(View v) {
        startActivity(new Intent(MainActivity.this, ListActivity.class));
    }

    public void irAGridViewClick(View v) {
        startActivity(new Intent(MainActivity.this, GridActivity.class));
    }

}
