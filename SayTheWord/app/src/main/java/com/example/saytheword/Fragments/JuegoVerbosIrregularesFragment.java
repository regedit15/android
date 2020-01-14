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
import com.example.saytheword.Models.VerboIrregular;
import com.example.saytheword.R;
import com.example.saytheword.Services.RealmService;
import com.example.saytheword.Services.UtilService;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import static com.example.saytheword.Services.UtilService.JUEGO_TIPO_TRADUCCION_ESPANIOL_INGLES;
import static com.example.saytheword.Services.UtilService.JUEGO_TIPO_TRADUCCION_INGLES_ESPANIOL;
import static com.example.saytheword.Services.UtilService.JUEGO_VERBOS_IRREGULARES;
import static com.example.saytheword.Services.UtilService.JUEGO_VERBOS_IRREGULARES_PROBLEMATICOS;

public class JuegoVerbosIrregularesFragment extends Fragment {

	private UtilService utilService = new UtilService();
	private RealmService realmService = new RealmService();

	public TextView tvJuegoCantidadPalabras;
	public TextView tvInfinitivo;
	public TextView tvPronunciacion;
	public TextView tvPasado;
	public TextView tvPasadoPronunciacion;
	public TextView tvParticipio;
	public TextView tvParticipioPronunciacion;
	public TextView tvTraduccion;

	private List<VerboIrregular> verbosIrregularesDesordenadas = new ArrayList<>();
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

	public JuegoVerbosIrregularesFragment(String TIPO_JUEGO) {
		setHasOptionsMenu(true);
		this.TIPO_TRADUCCION = JUEGO_TIPO_TRADUCCION_INGLES_ESPANIOL;
		this.TIPO_JUEGO = TIPO_JUEGO;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_juego_verbos_irregulares, container, false);

		tvJuegoCantidadPalabras = view.findViewById(R.id.tvJuegoCantidadPalabras);
		tvInfinitivo = view.findViewById(R.id.tvInfinitivo);
		tvPronunciacion = view.findViewById(R.id.tvPronunciacion);
		tvPasado = view.findViewById(R.id.tvPasado);
		tvPasadoPronunciacion = view.findViewById(R.id.tvPasadoPronunciacion);
		tvParticipio = view.findViewById(R.id.tvParticipio);
		tvParticipioPronunciacion = view.findViewById(R.id.tvParticipioPronunciacion);
		tvTraduccion = view.findViewById(R.id.tvTraduccion);

