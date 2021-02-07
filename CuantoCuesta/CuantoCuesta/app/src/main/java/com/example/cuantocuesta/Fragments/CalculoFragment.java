package com.example.cuantocuesta.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cuantocuesta.Adapters.CalculoAdapter;
import com.example.cuantocuesta.Models.Calculo;
import com.example.cuantocuesta.R;
import com.example.cuantocuesta.Services.UtilService;

import java.util.List;

public class CalculoFragment extends Fragment {


    //    public static final int TIPO_DEFAULT = 1;
//    public static final int TIPO_FAVORITO = 2;
    private RecyclerView recyclerView;
    private CalculoAdapter audioAdapter;
    private RecyclerView.LayoutManager layoutManagerCalculos;
    private UtilService utilService = new UtilService();
//    private final int tipoFragment;

//    private List<String> tags = utilService.getTags();
//    private List<String> tagsSeleccionadosPopup = new ArrayList();
//    private List<String> tagsSeleccionados = new ArrayList();

    public CalculoFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_calculo, container, false);
        List<Calculo> realmResultsAudios = utilService.getCalculos();

//        switch (tipoFragment) {
//            case TIPO_DEFAULT:
//        realmResultsAudios = realmService.getAudios();
//                realmResultsAudios = realmService.getAudios();
//                break;
//            case TIPO_FAVORITO:
//                realmResultsAudios = realmService.getAudiosFavoritos();
//                break;
//        }

        recyclerView = view.findViewById(R.id.rvListadoCalculos);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        layoutManagerCalculos = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManagerCalculos);

        audioAdapter = new CalculoAdapter(realmResultsAudios, R.layout.item_calculo);

        recyclerView.setAdapter(audioAdapter);

//        view.findViewById(R.id.btBuscar).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                busqueda(view);
//            }
//        });
//
//        view.findViewById(R.id.btLimpiart).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                limpiarBusqueda(view);
//            }
//        });

//        view.findViewById(R.id.btTags).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Dialog dialog;
//
//                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
//                builder.setTitle("Filtrar por Tags : ");
//
//                boolean[] checkedItems = new boolean[tags.size()];
//                List<String> tagsSeleccionadosPopup = new ArrayList<>(tagsSeleccionados);
//
//                for (int i = 0; i < tagsSeleccionados.size(); i++) {
//                    checkedItems[tags.indexOf(tagsSeleccionados.get(i))] = true;
//                }
//
//                builder.setMultiChoiceItems(tags.toArray(new String[0]), checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int selectedItemId, boolean isSelected) {
//                        if (isSelected) {
//                            tagsSeleccionadosPopup.add(tags.get(selectedItemId));
//                        } else {
//                            tagsSeleccionadosPopup.remove(tags.get(selectedItemId));
//                        }
//                    }
//                }).setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int id) {
//                        tagsSeleccionados = new ArrayList<>(tagsSeleccionadosPopup);
//                        busqueda(view);
//                    }
//                }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int id) {
//                    }
//                });
//                dialog = builder.create();
//                dialog.show();
//            }
//        });

//        setearCantidadDeAudios();

        return view;
    }

//    private void setearCantidadDeAudios() {
//        // Agrego al titulo la cantidad de audios
//        ((MainActivity) getActivity()).getSupportActionBar().setTitle(new StringBuilder(((MainActivity) getActivity()).navigationView.getMenu().getItem(0).getTitle().toString()).append(" (").append(audioAdapter.getLista().size()).append(")").toString());
//    }

//    private void busqueda(View view) {
//        String titulo = ((EditText) view.findViewById(R.id.etBusqueda)).getText().toString();
//
//        if (tagsSeleccionados.isEmpty()) {
//            buscarPorTitulo(titulo);
//        } else {
//            buscarPorTituloYTags(titulo);
//        }
//    }

//    private void limpiarBusqueda(View view) {
//        tagsSeleccionados = new ArrayList();
//        ((EditText) view.findViewById(R.id.etBusqueda)).setText("");
//
//        List<Audio> lista = null;
//
//        switch (tipoFragment) {
//            case TIPO_DEFAULT:
//                lista = realmService.getAudios();
//                break;
//            case TIPO_FAVORITO:
//                lista = realmService.getAudiosFavoritos();
//                break;
//        }
//
//        setListaYRefrezcar(lista);
//    }


//    private void buscarPorTag(String tag) {
//        setListaYRefrezcar(realmService.filtrarAudiosPorTags(tag, tipoFragment == TIPO_FAVORITO));
//    }
//
//    private void buscarPorTitulo(String titulo) {
//        setListaYRefrezcar(realmService.filtrarAudiosPorTitulo(titulo, tipoFragment == TIPO_FAVORITO));
//    }
//
//    private void buscarPorTituloYTags(String titulo) {
//        setListaYRefrezcar(realmService.filtrarAudiosPorTituloYTags(titulo, tagsSeleccionados, tipoFragment == TIPO_FAVORITO));
//    }
//
//    private void setListaYRefrezcar(List<Audio> lista) {
//        audioAdapter.setLista(lista);
//        audioAdapter.notifyDataSetChanged();
//        setearCantidadDeAudios();
//    }

    // -------------- Eliminar el audio al despues de compartir o al cerrar la app
    @Override
    public void onDestroy() {
        super.onDestroy();
//        audioService.eliminarFileSiExiste(fileAudio);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        audioService.eliminarFileSiExisteResult(requestCode, fileAudio);
    }
    // ----------------------------------------------------
}
