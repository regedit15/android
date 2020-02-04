package martin.ingles.saytheword.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.button.MaterialButton;

import martin.ingles.saytheword.R;

import static martin.ingles.saytheword.Services.UtilService.LISTADO_PALABRAS;
import static martin.ingles.saytheword.Services.UtilService.LISTADO_PALABRAS_PROBLEMATCAS;
import static martin.ingles.saytheword.Services.UtilService.LISTADO_VERBOS_IRREGULARES;
import static martin.ingles.saytheword.Services.UtilService.LISTADO_VERBOS_IRREGULARES_PROBLEMATCOS;

public class SeleccionListadoFragment extends BaseFragment {

	MaterialButton btListadoPalabras;
	MaterialButton btListadoPalabrasProblematicas;
	MaterialButton btListadoVerbosIrregulares;
	MaterialButton btListadoVerbosIrregularesProblematicos;

	public SeleccionListadoFragment() {
		setHasOptionsMenu(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_seleccion_listado, container, false);

		setearTitulo("Listados");

		btListadoPalabras = view.findViewById(R.id.btListadoPalabras);
		btListadoPalabrasProblematicas = view.findViewById(R.id.btListadoPalabrasProblematicas);
		btListadoVerbosIrregulares = view.findViewById(R.id.btListadoVerbosIrregulares);
		btListadoVerbosIrregularesProblematicos = view.findViewById(R.id.btListadoVerbosIrregularesProblematicos);

		btListadoPalabras.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				cambiarFragment(new ListadoFragment(LISTADO_PALABRAS), R.id.frame_layout);
			}
		});

		btListadoPalabrasProblematicas.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				cambiarFragment(new ListadoFragment(LISTADO_PALABRAS_PROBLEMATCAS), R.id.frame_layout);
			}
		});

		btListadoVerbosIrregulares.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				cambiarFragment(new ListadoFragment(LISTADO_VERBOS_IRREGULARES), R.id.frame_layout);
			}
		});

		btListadoVerbosIrregularesProblematicos.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				cambiarFragment(new ListadoFragment(LISTADO_VERBOS_IRREGULARES_PROBLEMATCOS), R.id.frame_layout);
			}
		});
		return view;
	}

	//----------- Option Menu COMENTAR EN VERSION DE PRODUCCION
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		inflater.inflate(R.menu.action_bar_menu_seleccion_listado, menu);
		super.onCreateOptionsMenu(menu, inflater);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		boolean resultado;

		switch (item.getItemId()) {
			case R.id.reiniciar_palabras:
				utilService.insertarDatosSinModificarPalabrasProblematicas();
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
