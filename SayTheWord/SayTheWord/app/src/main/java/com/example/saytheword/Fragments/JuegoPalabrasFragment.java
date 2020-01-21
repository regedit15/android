package com.example.saytheword.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
import java.util.Random;

import androidx.constraintlayout.widget.ConstraintLayout;

import static com.example.saytheword.Services.UtilService.JUEGO_PALABRAS;
import static com.example.saytheword.Services.UtilService.JUEGO_PALABRAS_PROBLEMATICAS;
import static com.example.saytheword.Services.UtilService.JUEGO_TIPO_TRADUCCION_ESPANIOL_INGLES;
import static com.example.saytheword.Services.UtilService.JUEGO_TIPO_TRADUCCION_INGLES_ESPANIOL;

public class JuegoPalabrasFragment extends BaseFragment {

	private TextView tvJuegoPalabraArriba;
	private TextView tvJuegoPalabraAbajo;
	private TextView tvJuegoPalabraAbajo2;
	private TextView tvJuegoCantidadPalabras;
	private List<Palabra> palabrasDesordenadas = new ArrayList<>();
	private int indice;
	private MaterialButton mbNext;
	private MaterialButton btMostrarRespuestaJuego;
	private MaterialButton btPrevious;
	private MaterialButton btRestart;
	private MaterialButton btPalabraProblematica;
	private ConstraintLayout lyRespuestaJuego;
	private String TIPO_TRADUCCION;
	private boolean juegoAleatorio;
	private Random random = new Random();
	private ImageView ivCongratulations;
	private String TIPO_JUEGO;

	public JuegoPalabrasFragment(String TIPO_JUEGO) {
		setHasOptionsMenu(true);
		this.TIPO_TRADUCCION = JUEGO_TIPO_TRADUCCION_INGLES_ESPANIOL;
		this.TIPO_JUEGO = TIPO_JUEGO;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_juego_palabras, container, false);

		tvJuegoPalabraArriba = view.findViewById(R.id.tvJuegoPalabraArriba);
		tvJuegoPalabraAbajo = view.findViewById(R.id.tvJuegoPalabraAbajo);
		tvJuegoPalabraAbajo2 = view.findViewById(R.id.tvJuegoPalabraAbajo2);
		lyRespuestaJuego = view.findViewById(R.id.lyRespuestaJuego);
		tvJuegoCantidadPalabras = view.findViewById(R.id.tvJuegoCantidadPalabras);
		btPrevious = view.findViewById(R.id.btPrevious);
		btRestart = view.findViewById(R.id.btRestart);
		mbNext = view.findViewById(R.id.btNext);
		btMostrarRespuestaJuego = view.findViewById(R.id.btMostrarRespuestaJuego);
		ivCongratulations = view.findViewById(R.id.ivCongratulations);
		btPalabraProblematica = view.findViewById(R.id.btPalabraProblematica);

		inicializarJuego();

