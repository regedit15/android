package com.example.saytheword.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Switch;

import com.example.saytheword.Exceptions.GenericException;
import com.example.saytheword.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import static com.example.saytheword.Services.UtilService.JUEGO_PALABRAS;
import static com.example.saytheword.Services.UtilService.JUEGO_PALABRAS_PROBLEMATICAS;
import static com.example.saytheword.Services.UtilService.JUEGO_VERBOS_IRREGULARES;
import static com.example.saytheword.Services.UtilService.JUEGO_VERBOS_IRREGULARES_PROBLEMATICOS;

public class JuegoConfiguracionInicial extends BaseFragment {

	private TextInputLayout etCantidadIntentosContenedor;
	private TextInputEditText etCantidadIntentos;
	private TextInputEditText etCantidadItems;
	private Switch swSoloPalabrasProblematicas;
	private MaterialButton btComenzarJuego;
	private RadioGroup rgEscrituraOVisualizacion;
	private RadioGroup rgPalabrasOVerbosIrregulares;

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

		setearCantidadItems(utilService.getPalabras(false).size());

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
										cambiarFragment(new JuegoPalabrasFragment(JUEGO_PALABRAS_PROBLEMATICAS, Integer.parseInt(etCantidadItems.getText().toString())), R.id.frame_layout);
									} else {
										cambiarFragment(new JuegoPalabrasFragment(JUEGO_PALABRAS, Integer.parseInt(etCantidadItems.getText().toString())), R.id.frame_layout);
									}
									break;
								case R.id.rbVerbosIrregulares:
									if (swSoloPalabrasProblematicas.isChecked()) {
										cambiarFragment(new JuegoVerbosIrregularesFragment(JUEGO_VERBOS_IRREGULARES_PROBLEMATICOS, Integer.parseInt(etCantidadItems.getText().toString())), R.id.frame_layout);
									} else {
										cambiarFragment(new JuegoVerbosIrregularesFragment(JUEGO_VERBOS_IRREGULARES, Integer.parseInt(etCantidadItems.getText().toString())), R.id.frame_layout);
									}
									break;
							}

							break;
						case R.id.rbEscritura:

							switch (rgPalabrasOVerbosIrregulares.getCheckedRadioButtonId()) {
								case R.id.rbPalabras:
									cambiarFragment(new JuegoEscribirPalabra(

											Integer.parseInt(etCantidadIntentos.getText().toString()),

											Integer.parseInt(etCantidadItems.getText().toString()),

											swSoloPalabrasProblematicas.isChecked()

									), R.id.frame_layout);
									break;
								case R.id.rbVerbosIrregulares:

									cambiarFragment(new JuegoEscribirVerboIrregularFragment(

											Integer.parseInt(etCantidadIntentos.getText().toString()),

											Integer.parseInt(etCantidadItems.getText().toString()),

											swSoloPalabrasProblematicas.isChecked()

									), R.id.frame_layout);
									break;
							}
							break;
					}
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
						break;
					case R.id.rbEscritura:
						etCantidadIntentosContenedor.setVisibility(View.VISIBLE);
						break;
				}
				calcularCantidadItems();
			}
		});

		rgPalabrasOVerbosIrregulares.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				calcularCantidadItems();
			}
		});

		swSoloPalabrasProblematicas.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				calcularCantidadItems();
			}
		});

		return view;
	}

	private void validar() throws GenericException {

		int cantidadItems = 0;

		switch (rgEscrituraOVisualizacion.getCheckedRadioButtonId()) {
			case R.id.rdVisualizacion:
				switch (rgPalabrasOVerbosIrregulares.getCheckedRadioButtonId()) {
					case R.id.rbPalabras:
						cantidadItems = utilService.getPalabras(swSoloPalabrasProblematicas.isChecked()).size();
						break;
					case R.id.rbVerbosIrregulares:
						cantidadItems = utilService.getVerbosIrregulares(swSoloPalabrasProblematicas.isChecked()).size();
						break;
				}
				break;
			case R.id.rbEscritura:
				cantidadItems = utilService.getPalabras(swSoloPalabrasProblematicas.isChecked()).size();
				break;
		}

		int cantidadPalabras = Integer.parseInt(etCantidadItems.getText().toString());

		if (swSoloPalabrasProblematicas.isChecked() && (cantidadItems == 0)) {
			throw new GenericException("No hay ninguna palabra problematica!");
		}

		if (cantidadPalabras > cantidadItems) {

			String palabra;

			if (cantidadItems == 1) {
				palabra = " palabra";
			} else {
				palabra = " palabras";
			}

			throw new GenericException(

					"No hay tantas palabras!",

					new StringBuilder("Pusiste ").append(cantidadPalabras).append(" y solo hay ").append(cantidadItems).append(palabra).toString()

			);
		}
	}

	private void calcularCantidadItems() {

		int cantidad = 0;

		switch (rgPalabrasOVerbosIrregulares.getCheckedRadioButtonId()) {
			case R.id.rbPalabras:
				cantidad = utilService.getPalabras(swSoloPalabrasProblematicas.isChecked()).size();
				break;
			case R.id.rbVerbosIrregulares:
				cantidad = utilService.getVerbosIrregulares(swSoloPalabrasProblematicas.isChecked()).size();
				break;
		}

		setearCantidadItems(cantidad);
	}

	private void setearCantidadItems(int cantidad) {
		etCantidadItems.setText(String.valueOf(cantidad));
	}
}
