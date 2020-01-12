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

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

public class JuegoFragment extends Fragment {

	private UtilService utilService = new UtilService();
	private TextView tvJuegoPalabraArriba;
	private TextView tvJuegoPalabraAbajo;
	private List<Palabra> palabrasDesordenadas;
	private int indice;
	private MaterialButton mbNext;
	private MaterialButton btMostrarRespuestaJuego;
	private ConstraintLayout lyRespuestaJuego;

	public JuegoFragment() {
		setHasOptionsMenu(true);
		inicializarJuego();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_juego, container, false);

		tvJuegoPalabraArriba = view.findViewById(R.id.tvJuegoPalabraArriba);
		tvJuegoPalabraAbajo = view.findViewById(R.id.tvJuegoPalabraAbajo);
		lyRespuestaJuego = view.findViewById(R.id.lyRespuestaJuego);
		tvJuegoPalabraAbajo.setText("");
		setearTextoArriba();

		mbNext = view.findViewById(R.id.btNext);

		mbNext.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				indice++;

				if (indice == palabrasDesordenadas.size()) {
					tvJuegoPalabraArriba.setText("CONGRATULATIONS!!!!!");
					inicializarJuego();
				} else {
					setearTextoArriba();
					mostrarRespuesta(false);
				}
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

		// mostrarRespuesta(palabrasDesordenadas.get(indice).isMostrarRespuesta());

		return view;
	}

	private void setearTextoArriba() {
		tvJuegoPalabraArriba.setText(palabrasDesordenadas.get(indice).getPalabraIng());
	}

	private void inicializarJuego() {
		palabrasDesordenadas = utilService.getPalabras();
		Collections.shuffle(palabrasDesordenadas);
		indice = 0;
	}

	private void mostrarRespuesta(boolean mostrarRespuesta) {
		if (mostrarRespuesta) {
			lyRespuestaJuego.setVisibility(View.VISIBLE);
			btMostrarRespuestaJuego.setIconResource(R.drawable.ic_eye_open);
			tvJuegoPalabraAbajo.setText(palabrasDesordenadas.get(indice).getPalabraEsp());
		} else {
			lyRespuestaJuego.setVisibility(View.INVISIBLE);
			btMostrarRespuestaJuego.setIconResource(R.drawable.ic_eye_closed);
		}
	}

	//----------- Option Menu
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		inflater.inflate(R.menu.action_bar_menu2, menu);
		super.onCreateOptionsMenu(menu, inflater);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		boolean resultado;

		switch (item.getItemId()) {
			case R.id.item_reset2:
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
