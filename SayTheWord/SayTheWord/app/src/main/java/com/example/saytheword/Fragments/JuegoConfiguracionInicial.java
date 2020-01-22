package com.example.saytheword.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Switch;

import com.example.saytheword.Exceptions.GenericException;
import com.example.saytheword.Models.Palabra;
import com.example.saytheword.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

import static com.example.saytheword.Services.UtilService.LISTADO_PALABRAS;
import static com.example.saytheword.Services.UtilService.LISTADO_PALABRAS_PROBLEMATCAS;

public class JuegoConfiguracionInicial extends BaseFragment {

	private TextInputEditText etCantidadIntentos;
	private TextInputEditText etCantidadItems;
	private Switch swSoloPalabrasProblematicas;
	private MaterialButton btComenzarJuego;
	private RadioGroup rgEscrituraOVisualizacion;
	private RadioGroup rgPalabrasOVerbosIrregulares;
	private TextInputLayout etCantidadIntentosContenedor;

	public JuegoConfiguracionInicial() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		final View view = inflater.inflate(R.layout.fragment_juego_configuracion_inicial, container, false);

		setearTitulo("Configurar Juego");

		btComenzarJuego = view.findViewById(R.id.btComenzarJuego);
		etCantidadIntentos = view.findViewById(R.id.etCantidadIntentos);
		etCantidadItems = view.findViewById(R.id.etCantidadItems);
		swSoloPalabrasProblematicas = view.findViewById(R.id.swSoloPalabrasProblematicas);
		rgEscrituraOVisualizacion = view.findViewById(R.id.rgEscrituraOVisualizacion);
		rgPalabrasOVerbosIrregulares = view.findViewById(R.id.rgPalabrasOVerbosIrregulares);
		etCantidadIntentos = view.findViewById(R.id.etCantidadIntentos);
		etCantidadIntentosContenedor = view.findViewById(R.id.etCantidadIntentosContenedor);

		btComenzarJuego.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				try {
					validar();

					switch (rgEscrituraOVisualizacion.getCheckedRadioButtonId()) {
						case R.id.rdVisualizacion:

							switch (rgPalabrasOVerbosIrregulares.getCheckedRadioButtonId()) {
								case R.id.rbPalabras:
									if (swSoloPalabrasProblematicas.isChecked()) {
										cambiarFragment(new ListadoFragment(LISTADO_PALABRAS_PROBLEMATCAS), R.id.frame_layout);
									} else {
										cambiarFragment(new ListadoFragment(LISTADO_PALABRAS), R.id.frame_layout);
									}
									break;
								case R.id.rbVerbosIrregulares:

									break;
							}

							break;
						case R.id.rbEscritura:


							break;
					}


					cambiarFragment(new JuegoEscribirPalabra(

							Integer.parseInt(etCantidadIntentos.getText().toString()),

							Integer.parseInt(etCantidadItems.getText().toString()),

							swSoloPalabrasProblematicas.isChecked()

					), R.id.frame_layout);
				} catch (GenericException e) {
					mostrarPopup(e.getTitulo(), e.getMensaje());
				}
			}
		});

		rgEscrituraOVisualizacion.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
					case R.id.rdVisualizacion:
						etCantidadIntentosContenedor.setVisibility(View.GONE);
						rgPalabrasOVerbosIrregulares.setVisibility(View.VISIBLE);
						break;
					case R.id.rbEscritura:
						etCantidadIntentosContenedor.setVisibility(View.VISIBLE);
						rgPalabrasOVerbosIrregulares.setVisibility(View.GONE);
						break;
				}
			}
		});

		return view;
	}

	private void validar() throws GenericException {

		List<Palabra> lista = utilService.getPalabras(swSoloPalabrasProblematicas.isChecked());

		if (swSoloPalabrasProblematicas.isChecked() && lista.isEmpty()) {
			throw new GenericException("No hay ninguna palabra problematica!");
		}

		try {
			Integer.parseInt(etCantidadIntentos.getText().toString());
		} catch (Exception e) {
			throw new GenericException("Ingrese una cantidad de intentos valida!");
		}

		int cantidadPalabras;
		try {
			cantidadPalabras = Integer.parseInt(etCantidadItems.getText().toString());
		} catch (Exception e) {
			throw new GenericException("Ingrese una cantidad de items valida!");
		}

		if (cantidadPalabras > lista.size()) {
			throw new GenericException(

					"No hay tantas palabras!",

					new StringBuilder("Pusiste ").append(cantidadPalabras).append(" y solo hay ").append(lista.size()).append(" palabras").toString()

			);
		}
	}
}
