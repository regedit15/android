package com.example.saytheword.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.saytheword.Models.Palabra;
import com.example.saytheword.R;
import com.example.saytheword.Services.UtilService;
import com.google.android.material.button.MaterialButton;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import static com.example.saytheword.Services.UtilService.TIPO_JUEGO_ESPANIOL_INGLES;
import static com.example.saytheword.Services.UtilService.TIPO_JUEGO_INGLES_ESPANIOL;

public class JuegoFragment extends Fragment {

	private UtilService utilService = new UtilService();
	private TextView tvJuegoPalabraArriba;
	private TextView tvJuegoPalabraAbajo;
	private TextView tvJuegoPalabraAbajo2;
	private TextView tvJuegoCantidadPalabras;
	private List<Palabra> palabrasDesordenadas;
	private int indice;
	private MaterialButton mbNext;
	private MaterialButton btMostrarRespuestaJuego;
	private MaterialButton btPrevious;
	private MaterialButton btRestart;
	private ConstraintLayout lyRespuestaJuego;
	private int TIPO_JUEGO;
	private boolean juegoAleatorio;
	private Random random = new Random();

	public JuegoFragment() {
		setHasOptionsMenu(true);
		TIPO_JUEGO = TIPO_JUEGO_INGLES_ESPANIOL;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_juego, container, false);

		tvJuegoPalabraArriba = view.findViewById(R.id.tvJuegoPalabraArriba);
		tvJuegoPalabraAbajo = view.findViewById(R.id.tvJuegoPalabraAbajo);
		tvJuegoPalabraAbajo2 = view.findViewById(R.id.tvJuegoPalabraAbajo2);
		lyRespuestaJuego = view.findViewById(R.id.lyRespuestaJuego);
		tvJuegoCantidadPalabras = view.findViewById(R.id.tvJuegoCantidadPalabras);
		btPrevious = view.findViewById(R.id.btPrevious);
		btRestart = view.findViewById(R.id.btRestart);
		mbNext = view.findViewById(R.id.btNext);

		tvJuegoPalabraAbajo.setText("");
		tvJuegoPalabraAbajo2.setText("");

		inicializarJuego();
		setearTextoArriba();


		mbNext.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				indice++;
				continuarJuego();
			}
		});

		btMostrarRespuestaJuego = view.findViewById(R.id.btMostrarRespuestaJuego);


		btMostrarRespuestaJuego.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				palabrasDesordenadas.get(indice).cambiarMostrarRespuesta();
				mostrarRespuesta(palabrasDesordenadas.get(indice).isMostrarRespuesta());
			}
		});

		btPrevious.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				indice--;
				continuarJuego();
			}
		});

		return view;
	}

	private void setearTitulo() {
		tvJuegoCantidadPalabras.setText(new StringBuilder(Integer.toString(indice + 1)).append(" de ").append(palabrasDesordenadas.size()).toString());
	}

	private void continuarJuego() {


		if (juegoAleatorio == true) {
			switch (random.nextInt(1)) {
				case 0:
					TIPO_JUEGO = TIPO_JUEGO_INGLES_ESPANIOL;
					break;
				case 1:
					TIPO_JUEGO = TIPO_JUEGO_ESPANIOL_INGLES;
					break;
			}
		}

		if (indice == palabrasDesordenadas.size()) {
			btRestart.setVisibility(View.VISIBLE);
			mbNext.setVisibility(View.INVISIBLE);
			btPrevious.setVisibility(View.INVISIBLE);

			tvJuegoPalabraArriba.setText("CONGRATULATIONS!!!!!");
			inicializarJuego();
		} else {
			setearTextoArriba();
			mostrarRespuesta(false);
			setearTitulo();
		}
	}

	private void setearTextoArriba() {
		switch (TIPO_JUEGO) {
			case TIPO_JUEGO_INGLES_ESPANIOL:
				tvJuegoPalabraArriba.setText(palabrasDesordenadas.get(indice).getPalabraIng());
				break;
			case TIPO_JUEGO_ESPANIOL_INGLES:
				tvJuegoPalabraArriba.setText(palabrasDesordenadas.get(indice).getPalabraEsp());
				break;
		}
	}

	private void inicializarJuego() {
		palabrasDesordenadas = utilService.getPalabras();
		Collections.shuffle(palabrasDesordenadas);
		indice = 0;
		setearTitulo();

		btRestart.setVisibility(View.INVISIBLE);
		mbNext.setVisibility(View.VISIBLE);
		btPrevious.setVisibility(View.VISIBLE);
	}

	private void mostrarRespuesta(boolean mostrarRespuesta) {
		if (mostrarRespuesta) {
			lyRespuestaJuego.setVisibility(View.VISIBLE);
			btMostrarRespuestaJuego.setIconResource(R.drawable.ic_eye_open);

			switch (TIPO_JUEGO) {
				case TIPO_JUEGO_INGLES_ESPANIOL:
					tvJuegoPalabraAbajo.setText(palabrasDesordenadas.get(indice).getPalabraEsp());
					break;
				case TIPO_JUEGO_ESPANIOL_INGLES:
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
				TIPO_JUEGO = TIPO_JUEGO_ESPANIOL_INGLES;
				juegoAleatorio = false;
				resultado = true;
				break;
			case R.id.item_juegoInglesEspañol:
				TIPO_JUEGO = TIPO_JUEGO_INGLES_ESPANIOL;
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
