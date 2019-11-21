package martin.botoneraforgottera.Fragments;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import martin.botoneraforgottera.Adapters.AudioAdapter;
import martin.botoneraforgottera.Exceptions.PermisoException;
import martin.botoneraforgottera.Interfaces.OnPlayClickListener;
import martin.botoneraforgottera.Models.Audio;
import martin.botoneraforgottera.R;
import martin.botoneraforgottera.Services.UtilService;

public class AudiosFragment extends Fragment {

	private int CODIGO_OK = 1515;
	private RecyclerView recyclerView;
	private AudioAdapter audioAdapter;
	private List<Audio> audios;
	private RecyclerView.LayoutManager mLayoutManager;
	private UtilService utilService = new UtilService();
	// private ApplicationService applicationService = new ApplicationService();

	public AudiosFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_audios, container, false);
		audios = utilService.getAudios();

		// ciudades = realm.where(Ciudad.class).findAll();
		// audios.addChangeListener(this);


		recyclerView = view.findViewById(R.id.rvListadoCiudades);
		recyclerView.setHasFixedSize(true);
		recyclerView.setItemAnimator(new DefaultItemAnimator());
		// mLayoutManager = new LinearLayoutManager(this);
		mLayoutManager = new LinearLayoutManager(getContext());
		recyclerView.setLayoutManager(mLayoutManager);


		// floatingActionButton = view.findViewById(R.id.btAgregarCiudad);

		// recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
		// 	@Override
		// 	public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
		// 		if (dy > 0) {
		// 			floatingActionButton.hide();
		// 		} else if (dy < 0) {
		// 			floatingActionButton.show();
		// 		}
		// 	}
		// });


		// audioAdapter = new AudioAdapter(audios, R.layout.item_audio, new AudioAdapter.OnItemClickListener() {
		// 	@Override
		// 	public void onItemClick(Ciudad ciudad, int position) {
		// 		Intent intent = new Intent(MainActivity.this, CrearCiudad.class);
		// 		intent.putExtra("idCiudad", ciudad.getId());
		// 		startActivity(intent);
		// 	}
		// }, new CiudadAdapter.OnButtonClickListener() {
		// 	@Override
		// 	public void onButtonClick(Ciudad ciudad, int position) {
		// 		mostrarPopupEliminarCiudad("Eliminar ciudad", "Esta seguro que desea eliminar la ciudad " + ciudad.getNombre() + "?", position);
		// 	}
		// });
		audioAdapter = new AudioAdapter(audios, R.layout.item_audio, new OnPlayClickListener() {
			@Override
			public void onPlayClickListener(Audio audio) {
				MediaPlayer mediaPlayer = MediaPlayer.create(getContext(), audio.getId());
				mediaPlayer.start();
			}

			@Override
			public void onShareClickListener(Audio audio) {

				try {
					validarPermisos();

					// Directorio del telefono, el de mas arriba, el de "Este equipo\moto g(7)\Almacenamiento interno compartido"
					File filePath = Environment.getExternalStorageDirectory();
					// Directorio de Downloads: "Este equipo\moto g(7)\Almacenamiento interno compartido\Download"
					// File filePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

					InputStream inputStream = getResources().openRawResource(R.raw.audio);
					File file = new File(filePath, "audiocopia.mp3");

					try {
						FileUtils.copyInputStreamToFile(inputStream, file);
					} catch (IOException e) {
						e.printStackTrace();
					}


					Intent shareIntent = new Intent(Intent.ACTION_SEND);

					// Este es el mismo nombre que esta en el Manifest
					String nombreProvider = getContext().getApplicationContext().getPackageName() + ".myfileprovider";
					// String nombreProvider = getActivity().getApplicationContext().getPackageName() + ".myfileprovider";

					Uri photoURI = FileProvider.getUriForFile(getContext(), nombreProvider, file);

					shareIntent.setType("audio/mp3");
					shareIntent.putExtra(Intent.EXTRA_STREAM, photoURI);
					shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
					// startActivity(Intent.createChooser(shareIntent, "Share images..."));

					startActivityForResult(Intent.createChooser(shareIntent, "Share images..."), CODIGO_OK);

				} catch (Exception e) {
					e.printStackTrace();
					irAConfiguracionDeLaApp();
				}
			}
		});

		recyclerView.setAdapter(audioAdapter);
		// audios.addChangeListener(this);
		return view;
	}

	private void validarPermisos() throws PermisoException {
		if (!checkPermisos(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
			throw new PermisoException();
		}
	}

	private boolean checkPermisos(String permission) {
		return getContext().checkCallingOrSelfPermission(permission) == PackageManager.PERMISSION_GRANTED;
	}

	private void irAConfiguracionDeLaApp() {
		Toast.makeText(getContext(), "No aceptaste los permisos", Toast.LENGTH_LONG).show();

		Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
		intent.addCategory(Intent.CATEGORY_DEFAULT);
		intent.setData(Uri.parse("package:" + getContext().getApplicationContext().getPackageName()));
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
		intent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
		startActivity(intent);
	}

}
