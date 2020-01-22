package com.example.saytheword.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

import com.example.saytheword.Exceptions.GenericException;
import com.example.saytheword.Models.Palabra;
import com.example.saytheword.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

public class JuegoConfiguracionInicial extends BaseFragment {

	private TextInputEditText etCantidadIntentos;
	private TextInputEditText etCantidadItems;
	private Switch swSoloPalabrasProblematicas;
	private MaterialButton btComenzarJuego;

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

		btComenzarJuego.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				try {
					validar();
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