		lyRespuestaJuego = view.findViewById(R.id.lyRespuestaJuego);
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
				realmService.cambiarMostrarRespuestaVerbosIrregulares(verbosIrregularesDesordenadas.get(indice));
				mostrarRespuesta(verbosIrregularesDesordenadas.get(indice).isMostrarRespuesta());
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
				realmService.cambiarPalabraProblematicaVerbosIrregulares(verbosIrregularesDesordenadas.get(indice));
				setearColorPalabraProblematica();
			}
		});

		return view;
	}

	private void setearTitulo() {
		tvJuegoCantidadPalabras.setText(new StringBuilder(Integer.toString(indice + 1)).append(" de ").append(verbosIrregularesDesordenadas.size()).toString());
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

		if (indice == verbosIrregularesDesordenadas.size()) {
			btRestart.setVisibility(View.VISIBLE);
			mbNext.setVisibility(View.INVISIBLE);
			btPrevious.setVisibility(View.INVISIBLE);
			btMostrarRespuestaJuego.setVisibility(View.INVISIBLE);
			tvJuegoCantidadPalabras.setVisibility(View.INVISIBLE);
			lyRespuestaJuego.setVisibility(View.INVISIBLE);
			ivCongratulations.setVisibility(View.VISIBLE);
			tvInfinitivo.setVisibility(View.INVISIBLE);
			btPalabraProblematica.setVisibility(View.INVISIBLE);
			Glide.with(getContext()).load(R.drawable.congratulation).into(ivCongratulations);
		} else {
			setearTextoArribaYColorDeBoton();
			mostrarRespuesta(verbosIrregularesDesordenadas.get(indice).isMostrarRespuesta());
			setearTitulo();
		}
	}

	private void setearTextoArribaYColorDeBoton() {
		switch (TIPO_TRADUCCION) {
			case JUEGO_TIPO_TRADUCCION_INGLES_ESPANIOL:
				tvInfinitivo.setText(verbosIrregularesDesordenadas.get(indice).getInfinitivo());
				break;
			case JUEGO_TIPO_TRADUCCION_ESPANIOL_INGLES:
				tvInfinitivo.setText(verbosIrregularesDesordenadas.get(indice).getTraduccion());
				break;
		}
		setearColorPalabraProblematica();
	}

	private void setearColorPalabraProblematica() {
		if (verbosIrregularesDesordenadas.get(indice).isPalabraProblematica()) {
			btPalabraProblematica.setIconResource(R.drawable.ic_angry);
			btPalabraProblematica.setBackgroundTintList(getResources().getColorStateList(R.color.colorPalabraProblematica));
		} else {
			btPalabraProblematica.setIconResource(R.drawable.ic_smile);
			btPalabraProblematica.setBackgroundTintList(getResources().getColorStateList(R.color.colorPalabraBuena));
		}
	}

	private void inicializarJuego() {
		// ------------- Se hace esto porque si lo igualo a utilService.getLista() da error

		List<VerboIrregular> lista = null;
		switch (TIPO_JUEGO) {
			case JUEGO_VERBOS_IRREGULARES:
				lista = utilService.getVerbosIrregulares(false);
				break;
			case JUEGO_VERBOS_IRREGULARES_PROBLEMATICOS:
				lista = utilService.getVerbosIrregulares(true);
				break;
		}

		if (lista.isEmpty()) {
			tvJuegoCantidadPalabras.setVisibility(View.VISIBLE);
			btRestart.setVisibility(View.INVISIBLE);
			ivCongratulations.setVisibility(View.INVISIBLE);
			mbNext.setVisibility(View.INVISIBLE);
			btPrevious.setVisibility(View.INVISIBLE);
			btMostrarRespuestaJuego.setVisibility(View.INVISIBLE);
			tvInfinitivo.setVisibility(View.INVISIBLE);
			btPalabraProblematica.setVisibility(View.INVISIBLE);
			tvJuegoCantidadPalabras.setText("No hay palabras problematicas!");
		} else {

			realmService.cambiarMostrarRespuestasVerbosIrregulares(lista, false);

			for (VerboIrregular x : lista) {
				verbosIrregularesDesordenadas.add(x);
			}

			Collections.shuffle(verbosIrregularesDesordenadas);
			// --------------------------------------------------------------

			indice = 0;
			setearTitulo();

			btRestart.setVisibility(View.INVISIBLE);
			ivCongratulations.setVisibility(View.INVISIBLE);
			mbNext.setVisibility(View.VISIBLE);
			btPrevious.setVisibility(View.INVISIBLE);
			tvJuegoCantidadPalabras.setVisibility(View.VISIBLE);
			btMostrarRespuestaJuego.setVisibility(View.VISIBLE);
			tvInfinitivo.setVisibility(View.VISIBLE);
			btPalabraProblematica.setVisibility(View.VISIBLE);
			lyRespuestaJuego.setVisibility(View.INVISIBLE);

			setearTextoArribaYColorDeBoton();
		}
	}

	private void mostrarRespuesta(boolean mostrarRespuesta) {
		if (mostrarRespuesta) {
			lyRespuestaJuego.setVisibility(View.VISIBLE);
			btMostrarRespuestaJuego.setIconResource(R.drawable.ic_eye_open);

			switch (TIPO_TRADUCCION) {
				case JUEGO_TIPO_TRADUCCION_INGLES_ESPANIOL:
					tvTraduccion.setText(verbosIrregularesDesordenadas.get(indice).getTraduccion());
					break;
				case JUEGO_TIPO_TRADUCCION_ESPANIOL_INGLES:
					tvTraduccion.setText(verbosIrregularesDesordenadas.get(indice).getInfinitivo());
					break;
			}

			tvPronunciacion.setText(verbosIrregularesDesordenadas.get(indice).getPronunciacion());
			tvPasado.setText(verbosIrregularesDesordenadas.get(indice).getPasado());
			tvPasadoPronunciacion.setText(verbosIrregularesDesordenadas.get(indice).getPasadoPronunciacion());
			tvParticipio.setText(verbosIrregularesDesordenadas.get(indice).getParticipio());
			tvParticipioPronunciacion.setText(verbosIrregularesDesordenadas.get(indice).getParticipioPronunciacion());

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
