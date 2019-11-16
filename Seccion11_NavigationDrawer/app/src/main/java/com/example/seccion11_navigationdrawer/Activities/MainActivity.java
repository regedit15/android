package com.example.seccion11_navigationdrawer.Activities;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.seccion11_navigationdrawer.Fragments.AlertFragment;
import com.example.seccion11_navigationdrawer.Fragments.EmailFragment;
import com.example.seccion11_navigationdrawer.Fragments.InfoFragment;
import com.example.seccion11_navigationdrawer.R;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {

	DrawerLayout drawerLayout;
	NavigationView navigationView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		Toolbar myToolbar = findViewById(R.id.toolbar);
		setSupportActionBar(myToolbar);

		// Habilitar un icono en el toolbar
		getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);


		drawerLayout = findViewById(R.id.drawer_layout);

		drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
			@Override
			public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

			}

			@Override
			public void onDrawerOpened(@NonNull View drawerView) {
				Toast.makeText(MainActivity.this, "Open", Toast.LENGTH_LONG).show();
			}

			@Override
			public void onDrawerClosed(@NonNull View drawerView) {
				Toast.makeText(MainActivity.this, "Close", Toast.LENGTH_LONG).show();
			}

			@Override
			public void onDrawerStateChanged(int newState) {

			}
		});


		navigationView = findViewById(R.id.navigation_view);

		navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
			@Override
			public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
				boolean transaction = false;
				Fragment fragment = null;

				switch (menuItem.getItemId()) {
					case R.id.it_email:
						fragment = new EmailFragment();
						transaction = true;
						break;
					case R.id.it_information:
						fragment = new InfoFragment();
						transaction = true;
						break;
					case R.id.it_alerts:
						fragment = new AlertFragment();
						transaction = true;
						break;
				}

				if (transaction) {

					cambiarFragment(fragment, menuItem);
					// Escondemos el menu lateral
					drawerLayout.closeDrawer(GravityCompat.START);
				}
				return true;
			}
		});


		cambiarFragment(new EmailFragment(), navigationView.getMenu().getItem(0));
	}

	private void cambiarFragment(Fragment fragment, MenuItem menuItem) {
		//cambiamos de fragment
		getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).commit();

		//para que se muestre seleccionado
		menuItem.setChecked(true);

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
