package martin.ingles.saytheword.Fragments;

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
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import androidx.constraintlayout.widget.ConstraintLayout;
import martin.ingles.saytheword.Models.Palabra;
import martin.ingles.saytheword.R;

import static martin.ingles.saytheword.Services.UtilService.ESTADO_DIFICIL;
import static martin.ingles.saytheword.Services.UtilService.ESTADO_FACIL;
import static martin.ingles.saytheword.Services.UtilService.ESTADO_NORMAL;
import static martin.ingles.saytheword.Services.UtilService.JUEGO_TIPO_TRADUCCION_ESPANIOL_INGLES;
import static martin.ingles.saytheword.Services.UtilService.JUEGO_TIPO_TRADUCCION_INGLES_ESPANIOL;

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
	private MaterialButton btDificultad;
	private ConstraintLayout lyRespuestaJuego;
	private String TIPO_TRADUCCION;
	private boolean juegoAleatorio;
	private Random random = new Random();
	private ImageView ivCongratulations;
	private int cantidadItems;

	private boolean faciles;
	private boolean normales;
	private boolean dificiles;

	public JuegoPalabrasFragment(boolean faciles, boolean normales, boolean dificiles, int cantidadItems) {
		setHasOptionsMenu(true);
		this.TIPO_TRADUCCION = JUEGO_TIPO_TRADUCCION_INGLES_ESPANIOL;
		this.cantidadItems = cantidadItems;
		this.faciles = faciles;
		this.normales = normales;
		this.dificiles = dificiles;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_juego_palabras, container, false);

		setearTitulo("Juego");

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
		btDificultad = view.findViewById(R.id.btDificultad);

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

		btDificultad.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				realmService.cambiarDificultadPalabra(palabrasDesordenadas.get(indice));
				setearColorDificultad();
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
			btDificultad.setVisibility(View.INVISIBLE);
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
		setearColorDificultad();
	}

	private void setearColorDificultad() {
		switch (palabrasDesordenadas.get(indice).getDificultad()) {
			case ESTADO_FACIL:
				btDificultad.setIconResource(R.drawable.ic_happy);
				btDificultad.setBackgroundTintList(getResources().getColorStateList(R.color.colorDificultadFacil));
				break;
			case ESTADO_NORMAL:
				btDificultad.setIconResource(R.drawable.ic_smile);
				btDificultad.setBackgroundTintList(getResources().getColorStateList(R.color.colorDificultadNormal));
				break;
			case ESTADO_DIFICIL:
				btDificultad.setIconResource(R.drawable.ic_angry);
				btDificultad.setBackgroundTintList(getResources().getColorStateList(R.color.colorDificultadDificil));
				break;
		}
	}

	private void inicializarJuego() {
		// ------------- Se hace esto porque si lo igualo a utilService.getLista() da error
		List<Palabra> lista = utilService.getPalabras(faciles, normales, dificiles);


		if (lista.isEmpty()) {
			tvJuegoCantidadPalabras.setVisibility(View.VISIBLE);
			btRestart.setVisibility(View.INVISIBLE);
			ivCongratulations.setVisibility(View.INVISIBLE);
			mbNext.setVisibility(View.INVISIBLE);
			btPrevious.setVisibility(View.INVISIBLE);
			btMostrarRespuestaJuego.setVisibility(View.INVISIBLE);
			tvJuegoPalabraArriba.setVisibility(View.INVISIBLE);
			btDificultad.setVisibility(View.INVISIBLE);
			lyRespuestaJuego.setVisibility(View.INVISIBLE);
			tvJuegoCantidadPalabras.setText("No hay palabras problematicas!");
		} else {

			realmService.cambiarMostrarRespuestasPalabras(lista, false);

			palabrasDesordenadas.clear();

			for (Palabra p : lista) {
				palabrasDesordenadas.add(p);
			}

			Collections.shuffle(palabrasDesordenadas);
			// --------------------------------------------------------------

			//------- Esto es por si el usuario quita una palabra problematica y se resetea el juego
			if (cantidadItems > palabrasDesordenadas.size()) {
				cantidadItems = palabrasDesordenadas.size();
			}
			// ---------------------------------------------------------------------------------

			palabrasDesordenadas = palabrasDesordenadas.subList(0, cantidadItems);

			indice = 0;
			setearTitulo();

			btRestart.setVisibility(View.INVISIBLE);
			ivCongratulations.setVisibility(View.INVISIBLE);
			mbNext.setVisibility(View.VISIBLE);
			btPrevious.setVisibility(View.INVISIBLE);
			tvJuegoCantidadPalabras.setVisibility(View.VISIBLE);
			btMostrarRespuestaJuego.setVisibility(View.VISIBLE);
			tvJuegoPalabraArriba.setVisibility(View.VISIBLE);
			btDificultad.setVisibility(View.VISIBLE);
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
