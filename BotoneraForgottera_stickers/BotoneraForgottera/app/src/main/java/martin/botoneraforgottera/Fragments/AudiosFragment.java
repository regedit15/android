package martin.botoneraforgottera.Fragments;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.realm.RealmResults;
import martin.botoneraforgottera.Adapters.AudioAdapter;
import martin.botoneraforgottera.Interfaces.OnPlayClickListener;
import martin.botoneraforgottera.Models.Audio;
import martin.botoneraforgottera.R;

public class AudiosFragment extends BaseFragment {

	private RecyclerView recyclerView;
	private AudioAdapter audioAdapter;
	private RecyclerView.LayoutManager layoutManagerAudios;

	public AudiosFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_audios, container, false);

		RealmResults<Audio> realmResultsAudios;

		if (getsharedPreferenceService().getString(AUDIOS_GUARDADOS) == "SI") {
			realmResultsAudios = realmService.getAudios();
		} else {
			List<Audio> audios = utilService.getAudios();

			String cantidadAudioooos = "" + audios.size();

			realmService.insertarAudios(audios);
			realmResultsAudios = realmService.getAudios();
			getsharedPreferenceService().guardarString(AUDIOS_GUARDADOS, "SI");
		}

		recyclerView = view.findViewById(R.id.rvListadoAudios);
		recyclerView.setHasFixedSize(true);
		recyclerView.setItemAnimator(new DefaultItemAnimator());
		layoutManagerAudios = new LinearLayoutManager(getContext());
		recyclerView.setLayoutManager(layoutManagerAudios);

		audioAdapter = new AudioAdapter(realmResultsAudios, R.layout.item_audio, new OnPlayClickListener() {
			@Override
			public void onPlayClickListener(Audio audio) {
				MediaPlayer mediaPlayer = MediaPlayer.create(getContext(), audio.getIdAudio());
				mediaPlayer.start();
			}

			@Override
			public void onShareClickListener(Audio audio) {
				compartirAudoooo(audio.getIdAudio());
			}
		});

		recyclerView.setAdapter(audioAdapter);

		view.findViewById(R.id.btBuscar).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				audioAdapter.setLista(realmService.filtrarAudios(((EditText) view.findViewById(R.id.etBusqueda)).getText().toString()));
				audioAdapter.notifyDataSetChanged();
			}
		});

		return view;
	}

	// -------------- Eliminar el audio al despues de compartir o al cerrar la app
	@Override
	public void onDestroy() {
		super.onDestroy();
		audioService.eliminarFileSiExiste(fileAudio);
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		audioService.eliminarFileSiExisteResult(requestCode, fileAudio);
	}

	// ----------------------------------------------------

}
