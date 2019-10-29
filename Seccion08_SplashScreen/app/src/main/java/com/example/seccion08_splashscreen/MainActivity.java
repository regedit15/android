package com.example.seccion08_splashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;

public class MainActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	// Menu de los tres puntitos (arriba a la derecha)
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(@NonNull MenuItem item) {

		boolean resultado = false;

		switch (item.getItemId()) {
			case R.id.menuSalirYBorrar:
				sharedPreferenceService.borraTodo();
			case R.id.menuSalir:

				Intent intent = new Intent(this, LoginActivity.class);

				//esto es para que una vez logueado, si presiona al flecha para volver atras no vuelva al login, ya que ya se encuentra logueado.
				// Entonces esto es como que borra el recorrido que va haciendo
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
				startActivity(intent);

				resultado = true;
				break;
			default:
				super.onOptionsItemSelected(item);
				break;
		}
		return resultado;
	}
	//	-----------------------
}
