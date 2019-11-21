package martin.botoneraforgottera.Fragments;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.File;
import java.util.List;

import androidx.annotation.Nullable;
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
				compartirAudoooo(audio.getId());
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
		if (requestCode == audioService.CODIGO_SHARE_OK) {
			eliminarFileSiExiste(fileAudio);
		}
	}
	// ----------------------------------------------------
}
