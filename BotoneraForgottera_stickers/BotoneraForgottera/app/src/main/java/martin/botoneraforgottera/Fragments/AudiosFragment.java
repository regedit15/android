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

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import martin.botoneraforgottera.Activities.MainActivity;
import martin.botoneraforgottera.Adapters.AudioAdapter;
import martin.botoneraforgottera.Interfaces.OnPlayClickListener;
import martin.botoneraforgottera.Models.Audio;
import martin.botoneraforgottera.Models.Tag;
import martin.botoneraforgottera.R;

public class AudiosFragment extends BaseFragment {

    public static final int TIPO_DEFAULT = 1;
    public static final int TIPO_FAVORITO = 2;
    private RecyclerView recyclerView;
    private AudioAdapter audioAdapter;
    private RecyclerView.LayoutManager layoutManagerAudios;
    private final int tipoFragment;

    private List<String> tags = utilService.getTags();
    private List<String> tagsSeleccionadosPopup = new ArrayList();
    private List<String> tagsSeleccionados = new ArrayList();

    public AudiosFragment(int tipoFragment) {
        this.tipoFragment = tipoFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_audios, container, false);
        List<Audio> realmResultsAudios = null;

        switch (tipoFragment) {
            case TIPO_DEFAULT:
                realmResultsAudios = realmService.getAudios();
                break;
            case TIPO_FAVORITO:
                realmResultsAudios = realmService.getAudiosFavoritos();
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

            @Override
            public void onTagClickListener(Tag tag) {
                tagsSeleccionados = Arrays.asList(tag.getNombre());
                buscarPorTag(tag.getNombre());
            }
        });

        recyclerView.setAdapter(audioAdapter);

        view.findViewById(R.id.btBuscar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                busqueda(view);
            }
        });

        view.findViewById(R.id.btLimpiart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiarBusqueda(view);
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
        String titulo = ((EditText) view.findViewById(R.id.etBusqueda)).getText().toString();

        if (tagsSeleccionados.isEmpty()) {
            buscarPorTitulo(titulo);
        } else {
            buscarPorTituloYTags(titulo);
        }
    }

    private void limpiarBusqueda(View view) {
        tagsSeleccionados = new ArrayList();
        ((EditText) view.findViewById(R.id.etBusqueda)).setText("");

        List<Audio> lista = null;

        switch (tipoFragment) {
            case TIPO_DEFAULT:
                lista = realmService.getAudios();
                break;
            case TIPO_FAVORITO:
                lista = realmService.getAudiosFavoritos();
                break;
        }

        setListaYRefrezcar(lista);
    }


    private void buscarPorTag(String tag) {
        setListaYRefrezcar(realmService.filtrarAudiosPorTags(tag, tipoFragment == TIPO_FAVORITO));
    }

    private void buscarPorTitulo(String titulo) {
        setListaYRefrezcar(realmService.filtrarAudiosPorTitulo(titulo, tipoFragment == TIPO_FAVORITO));
    }

    private void buscarPorTituloYTags(String titulo) {
        setListaYRefrezcar(realmService.filtrarAudiosPorTituloYTags(titulo, tagsSeleccionados, tipoFragment == TIPO_FAVORITO));
    }

    private void setListaYRefrezcar(List<Audio> lista) {
        audioAdapter.setLista(lista);
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
