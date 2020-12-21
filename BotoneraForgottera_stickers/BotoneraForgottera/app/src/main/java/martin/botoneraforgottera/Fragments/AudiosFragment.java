package martin.botoneraforgottera.Fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.realm.RealmResults;
import martin.botoneraforgottera.Activities.MainActivity;
import martin.botoneraforgottera.Adapters.AudioAdapter;
import martin.botoneraforgottera.Interfaces.OnPlayClickListener;
import martin.botoneraforgottera.Models.Audio;
import martin.botoneraforgottera.R;

public class AudiosFragment extends BaseFragment {

	public static final int TIPO_DEFAULT = 1;
	public static final int TIPO_FAVORITO = 2;
	public static final int TIPO_TAG = 3;
	private RecyclerView recyclerView;
	private AudioAdapter audioAdapter;
	private RecyclerView.LayoutManager layoutManagerAudios;
	private int tipoFragment;
	private String tag;

	private List<String> tags = utilService.getTags();
	private List<String> tagsSeleccionadosPopup = new ArrayList();
	private List<String> tagsSeleccionados = new ArrayList();

	public AudiosFragment(int tipoFragment, String tag) {
		this.tipoFragment = tipoFragment;
		this.tag = tag;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_audios, container, false);

		RealmResults<Audio> realmResultsAudios = null;

		switch (tipoFragment) {
			case TIPO_DEFAULT:
				if (SI.equals(getsharedPreferenceService().getString(AUDIOS_GUARDADOS))) {
					realmResultsAudios = realmService.getAudios();
				} else {
					realmService.insertarAudios(utilService.getAudios());
					realmResultsAudios = realmService.getAudios();
					getsharedPreferenceService().guardarStringYCommitear(AUDIOS_GUARDADOS, SI);
				}
				break;
			case TIPO_FAVORITO:
				realmResultsAudios = realmService.getAudiosFavoritos();
				break;
			case TIPO_TAG:
				break;
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
				compartirAudio(audio.getIdAudio());
			}
		});

		recyclerView.setAdapter(audioAdapter);

		view.findViewById(R.id.btBuscar).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				busqueda(view);
			}
		});

		view.findViewById(R.id.btTags).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Dialog dialog;

				AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
				builder.setTitle("Filtrar por Tags : ");

				boolean[] checkedItems = new boolean[tags.size()];
				List<String> tagsSeleccionadosPopup = new ArrayList<>(tagsSeleccionados);

				for (int i = 0; i < tagsSeleccionados.size(); i++) {
					checkedItems[tags.indexOf(tagsSeleccionados.get(i))] = true;
				}

				builder.setMultiChoiceItems(tags.toArray(new String[0]), checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int selectedItemId, boolean isSelected) {
						if (isSelected) {
							tagsSeleccionadosPopup.add(tags.get(selectedItemId));
						} else {
							tagsSeleccionadosPopup.remove(tags.get(selectedItemId));
						}
					}
				}).setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int id) {
						tagsSeleccionados = new ArrayList<>(tagsSeleccionadosPopup);
						busqueda(view);
					}
				}).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int id) {
					}
				});
				dialog = builder.create();
				dialog.show();
			}
		});

		setearCantidadDeAudios();

		return view;
	}

	private void setearCantidadDeAudios() {
		// Agrego al titulo la cantidad de audios
		((MainActivity) getActivity()).getSupportActionBar().setTitle(new StringBuilder(((MainActivity) getActivity()).navigationView.getMenu().getItem(0).getTitle().toString()).append(" (").append(audioAdapter.getLista().size()).append(")").toString());
	}

	private void busqueda(View view) {
		if (tagsSeleccionados.isEmpty()) {
			audioAdapter.setLista(realmService.filtrarAudiosPorTitulo(((EditText) view.findViewById(R.id.etBusqueda)).getText().toString()));
			audioAdapter.notifyDataSetChanged();
			setearCantidadDeAudios();
		} else {
			buscarPorNombreYTags(view);
		}
	}

	private void buscarPorNombreYTags(View view) {
		audioAdapter.setLista(realmService.filtrarAudiosPorTituloYTags(((EditText) view.findViewById(R.id.etBusqueda)).getText().toString(), tagsSeleccionados));
		audioAdapter.notifyDataSetChanged();
		setearCantidadDeAudios();
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
