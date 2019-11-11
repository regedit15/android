package com.example.seccion10_tabs;

import android.os.Bundle;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Toolbar myToolbar = findViewById(R.id.my_toolbar);
		//Esto es para convertir el toolbar en un action bar. Por lo que mostrara el titulo
		setSupportActionBar(myToolbar);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_action_bar, menu);
		return super.onCreateOptionsMenu(menu);
	}
}
