package com.example.seccion11_navigationdrawer;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class MainActivity extends AppCompatActivity {

	DrawerLayout drawerLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		Toolbar myToolbar = findViewById(R.id.toolbar);
		setSupportActionBar(myToolbar);

		// getSupportActionBar().setHomeButtonEnabled(true);

		// Habilitar un icono en el toolbar
		getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);


		// getSupportActionBar().setDisplayShowHomeEnabled(true);
		// getSupportActionBar().setIcon(R.mipmap.ic_launcher);
		drawerLayout = findViewById(R.id.drawer_layout);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		boolean resultado;

		switch (item.getItemId()) {
			case android.R.id.home:
				resultado = true;
				drawerLayout.openDrawer(GravityCompat.START);
				break;
			default:
				resultado = super.onOptionsItemSelected(item);
				break;
		}
		return resultado;
	}
}
