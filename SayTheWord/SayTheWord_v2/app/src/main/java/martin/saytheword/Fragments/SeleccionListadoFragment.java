package martin.saytheword.Fragments;

import static martin.saytheword.Services.UtilService.LISTADO_PALABRAS;
import static martin.saytheword.Services.UtilService.LISTADO_VERBOS_IRREGULARES;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

import com.google.android.material.button.MaterialButton;

import martin.saytheword.Exceptions.GenericException;
import martin.saytheword.R;

public class SeleccionListadoFragment extends BaseFragment {

	Switch swFaciles;
	Switch swNormales;
	Switch swDificiles;
	MaterialButton btListadoPalabras;
	MaterialButton btListadoVerbosIrregulares;

	public SeleccionListadoFragment() {
		setHasOptionsMenu(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_seleccion_listado, container, false);

		setearTitulo("Listados");

		swFaciles = view.findViewById(R.id.swFaciles);
		swNormales = view.findViewById(R.id.swNormales);
		swDificiles = view.findViewById(R.id.swDificiles);
		btListadoPalabras = view.findViewById(R.id.btListadoPalabras);
		btListadoVerbosIrregulares = view.findViewById(R.id.btListadoVerbosIrregulares);

		btListadoPalabras.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					validarPalabras("No tienes ninguna palabra!");
					cambiarFragment(new ListadoFragment(LISTADO_PALABRAS, swFaciles.isChecked(), swNormales.isChecked(), swDificiles.isChecked()), R.id.frame_layout);
				} catch (GenericException e) {
					mostrarPopup(e.getTitulo(), e.getMensaje());
				}
			}
		});

		btListadoVerbosIrregulares.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				try {
					validarVerbosIrregulares("No tienes ningun verbo!");
					cambiarFragment(new ListadoFragment(LISTADO_VERBOS_IRREGULARES, swFaciles.isChecked(), swNormales.isChecked(), swDificiles.isChecked()), R.id.frame_layout);
				} catch (GenericException e) {
					mostrarPopup(e.getTitulo(), e.getMensaje());
				}
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

		if (item.getItemId() == R.id.reiniciar_palabras) {
			utilService.insertarDatosSinModificarPalabrasEncontradas();
			resultado = true;
		} else {
			resultado = super.onOptionsItemSelected(item);
		}

		return resultado;
	}
	//-------------------------------------------------

	private void validarPalabras(String mensajeListaVacia) throws GenericException {
		validarSeleccionDePalabras(mensajeListaVacia, utilService.getPalabras(swFaciles.isChecked(), swNormales.isChecked(), swDificiles.isChecked()).isEmpty());
	}

	private void validarVerbosIrregulares(String mensajeListaVacia) throws GenericException {
		validarSeleccionDePalabras(mensajeListaVacia, utilService.getVerbosIrregulares(swFaciles.isChecked(), swNormales.isChecked(), swDificiles.isChecked()).isEmpty());
	}

	private void validarSeleccionDePalabras(String mensajeListaVacia, boolean listaVacia) throws GenericException {
		if (!swFaciles.isChecked() && !swNormales.isChecked() && !swDificiles.isChecked()) {
			throw new GenericException("Debe elegir al menos un tipo!");
		}

		if (listaVacia) {
			throw new GenericException(mensajeListaVacia);
		}
	}

}
