package martin.botoneraforgottera.Fragments;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import martin.botoneraforgottera.Adapters.AudioAdapter;
import martin.botoneraforgottera.Interfaces.OnPlayClickListener;
import martin.botoneraforgottera.Models.Audio;
import martin.botoneraforgottera.R;

public class AudiosFragment extends BaseFragment {

	public static final String AUDIO_PARA_COMPARTIR = "audioBotoneraForgottera.mp3";
	private RecyclerView recyclerView;
	private AudioAdapter audioAdapter;
	private List<Audio> audios;
	private RecyclerView.LayoutManager mLayoutManager;
	private File fileAudio;

	public AudiosFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_audios, container, false);
		audios = utilService.getAudios();
		recyclerView = view.findViewById(R.id.rvListadoCiudades);
		recyclerView.setHasFixedSize(true);
		recyclerView.setItemAnimator(new DefaultItemAnimator());
		mLayoutManager = new LinearLayoutManager(getContext());
		recyclerView.setLayoutManager(mLayoutManager);


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
					fileAudio = new File(filePath, AUDIO_PARA_COMPARTIR);

					utilService.copiarArchivo(inputStream, fileAudio);

					Intent shareIntent = new Intent(Intent.ACTION_SEND);

					shareIntent.setType(utilService.TYPE_AUDIO_MP3);
					shareIntent.putExtra(Intent.EXTRA_STREAM, FileProvider.getUriForFile(getContext(), getNombreProvider(), fileAudio));
					shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
					startActivityForResult(Intent.createChooser(shareIntent, "Share images..."), CODIGO_SHARE_OK);

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

	// -------------- Eliminar el audio al despues de compartir o al cerrar la app
	@Override
	public void onDestroy() {
		super.onDestroy();
		eliminarFileSiExiste(fileAudio);
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == CODIGO_SHARE_OK) {
			eliminarFileSiExiste(fileAudio);
		}
	}
	// ----------------------------------------------------
}
