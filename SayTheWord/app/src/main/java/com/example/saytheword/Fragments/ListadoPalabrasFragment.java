package com.example.saytheword.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.saytheword.Activities.MainActivity;
import com.example.saytheword.Adapters.MyAdapter;
import com.example.saytheword.R;
import com.example.saytheword.Services.UtilService;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static com.example.saytheword.Services.UtilService.TIPO_LISTADO_INGLES_ESPANIOL;

public class ListadoPalabrasFragment extends Fragment {

	private RecyclerView recyclerView;
	private MyAdapter adapter;
	private RecyclerView.LayoutManager layoutManager;
	private UtilService utilService = new UtilService();

	public ListadoPalabrasFragment() {
		setHasOptionsMenu(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_listado_palabras, container, false);

		recyclerView = view.findViewById(R.id.recyclerView);
		layoutManager = new LinearLayoutManager(getContext());
		adapter = new MyAdapter(utilService.palabras, R.layout.recycler_view_item, TIPO_LISTADO_INGLES_ESPANIOL);

		recyclerView.setLayoutManager(layoutManager);
		recyclerView.setAdapter(adapter);
		// si sabemos que este layout no va a ser mas grande, como por ejemplo, el nombre no va a ser muy grande, etc.
		// Seteando esta propiedad en true mejora la performance
		// recyclerView.setHasFixedSize(true);

		// Le seteamos una animacion, en este caso, la que viene por defecto. Pero se puede crear una personalizada
		recyclerView.setItemAnimator(new DefaultItemAnimator());

		setearCantidadDeAudios();
		return view;
	}

	private void setearCantidadDeAudios() {
		// Agrego al titulo la cantidad de audios
		((MainActivity) getActivity()).getSupportActionBar().setTitle(new StringBuilder(((MainActivity) getActivity()).navigationView.getMenu().getItem(0).getTitle().toString()).append(" (").append(adapter.getLista().size()).append(")").toString());
	}

	//----------- Option Menu
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		inflater.inflate(R.menu.action_bar_menu_listado_palabras, menu);
		super.onCreateOptionsMenu(menu, inflater);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		boolean resultado;

		switch (item.getItemId()) {
			case R.id.item_reset:
				adapter.ocultarTodos();
				resultado = true;
				break;
			case R.id.item_espaniolIngles:
				adapter.cambiarAEspaniolIngles();
				resultado = true;
				break;
			case R.id.item_inglesEspañol:
				adapter.cambiarAInglesEspaniol();
				resultado = true;
				break;
			default:
				resultado = super.onOptionsItemSelected(item);
				break;
		}

		return resultado;
	}
	//-------------------------------------------------

}
