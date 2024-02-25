package martin.botoneraforgottera.Activities;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import martin.botoneraforgottera.Fragments.AudiosFragment;
import martin.botoneraforgottera.Fragments.GifFragment;
import martin.botoneraforgottera.Fragments.StickersCargandoFragment;
import martin.botoneraforgottera.Fragments.StickersListadoFragment;
import martin.botoneraforgottera.Fragments.StickersListadoPaquetesFragment;
import martin.botoneraforgottera.Interfaces.StickerListener;
import martin.botoneraforgottera.R;
import martin.botoneraforgottera.Services.RealmService;
import martin.botoneraforgottera.Services.UtilService;
import martin.botoneraforgottera.Sticker.StickerPack;

public class MainActivity extends AppCompatActivity implements StickerListener {

	// Nota sobre los stickers: cada stickers debe estar en formato .webp y debe tener 512x512 pixeles
	// y pesar menos de 100 kb
	// La imagen del icono del paquete debe tener 96x96 pixeles y pesar menos de 50 kb
	//   sasas 22323

	private final String DATOS_GUARDADOS = "DATOS_GUARDADOS";
	private final String APP_VERSION = "VERSION";
	private final int PERMISO_WRITE_OK = 1;
	private DrawerLayout drawerLayout;
	public NavigationView navigationView;
	public RealmService realmService = new RealmService();
	public UtilService utilService = new UtilService();

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
		navigationView = findViewById(R.id.navigation_view);

		navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
			@Override
			public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
				boolean transaction = false;
				Fragment fragment = null;

				if (menuItem.getItemId() == R.id.it_audios) {
					fragment = new AudiosFragment(AudiosFragment.TIPO_DEFAULT);
					transaction = true;
				} else if (menuItem.getItemId() == R.id.it_favoritos) {
					fragment = new AudiosFragment(AudiosFragment.TIPO_FAVORITO);
					transaction = true;
				} else if (menuItem.getItemId() == R.id.it_gif) {
					fragment = new GifFragment();
					transaction = true;
				} else if (menuItem.getItemId() == R.id.it_stickers) {
					fragment = new StickersCargandoFragment();
					transaction = true;
				}

				if (transaction) {
					cambiarFragment(fragment, menuItem);
					// Escondemos el menu lateral
					drawerLayout.closeDrawer(GravityCompat.START);
				}
				return true;
			}
		});

		cambiarFragment(new AudiosFragment(AudiosFragment.TIPO_DEFAULT), navigationView.getMenu().getItem(0));

		//	 ---------------------- Se piden permisos
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			// pregunta al usuario los permisos
			ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISO_WRITE_OK);
		}
		// ------------------------------------------------

		realmService.setearConfiguracion(getApplicationContext());


		//	 ---------------------- Nos fijamos si tiene los audios gardados y actualizados, sino los insertamos
		utilService.setsharedPreferenceService(this);
		if (!utilService.getPreferenceService().getBoolean(DATOS_GUARDADOS)) {
			realmService.eliminarTodo();
			realmService.insertarAudios(utilService.getAudios());
			utilService.getPreferenceService().guardarBooleanYCommitear(DATOS_GUARDADOS, true);
		}

		String appVersion = utilService.getVersionName(this);
		if (!appVersion.equals(utilService.getPreferenceService().getString(APP_VERSION)) || (utilService.getAudios().size() != realmService.getAudios().size())) {
			utilService.getPreferenceService().guardarStringYCommitear(APP_VERSION, appVersion);
			utilService.insertarDatosSinModificarFavoritos();
		}
		// ------------------------------------------------
	}

	private void cambiarFragment(Fragment fragment, MenuItem menuItem) {
		// cambiamos de fragment
		getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).commit();

		// para que se muestre seleccionado
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
