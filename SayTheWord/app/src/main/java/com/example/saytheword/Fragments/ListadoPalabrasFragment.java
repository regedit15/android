package com.example.saytheword.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.saytheword.Adapters.MyAdapter;
import com.example.saytheword.Models.Palabra;
import com.example.saytheword.R;
import com.example.saytheword.Services.UtilService;

import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListadoPalabrasFragment extends Fragment {

	private RecyclerView recyclerView;
	private MyAdapter adapter;
	private RecyclerView.LayoutManager layoutManager;
	private List<Palabra> palabras;
	private UtilService utilService = new UtilService();

	public ListadoPalabrasFragment() {
		palabras = utilService.getPalabras();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_listado_palabras, container, false);

		recyclerView = view.findViewById(R.id.recyclerView);


		// ----------- Tipos de Layout
		// Layout lineal
		layoutManager = new LinearLayoutManager(getContext());
		// Layout de grilla
		// layoutManager = new GridLayoutManager(this, 2);
		// Esto es como un grid donde tienen diferentes tamaños, como cuando ponene imagenes como en
		// mozaicos que unas son mas grandes que otras, medias desordenadas
		// layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
		// -----------------------------------------------


		// Enviamos el parametro this para tener tanto el activity como el contexto
		// adapter = new MyAdapter(palabras, R.layout.recycler_view_item, this, new MyAdapter.OnItemClickListener() {
		// 	@Override
		// 	public void onItemClick(Palabra palabra, int position) {
		// 		// Toast.makeText(MainActivity.this, "Tocada: " + palabras.get(position).getPalabraEsp(), Toast.LENGTH_SHORT).show();
		// 	}
		// });
		adapter = new MyAdapter(palabras, R.layout.recycler_view_item);

		recyclerView.setLayoutManager(layoutManager);
		recyclerView.setAdapter(adapter);
		// si sabemos que este layout no va a ser mas grande, como por ejemplo, el nombre no va a ser muy grande, etc.
		// Seteando esta propiedad en true mejora la performance
		recyclerView.setHasFixedSize(true);

		// Le seteamos una animacion, en este caso, la que viene por defecto. Pero se puede crear una personalizada
		recyclerView.setItemAnimator(new DefaultItemAnimator());

		return view;
	}

}
