package martin.botoneraforgottera.Fragments;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
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
					fileAudio = new File(filePath, "audiocopia.mp3");

					try {
						FileUtils.copyInputStreamToFile(inputStream, fileAudio);
					} catch (IOException e) {
						e.printStackTrace();
					}


					Intent shareIntent = new Intent(Intent.ACTION_SEND);

					shareIntent.setType("audio/mp3");
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


	// @Override
	// protected void onDestroy() {
	// 	super.onDestroy();
	// 	if (file.exists()) {
	// 		file.delete();
	// 	}
	// }

	@Override
	public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (requestCode == CODIGO_SHARE_OK && fileAudio != null && fileAudio.exists()) {
			fileAudio.delete();
		}
	}

}
