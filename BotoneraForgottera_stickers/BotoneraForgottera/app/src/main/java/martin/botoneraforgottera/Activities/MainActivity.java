package martin.botoneraforgottera.Activities;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import martin.botoneraforgottera.Fragments.AudiosFragment;
import martin.botoneraforgottera.Fragments.GifFragment;
import martin.botoneraforgottera.Fragments.StickersCargandoFragment;
import martin.botoneraforgottera.Fragments.StickersListadoFragment;
import martin.botoneraforgottera.Fragments.StickersListadoPaquetesFragment;
import martin.botoneraforgottera.Interfaces.StickerListener;
import martin.botoneraforgottera.R;
import martin.botoneraforgottera.Services.RealmService;
import martin.botoneraforgottera.Sticker.StickerPack;

public class MainActivity extends AppCompatActivity implements StickerListener {

	private int PERMISO_WRITE_OK = 1;
	private DrawerLayout drawerLayout;
	private NavigationView navigationView;
	public RealmService realmService = new RealmService();

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
		// Intent intent = new Intent();


		// getPackageName();
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
					case R.id.it_audios:
						fragment = new AudiosFragment();
						transaction = true;
						break;
					case R.id.it_gif:
						fragment = new GifFragment();
						transaction = true;
						break;
					case R.id.it_stickers:
						fragment = new StickersCargandoFragment();
						transaction = true;

						// startActivity(new Intent(MainActivity.this, EntryActivity.class));
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


		cambiarFragment(new AudiosFragment(), navigationView.getMenu().getItem(0));


		// navigationView.getMenu().getItem(1).setIcon(R.drawable.ic_iconfinder_word);


		//	 ---------------------- Se piden permisos
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			// pregunta al usuario los permisos
			ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISO_WRITE_OK);
		}
		// ------------------------------------------------


		realmService.setearConfiguracion(getApplicationContext());
		toString();
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


	//Nota sobre los stickers: cada stickers debe estar en formato .webp y debe tener 512x512 pixeles
	// y pesar menos de 100 kb
	// La imagen del icono del paquete debe tener 96x96 pixeles y pesar menos de 50 kb

	@Override
	public void listarStickers(StickerPack stickerPack) {
		Fragment fragment = new StickersListadoFragment(stickerPack);
		getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).commit();
	}

	@Override
	public void listarPaquetes(ArrayList<StickerPack> stickerPackList) {
		Fragment fragment = new StickersListadoPaquetesFragment(stickerPackList);
		getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).commit();


	}
}
