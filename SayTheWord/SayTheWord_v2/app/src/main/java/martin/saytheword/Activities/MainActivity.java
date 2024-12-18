package martin.saytheword.Activities;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;

import martin.saytheword.Fragments.JuegoConfiguracionInicial;
import martin.saytheword.Fragments.SeleccionListadoFragment;
import martin.saytheword.R;
import martin.saytheword.Services.RealmService;
import martin.saytheword.Services.UtilService;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

	private DrawerLayout drawerLayout;
	public NavigationView navigationView;
	public RealmService realmService = new RealmService();
	protected UtilService utilService = new UtilService();

	private static final String DATOS_GUARDADOS = "DATOS_GUARDADOS";
	private static final String APP_VERSION = "VERSION";

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

				if (menuItem.getItemId() == R.id.it_listado) {
					fragment = new SeleccionListadoFragment();
					transaction = true;
				} else if (menuItem.getItemId() == R.id.it_juego) {

					fragment = new JuegoConfiguracionInicial();
					transaction = true;
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


		cambiarFragment(new SeleccionListadoFragment(), navigationView.getMenu().getItem(0));
		// cambiarFragment(new JuegoEscribirVerboIrregularFragment(3, 5, false), navigationView.getMenu().getItem(0));


		//--------------- Compruebo si esta insertados todos los datos
		utilService.setsharedPreferenceService(this);
		if (!utilService.getPreferenceService().getBoolean(DATOS_GUARDADOS)) {
			insertarDatosEnLaBD();
		}

		if (!utilService.getVersionName(this).equals(utilService.getPreferenceService().getString(APP_VERSION))) {
			utilService.getPreferenceService().guardarStringYCommitear(APP_VERSION, utilService.getVersionName(this));
			utilService.insertarDatosSinModificarPalabrasEncontradas();
		}
		//-------------------------------------------------------------------
	}

	private void insertarDatosEnLaBD() {
		realmService.insertarPalabras(utilService.getPalabrasEstaticas());
		realmService.insertarIrregularVerbs(utilService.getVerbosIrregularesEstaticos());
		utilService.getPreferenceService().guardarBooleanYCommitear(DATOS_GUARDADOS, true);
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

	@Override
	public void onInit(int status) {

	}
}
