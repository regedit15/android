package martin.ingles.saytheword.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import androidx.constraintlayout.widget.ConstraintLayout;
import martin.ingles.saytheword.Models.Palabra;
import martin.ingles.saytheword.R;

import static martin.ingles.saytheword.Services.UtilService.ESTADO_DIFICIL;
import static martin.ingles.saytheword.Services.UtilService.ESTADO_FACIL;
import static martin.ingles.saytheword.Services.UtilService.ESTADO_NORMAL;

public class JuegoEscribirPalabra extends BaseFragment {

	private TextView tvJuegoCantidadPalabras;
	private TextView tvJuegoPalabraAdivinar;
	private TextView etRespuesta;
	private TextInputLayout etRespuestaContenedor;
	private TextView tvCantidadIntentosRestantes;
	private TextView tvSolucion;
	private MaterialButton btEvaluar;
	private MaterialButton btVolver;
	private MaterialButton btNext;
	private MaterialButton btPrevious;
	private MaterialButton btRestart;
	private MaterialButton btDificultad;
	private ConstraintLayout lyRespuestaJuego;
	private ImageView ivCongratulations;

	private List<Palabra> palabrasDesordenadas = new ArrayList<>();
	private int indice;
	private int cantidadIntentos;
	private int cantidadItems;
	private int cantidadIntentosFallidos;
	private boolean faciles;
	private boolean normales;
	private boolean dificiles;

	public JuegoEscribirPalabra(int cantidadIntentos, int cantidadItems, boolean faciles, boolean normales, boolean dificiles) {
		this.cantidadIntentos = cantidadIntentos;
		this.cantidadItems = cantidadItems;
		this.faciles = faciles;
		this.normales = normales;
		this.dificiles = dificiles;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_juego_escribir_palabra, container, false);

		setearTitulo("Juego Escribir Palabra");

		tvJuegoCantidadPalabras = view.findViewById(R.id.tvJuegoCantidadPalabras);
		tvJuegoPalabraAdivinar = view.findViewById(R.id.tvJuegoPalabraAdivinar);
		etRespuesta = view.findViewById(R.id.etRespuesta);
		etRespuestaContenedor = view.findViewById(R.id.etRespuestaContenedor);
		tvSolucion = view.findViewById(R.id.tvSolucion);
		btNext = view.findViewById(R.id.btNext);
		btEvaluar = view.findViewById(R.id.btEvaluar);
		btPrevious = view.findViewById(R.id.btPrevious);
		btRestart = view.findViewById(R.id.btRestart);
		btDificultad = view.findViewById(R.id.btDificultad);
		lyRespuestaJuego = view.findViewById(R.id.lyRespuestaJuego);
		ivCongratulations = view.findViewById(R.id.ivCongratulations);
		tvCantidadIntentosRestantes = view.findViewById(R.id.tvCantidadIntentosRestantes);
		btVolver = view.findViewById(R.id.btVolver);

		inicializarJuego();

		btEvaluar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				if (utilService.compararPalabra(etRespuesta.getText().toString(), palabrasDesordenadas.get(indice).getPalabraIng())) {
					siguiente();
				} else {
					cantidadIntentosFallidos++;

					if (cantidadIntentosFallidos == cantidadIntentos) {
						//juego perdido
						tvJuegoCantidadPalabras.setVisibility(View.INVISIBLE);
						tvJuegoPalabraAdivinar.setVisibility(View.INVISIBLE);
						tvSolucion.setVisibility(View.INVISIBLE);
						btNext.setVisibility(View.INVISIBLE);
						btEvaluar.setVisibility(View.INVISIBLE);
						btPrevious.setVisibility(View.INVISIBLE);
						btRestart.setVisibility(View.VISIBLE);
						btDificultad.setVisibility(View.INVISIBLE);
						lyRespuestaJuego.setVisibility(View.INVISIBLE);
						etRespuestaContenedor.setVisibility(View.INVISIBLE);
						ivCongratulations.setVisibility(View.VISIBLE);
						btVolver.setVisibility(View.VISIBLE);

						Glide.with(getContext()).load(R.drawable.game_over).into(ivCongratulations);
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
			}
		});

		btDificultad.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				realmService.cambiarDificultadPalabra(palabrasDesordenadas.get(indice));
				setearColorDificultad();
			}
		});

		btVolver.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				cambiarFragment(new JuegoConfiguracionInicial(), R.id.frame_layout);
			}
		});

		return view;
	}

	private void siguiente() {
		indice++;
		continuarJuego();
		lyRespuestaJuego.setVisibility(View.INVISIBLE);
		etRespuesta.setText("");
	}

	private void setearTitulo() {
		tvJuegoCantidadPalabras.setText(new StringBuilder(Integer.toString(indice + 1)).append(" de ").append(palabrasDesordenadas.size()).toString());
	}

	private void continuarJuego() {

		if (indice == palabrasDesordenadas.size()) {
			tvJuegoCantidadPalabras.setVisibility(View.INVISIBLE);
			tvJuegoPalabraAdivinar.setVisibility(View.INVISIBLE);
			tvSolucion.setVisibility(View.INVISIBLE);
			btNext.setVisibility(View.INVISIBLE);
			btEvaluar.setVisibility(View.INVISIBLE);
			btPrevious.setVisibility(View.INVISIBLE);
			btRestart.setVisibility(View.VISIBLE);
			btDificultad.setVisibility(View.INVISIBLE);
			lyRespuestaJuego.setVisibility(View.INVISIBLE);
			etRespuestaContenedor.setVisibility(View.INVISIBLE);
			btEvaluar.setVisibility(View.INVISIBLE);
			ivCongratulations.setVisibility(View.VISIBLE);
			btVolver.setVisibility(View.VISIBLE);

			Glide.with(getContext()).load(R.drawable.congratulation).into(ivCongratulations);
		} else {
			btNext.setVisibility(View.INVISIBLE);
			btEvaluar.setVisibility(View.VISIBLE);
			setearTextoArribaYcolorDeBoton();
			setearTitulo();
		}
	}

	private void setearTextoArribaYcolorDeBoton() {
		tvJuegoPalabraAdivinar.setText(palabrasDesordenadas.get(indice).getPalabraEsp());
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
		cantidadIntentosFallidos = 0;
		setearTitulo();


		tvJuegoCantidadPalabras.setVisibility(View.VISIBLE);
		tvJuegoPalabraAdivinar.setVisibility(View.VISIBLE);
		etRespuestaContenedor.setVisibility(View.VISIBLE);
		tvSolucion.setVisibility(View.VISIBLE);

		btPrevious.setVisibility(View.INVISIBLE);
		btVolver.setVisibility(View.INVISIBLE);
		btNext.setVisibility(View.INVISIBLE);
		etRespuestaContenedor.setVisibility(View.VISIBLE);
		btRestart.setVisibility(View.INVISIBLE);
		lyRespuestaJuego.setVisibility(View.INVISIBLE);
		ivCongratulations.setVisibility(View.INVISIBLE);
		btEvaluar.setVisibility(View.VISIBLE);
		btDificultad.setVisibility(View.VISIBLE);

		setearTextoArribaYcolorDeBoton();

		etRespuesta.setText("");
	}
}
