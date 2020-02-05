package martin.ingles.saytheword.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import martin.ingles.saytheword.Activities.MainActivity;
import martin.ingles.saytheword.Adapters.PalabraAdapter;
import martin.ingles.saytheword.Adapters.VerboIrregularAdapter;
import martin.ingles.saytheword.Models.Palabra;
import martin.ingles.saytheword.Models.VerboIrregular;
import martin.ingles.saytheword.R;
import martin.ingles.saytheword.Services.UtilService;

public class ListadoFragment extends BaseFragment {

	private RecyclerView recyclerView;
	private PalabraAdapter palabraAdapter;
	private VerboIrregularAdapter verboIrregularAdapter;
	private RecyclerView.LayoutManager layoutManager;
	private String TIPO_LISTADO;
	boolean faciles;
	boolean normales;
	boolean dificiles;

	public ListadoFragment(String TIPO_LISTADO, boolean faciles, boolean normales, boolean dificiles) {
		setHasOptionsMenu(true);
		this.TIPO_LISTADO = TIPO_LISTADO;
		this.faciles = faciles;
		this.normales = normales;
		this.dificiles = dificiles;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_listado_palabras, container, false);

		recyclerView = view.findViewById(R.id.recyclerView);
		layoutManager = new LinearLayoutManager(getContext());
		recyclerView.setLayoutManager(layoutManager);

		List<Palabra> palabras;
		List<VerboIrregular> verbosIrregulares;

		switch (TIPO_LISTADO) {
			case UtilService.LISTADO_PALABRAS:
				palabras = utilService.getPalabras(faciles, normales, dificiles);
				realmService.cambiarMostrarRespuestasPalabras(palabras, false);
				palabraAdapter = new PalabraAdapter(palabras, R.layout.item_palabra, UtilService.LISTADO_TIPO_TRADUCCION_INGLES_ESPANIOL, getActivity());
				recyclerView.setAdapter(palabraAdapter);
				break;
			case UtilService.LISTADO_VERBOS_IRREGULARES:
				verbosIrregulares = utilService.getVerbosIrregulares(faciles, normales, dificiles);
				realmService.cambiarMostrarRespuestasVerbosIrregulares(verbosIrregulares, false);
				verboIrregularAdapter = new VerboIrregularAdapter(verbosIrregulares, R.layout.item_irregular_verb, UtilService.LISTADO_TIPO_TRADUCCION_INGLES_ESPANIOL, getActivity());
				recyclerView.setAdapter(verboIrregularAdapter);
				break;
		}

		// si sabemos que este layout no va a ser mas grande, como por ejemplo, el nombre no va a ser muy grande, etc.
		// Seteando esta propiedad en true mejora la performance
		// recyclerView.setHasFixedSize(true);

		// Le seteamos una animacion, en este caso, la que viene por defecto. Pero se puede crear una personalizada
		recyclerView.setItemAnimator(new DefaultItemAnimator());

		setearTitulo();
		return view;
	}

	private void setearTitulo() {

		int cantidad = 0;

		switch (TIPO_LISTADO) {
			case UtilService.LISTADO_PALABRAS:
				cantidad = palabraAdapter.getLista().size();
				break;
			case UtilService.LISTADO_VERBOS_IRREGULARES:
				cantidad = verboIrregularAdapter.getLista().size();
				break;
		}

		setearTitulo(new StringBuilder(((MainActivity) getActivity()).navigationView.getMenu().getItem(0).getTitle().toString()).append(" (").append(cantidad).append(")").toString());
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
			case R.id.item_verTodo:
				switch (TIPO_LISTADO) {
					case UtilService.LISTADO_PALABRAS:
						palabraAdapter.verTodo();
						break;
					case UtilService.LISTADO_VERBOS_IRREGULARES:
						verboIrregularAdapter.verTodo();
						break;
				}
				resultado = true;
				break;
			case R.id.item_ocultarTodo:
				switch (TIPO_LISTADO) {
					case UtilService.LISTADO_PALABRAS:
						palabraAdapter.ocultarTodo();
						break;
					case UtilService.LISTADO_VERBOS_IRREGULARES:
						verboIrregularAdapter.ocultarTodo();
						break;
				}
				resultado = true;
				break;
			case R.id.item_espaniolIngles:
				switch (TIPO_LISTADO) {
					case UtilService.LISTADO_PALABRAS:
						palabraAdapter.cambiarAEspaniolIngles();
						break;
					case UtilService.LISTADO_VERBOS_IRREGULARES:
						verboIrregularAdapter.cambiarAEspaniolIngles();
						break;
				}
				resultado = true;
				break;
			case R.id.item_inglesEspañol:
				switch (TIPO_LISTADO) {
					case UtilService.LISTADO_PALABRAS:
						palabraAdapter.cambiarAInglesEspaniol();
						break;
					case UtilService.LISTADO_VERBOS_IRREGULARES:
						verboIrregularAdapter.cambiarAInglesEspaniol();
						break;
				}
				resultado = true;
				break;
			case R.id.item_AgregarPalabra:
				cambiarFragment(new AgregarPalabraFragment(), R.id.frame_layout);
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
