package martin.botoneraforgottera.Activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import java.io.File;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.FileProvider;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import martin.botoneraforgottera.Fragments.AudiosFragment;
import martin.botoneraforgottera.Fragments.GifFragment;
import martin.botoneraforgottera.Fragments.StickersFragment;
import martin.botoneraforgottera.R;

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
						fragment = new StickersFragment();
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


		cambiarFragment(new AudiosFragment(), navigationView.getMenu().getItem(0));


		// navigationView.getMenu().getItem(1).setIcon(R.drawable.ic_iconfinder_word);

		//-----------------------------------------------------

		StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
		StrictMode.setVmPolicy(builder.build());

		Intent shareIntent = new Intent(Intent.ACTION_SEND);
		shareIntent.setType("application/pdf");
		shareIntent.setAction(Intent.ACTION_SEND);

		File audio = new File("android.resource://martin.botoneraforgottera/raw/" + "pdfprueba" + ".pdf");

		Uri uri = FileProvider.getUriForFile(this, getPackageName() + ".provider", audio);

		// shareIntent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(audio));
		shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
		shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
		shareIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(shareIntent);
	}


	// ------------------- Lo mas potable
	// Uri uri = Uri.parse("android.resource://martin.botoneraforgottera/raw/" + "audio" + ".mp3");
	//
	// Intent share = new Intent(Intent.ACTION_SEND);
	// 	share.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
	// 	share.setType("audio/mp3");
	// 	share.putExtra(Intent.EXTRA_STREAM, uri);
	//
	// startActivity(Intent.createChooser(share, "Send song"));
	//
	// 	-----------
	//
	// File audio = new File("android.resource://martin.botoneraforgottera/raw/" + "audio" + ".mp3");
	//
	// Intent share = new Intent(Intent.ACTION_SEND).setType("audio/*");
	// 	share.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(audio));
	// startActivity(Intent.createChooser(share, "Share song"));
	//-----------------------------------------------------------------------

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
