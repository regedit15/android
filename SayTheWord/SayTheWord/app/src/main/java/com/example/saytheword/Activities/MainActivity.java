package com.example.saytheword.Activities;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.saytheword.Fragments.JuegoConfiguracionInicial;
import com.example.saytheword.Fragments.JuegoEscribirVerboIrregularFragment;
import com.example.saytheword.Fragments.SeleccionListadoFragment;
import com.example.saytheword.R;
import com.example.saytheword.Services.RealmService;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {

	private DrawerLayout drawerLayout;
	public NavigationView navigationView;
	public RealmService realmService = new RealmService();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		realmService.setearConfiguracion(getApplicationContext());

		Toolbar myToolbar = findViewById(R.id.toolbar);
		setSupportActionBar(myToolbar);

		// Habilitar un icono en el toolbar
		getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);


		drawerLayout = findViewById(R.id.drawer_layout);

		navigationView = findViewById(R.id.navigation_view);

		navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
			@Override
			public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
				boolean transaction = false;
				Fragment fragment = null;

				switch (menuItem.getItemId()) {
					case R.id.it_listado:
						fragment = new SeleccionListadoFragment();
						transaction = true;
						break;
					case R.id.it_juego:
						fragment = new JuegoConfiguracionInicial();
						transaction = true;
						break;
				}

				if (transaction) {

					// cambiarFragment(fragment, menuItem);
					cambiarFragment(fragment, menuItem);
					// Escondemos el menu lateral
					drawerLayout.closeDrawer(GravityCompat.START);
				}
				return true;
			}
		});


		// cambiarFragment(new SeleccionListadoFragment(), navigationView.getMenu().getItem(0));
		cambiarFragment(new JuegoEscribirVerboIrregularFragment(3, 5, false), navigationView.getMenu().getItem(0));
		// cambiarFragment(new JuegoConfiguracionInicial(), navigationView.getMenu().getItem(1).getSubMenu().getItem(4));
	}

	private void cambiarFragment(Fragment fragment, MenuItem menuItem) {
		//cambiamos de fragment
		getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).addToBackStack(null).commit();

		// Esto es para arreglar un bug que queda checkeado
		// navigationView.getMenu().getItem(0).getSubMenu().getItem(0).setChecked(false);
		// navigationView.getMenu().getItem(0).setChecked(false);

		//para que se muestre seleccionado
		menuItem.setChecked(true);

		// menu.findItem(R.id.item_1).setChecked(true);

		// Seteamos que el titulo de la barra sea igual que el item
		getSupportActionBar().setTitle(menuItem.getTitle());
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
