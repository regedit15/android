package com.example.saytheword.Activities;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.saytheword.Fragments.JuegoFragment;
import com.example.saytheword.Fragments.ListadoPalabrasFragment;
import com.example.saytheword.R;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {

	// private RecyclerView recyclerView;
	// private MyAdapter adapter;
	// private RecyclerView.LayoutManager layoutManager;
	// private List<Palabra> palabras;
	// private UtilService utilService = new UtilService();
	//
	// private boolean showingBack = false;
	//
	// @Override
	// protected void onCreate(Bundle savedInstanceState) {
	// 	super.onCreate(savedInstanceState);
	// 	setContentView(R.layout.activity_main);
	//
	// 	// if (savedInstanceState == null) {
	// 	// 	getSupportFragmentManager().beginTransaction().add(R.id.contenedor, new CardFront()).commit();
	// 	// }
	//
	// 	palabras = utilService.getPalabras();
	//
	// 	recyclerView = findViewById(R.id.recyclerView);
	//
	//
	// 	// ----------- Tipos de Layout
	// 	// Layout lineal
	// 	layoutManager = new LinearLayoutManager(this);
	// 	// Layout de grilla
	// 	// layoutManager = new GridLayoutManager(this, 2);
	// 	// Esto es como un grid donde tienen diferentes tamaños, como cuando ponene imagenes como en
	// 	// mozaicos que unas son mas grandes que otras, medias desordenadas
	// 	// layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
	// 	// -----------------------------------------------
	//
	//
	// 	// Enviamos el parametro this para tener tanto el activity como el contexto
	// 	// adapter = new MyAdapter(palabras, R.layout.recycler_view_item, this, new MyAdapter.OnItemClickListener() {
	// 	// 	@Override
	// 	// 	public void onItemClick(Palabra palabra, int position) {
	// 	// 		// Toast.makeText(MainActivity.this, "Tocada: " + palabras.get(position).getPalabraEsp(), Toast.LENGTH_SHORT).show();
	// 	// 	}
	// 	// });
	// 	adapter = new MyAdapter(palabras, R.layout.recycler_view_item, this);
	//
	//
	// 	recyclerView.setLayoutManager(layoutManager);
	// 	recyclerView.setAdapter(adapter);
	// 	// si sabemos que este layout no va a ser mas grande, como por ejemplo, el nombre no va a ser muy grande, etc.
	// 	// Seteando esta propiedad en true mejora la performance
	// 	recyclerView.setHasFixedSize(true);
	//
	// 	// Le seteamos una animacion, en este caso, la que viene por defecto. Pero se puede crear una personalizada
	// 	recyclerView.setItemAnimator(new DefaultItemAnimator());
	// }

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

		// drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
		// 	@Override
		// 	public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
		//
		// 	}
		//
		// 	@Override
		// 	public void onDrawerOpened(@NonNull View drawerView) {
		// 		Toast.makeText(MainActivity.this, "Open", Toast.LENGTH_LONG).show();
		// 	}
		//
		// 	@Override
		// 	public void onDrawerClosed(@NonNull View drawerView) {
		// 		Toast.makeText(MainActivity.this, "Close", Toast.LENGTH_LONG).show();
		// 	}
		//
		// 	@Override
		// 	public void onDrawerStateChanged(int newState) {
		//
		// 	}
		// });


		navigationView = findViewById(R.id.navigation_view);

		navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
			@Override
			public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
				boolean transaction = false;
				Fragment fragment = null;

				switch (menuItem.getItemId()) {
					case R.id.it_listadoPalabras:
						fragment = new ListadoPalabrasFragment();
						transaction = true;
						break;
					case R.id.it_juego:
						fragment = new JuegoFragment();
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


		cambiarFragment(new ListadoPalabrasFragment(), navigationView.getMenu().getItem(0));
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