		btMostrarRespuestaJuego.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				realmService.cambiarMostrarRespuestaPalabra(palabrasDesordenadas.get(indice));
				mostrarRespuesta(palabrasDesordenadas.get(indice).isMostrarRespuesta());
			}
		});

		mbNext.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				indice++;
				continuarJuego();
			}
		});

		btPrevious.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				indice--;
				continuarJuego();
			}
		});

		btRestart.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				inicializarJuego();
			}
		});

		btPalabraProblematica.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				realmService.cambiarPalabraProblematicaPalabra(palabrasDesordenadas.get(indice));
				setearColorPalabraProblematica();
			}
		});

		return view;
	}

	private void setearTitulo() {
		tvJuegoCantidadPalabras.setText(new StringBuilder(Integer.toString(indice + 1)).append(" de ").append(palabrasDesordenadas.size()).toString());
	}

	private void continuarJuego() {

		if (indice == 0) {
			btPrevious.setVisibility(View.INVISIBLE);
		} else {
			btPrevious.setVisibility(View.VISIBLE);
		}

		if (juegoAleatorio == true) {
			switch (random.nextInt(2)) {
				case 0:
					TIPO_TRADUCCION = JUEGO_TIPO_TRADUCCION_INGLES_ESPANIOL;
					break;
				case 1:
					TIPO_TRADUCCION = JUEGO_TIPO_TRADUCCION_ESPANIOL_INGLES;
					break;
			}
		}

		if (indice == palabrasDesordenadas.size()) {
			btRestart.setVisibility(View.VISIBLE);
			mbNext.setVisibility(View.INVISIBLE);
			btPrevious.setVisibility(View.INVISIBLE);
			btMostrarRespuestaJuego.setVisibility(View.INVISIBLE);
			tvJuegoCantidadPalabras.setVisibility(View.INVISIBLE);
			lyRespuestaJuego.setVisibility(View.INVISIBLE);
			ivCongratulations.setVisibility(View.VISIBLE);
			tvJuegoPalabraArriba.setVisibility(View.INVISIBLE);
			btPalabraProblematica.setVisibility(View.INVISIBLE);
			Glide.with(getContext()).load(R.drawable.congratulation).into(ivCongratulations);
		} else {
			setearTextoArribaYcolorDeBoton();
			mostrarRespuesta(palabrasDesordenadas.get(indice).isMostrarRespuesta());
			setearTitulo();
		}
	}

	private void setearTextoArribaYcolorDeBoton() {
		switch (TIPO_TRADUCCION) {
			case JUEGO_TIPO_TRADUCCION_INGLES_ESPANIOL:
				tvJuegoPalabraArriba.setText(palabrasDesordenadas.get(indice).getPalabraIng());
				break;
			case JUEGO_TIPO_TRADUCCION_ESPANIOL_INGLES:
				tvJuegoPalabraArriba.setText(palabrasDesordenadas.get(indice).getPalabraEsp());
				break;
		}
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

		List<Palabra> lista = null;
		switch (TIPO_JUEGO) {
			case JUEGO_PALABRAS:
				lista = utilService.getPalabras(false);
				break;
			case JUEGO_PALABRAS_PROBLEMATICAS:
				lista = utilService.getPalabras(true);
				break;
		}

		if (lista.isEmpty()) {
			tvJuegoCantidadPalabras.setVisibility(View.VISIBLE);
			btRestart.setVisibility(View.INVISIBLE);
			ivCongratulations.setVisibility(View.INVISIBLE);
			mbNext.setVisibility(View.INVISIBLE);
			btPrevious.setVisibility(View.INVISIBLE);
			btMostrarRespuestaJuego.setVisibility(View.INVISIBLE);
			tvJuegoPalabraArriba.setVisibility(View.INVISIBLE);
			btPalabraProblematica.setVisibility(View.INVISIBLE);
			lyRespuestaJuego.setVisibility(View.INVISIBLE);
			tvJuegoCantidadPalabras.setText("No hay palabras problematicas!");
		} else {

			realmService.cambiarMostrarRespuestasPalabras(lista, false);

			for (Palabra p : lista) {
				palabrasDesordenadas.add(p);
			}

			Collections.shuffle(palabrasDesordenadas);
			// --------------------------------------------------------------

			indice = 0;
			setearTitulo();

			btRestart.setVisibility(View.INVISIBLE);
			ivCongratulations.setVisibility(View.INVISIBLE);
			mbNext.setVisibility(View.VISIBLE);
			btPrevious.setVisibility(View.INVISIBLE);
			tvJuegoCantidadPalabras.setVisibility(View.VISIBLE);
			btMostrarRespuestaJuego.setVisibility(View.VISIBLE);
			tvJuegoPalabraArriba.setVisibility(View.VISIBLE);
			btPalabraProblematica.setVisibility(View.VISIBLE);
			lyRespuestaJuego.setVisibility(View.INVISIBLE);

			setearTextoArribaYcolorDeBoton();
		}
	}

	private void mostrarRespuesta(boolean mostrarRespuesta) {
		if (mostrarRespuesta) {
			lyRespuestaJuego.setVisibility(View.VISIBLE);
			btMostrarRespuestaJuego.setIconResource(R.drawable.ic_eye_open);

			switch (TIPO_TRADUCCION) {
				case JUEGO_TIPO_TRADUCCION_INGLES_ESPANIOL:
					tvJuegoPalabraAbajo.setText(palabrasDesordenadas.get(indice).getPalabraEsp());
					break;
				case JUEGO_TIPO_TRADUCCION_ESPANIOL_INGLES:
					tvJuegoPalabraAbajo.setText(palabrasDesordenadas.get(indice).getPalabraIng());
					break;
			}

			tvJuegoPalabraAbajo2.setText(palabrasDesordenadas.get(indice).getPronunciacion());
		} else {
			lyRespuestaJuego.setVisibility(View.INVISIBLE);
			btMostrarRespuestaJuego.setIconResource(R.drawable.ic_eye_closed);
		}
	}

	//----------- Option Menu
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		inflater.inflate(R.menu.action_bar_menu_juego, menu);
		super.onCreateOptionsMenu(menu, inflater);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		boolean resultado;

		switch (item.getItemId()) {
			case R.id.item_juegoEspaniolIngles:
				TIPO_TRADUCCION = JUEGO_TIPO_TRADUCCION_ESPANIOL_INGLES;
				juegoAleatorio = false;
				resultado = true;
				break;
			case R.id.item_juegoInglesEspañol:
				TIPO_TRADUCCION = JUEGO_TIPO_TRADUCCION_INGLES_ESPANIOL;
				juegoAleatorio = false;
				resultado = true;
				break;
			case R.id.item_juegoMezclado:
				juegoAleatorio = true;
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
