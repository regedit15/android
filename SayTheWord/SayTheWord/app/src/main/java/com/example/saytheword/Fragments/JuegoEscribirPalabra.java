package com.example.saytheword.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.saytheword.Models.Palabra;
import com.example.saytheword.R;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import androidx.constraintlayout.widget.ConstraintLayout;

public class JuegoEscribirPalabra extends BaseFragment {

	private int cantidadIntentos;
	private int cantidadIntentosFallidos = 0;
	//---------

	private TextView tvJuegoCantidadPalabras;
	private TextView tvJuegoPalabraAdivinar;
	private TextView etRespuesta;
	private TextView tvCantidadIntentosRestantes;
	private TextView tvSolucion;
	private MaterialButton btEvaluar;
	private MaterialButton btNext;
	private MaterialButton btPrevious;
	private MaterialButton btRestart;
	private MaterialButton btPalabraProblematica;
	private ConstraintLayout lyRespuestaJuego;
	private ImageView ivCongratulations;

	private List<Palabra> palabrasDesordenadas = new ArrayList<>();
	private int indice;
	private boolean soloPalabrasProblematicas;

	public JuegoEscribirPalabra(int cantidadIntentos, boolean soloPalabrasProblematicas) {
		this.cantidadIntentos = cantidadIntentos;
		this.soloPalabrasProblematicas = soloPalabrasProblematicas;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_juego_escribir_palabra, container, false);

		tvJuegoCantidadPalabras = view.findViewById(R.id.tvJuegoCantidadPalabras);
		tvJuegoPalabraAdivinar = view.findViewById(R.id.tvJuegoPalabraAdivinar);
		etRespuesta = view.findViewById(R.id.etRespuesta);
		tvSolucion = view.findViewById(R.id.tvSolucion);
		btNext = view.findViewById(R.id.btNext);
		btEvaluar = view.findViewById(R.id.btEvaluar);
		btPrevious = view.findViewById(R.id.btPrevious);
		btRestart = view.findViewById(R.id.btRestart);
		btPalabraProblematica = view.findViewById(R.id.btPalabraProblematica);
		lyRespuestaJuego = view.findViewById(R.id.lyRespuestaJuego);
		ivCongratulations = view.findViewById(R.id.ivCongratulations);
		tvCantidadIntentosRestantes = view.findViewById(R.id.tvCantidadIntentosRestantes);


		inicializarJuego();

		btEvaluar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {


				if (etRespuesta.getText().toString().equalsIgnoreCase(palabrasDesordenadas.get(indice).getPalabraIng())) {
					siguiente();
				} else {
					cantidadIntentosFallidos++;

					if (cantidadIntentosFallidos == cantidadIntentos) {
						//juego perdido
						mostrarImagenFinal(R.drawable.game_over);
					} else {

						lyRespuestaJuego.setVisibility(View.VISIBLE);

						tvSolucion.setText(new StringBuilder("Escribiste \"").append(etRespuesta.getText().toString()).append("\" y la respuesta correcta era \"").append(palabrasDesordenadas.get(indice).getPalabraIng()).append("\"").toString());


						int cantidadIntentosRestantes = cantidadIntentos - cantidadIntentosFallidos;

						if (cantidadIntentosRestantes == 1) {
							tvCantidadIntentosRestantes.setText("Te queda 1 intento");
						} else {
							tvCantidadIntentosRestantes.setText(new StringBuilder("Te quedan ").append(cantidadIntentosRestantes).append(" intentos").toString());
						}

						btNext.setVisibility(View.VISIBLE);
						btEvaluar.setVisibility(View.INVISIBLE);
					}
				}
			}
		});


		btNext.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				siguiente();
			}
		});

		btRestart.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				inicializarJuego();
				mostrarImagenFinal(R.drawable.congratulation);
			}
		});

		return view;
	}

	private void siguiente() {
		indice++;
		continuarJuego();
		lyRespuestaJuego.setVisibility(View.INVISIBLE);
		etRespuesta.setText("");

		btNext.setVisibility(View.INVISIBLE);
		btEvaluar.setVisibility(View.VISIBLE);
	}

	private void mostrarImagenFinal(int idImagen) {

		tvJuegoCantidadPalabras.setVisibility(View.INVISIBLE);
		tvJuegoPalabraAdivinar.setVisibility(View.INVISIBLE);
		etRespuesta.setVisibility(View.INVISIBLE);
		tvSolucion.setVisibility(View.INVISIBLE);
		btNext.setVisibility(View.INVISIBLE);
		btEvaluar.setVisibility(View.INVISIBLE);
		btPrevious.setVisibility(View.INVISIBLE);
		btRestart.setVisibility(View.VISIBLE);
		btPalabraProblematica.setVisibility(View.INVISIBLE);
		lyRespuestaJuego.setVisibility(View.INVISIBLE);

		// Glide.with(getContext()).load(idImagen).into(ivCongratulations);
		Glide.with(getContext()).load(R.drawable.congratulation).into(ivCongratulations);
	}

	private void setearTitulo() {
		tvJuegoCantidadPalabras.setText(new StringBuilder(Integer.toString(indice + 1)).append(" de ").append(palabrasDesordenadas.size()).toString());
	}

	private void continuarJuego() {

		if (indice == palabrasDesordenadas.size()) {
			mostrarImagenFinal(R.drawable.congratulation);
		} else {
			setearTextoArribaYcolorDeBoton();
			// mostrarRespuesta(palabrasDesordenadas.get(indice).isMostrarRespuesta());
			setearTitulo();
		}
	}

	private void setearTextoArribaYcolorDeBoton() {
		tvJuegoPalabraAdivinar.setText(palabrasDesordenadas.get(indice).getPalabraEsp());
		setearColorPalabraProblematica();
	}

	private void setearColorPalabraProblematica() {
		if (palabrasDesordenadas.get(indice).isPalabraProblematica()) {
			btPalabraProblematica.setIconResource(R.drawable.ic_angry);
			btPalabraProblematica.setBackgroundTintList(getResources().getColorStateList(R.color.colorPalabraProblematica));
		} else {
			btPalabraProblematica.setIconResource(R.drawable.ic_smile);
			btPalabraProblematica.setBackgroundTintList(getResources().getColorStateList(R.color.colorPalabraBuena));
		}
	}

	private void inicializarJuego() {

		// ------------- Se hace esto porque si lo igualo a utilService.getLista() da error
		List<Palabra> lista = utilService.getPalabras(soloPalabrasProblematicas);

		realmService.cambiarMostrarRespuestasPalabras(lista, false);

		for (Palabra p : lista) {
			palabrasDesordenadas.add(p);
		}

		Collections.shuffle(palabrasDesordenadas);
		// --------------------------------------------------------------

		indice = 0;
		setearTitulo();

		btPrevious.setVisibility(View.INVISIBLE);
		btRestart.setVisibility(View.INVISIBLE);
		lyRespuestaJuego.setVisibility(View.INVISIBLE);
		ivCongratulations.setVisibility(View.INVISIBLE);

		setearTextoArribaYcolorDeBoton();
	}
}
