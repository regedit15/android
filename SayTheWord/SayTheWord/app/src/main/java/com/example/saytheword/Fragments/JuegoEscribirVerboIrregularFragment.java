package com.example.saytheword.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.saytheword.Models.VerboIrregular;
import com.example.saytheword.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import androidx.constraintlayout.widget.ConstraintLayout;

public class JuegoEscribirVerboIrregularFragment extends BaseFragment {

	private TextView tvJuegoCantidadPalabras;
	private TextView tvJuegoPalabraAdivinar;

	private TextInputEditText etRespuestaInfinitivo;
	private TextInputEditText etRespuestaPasado;
	private TextInputEditText etRespuestaParticipio;
	private TextView tvSolucionInfinitivo;
	private TextView tvSolucionPasado;
	private TextView tvSolucionParticipio;

	private TableLayout tablaRespuestas;
	private TextView tvCantidadIntentosRestantes;
	// private TextView tvSolucion;
	private MaterialButton btEvaluar;
	private MaterialButton btVolver;
	private MaterialButton btNext;
	// private MaterialButton btPrevious;
	private MaterialButton btRestart;
	private MaterialButton btPalabraProblematica;
	// private ConstraintLayout lyRespuestaJuego;
	private ImageView ivImagenFinal;

	private ConstraintLayout lyContenedorGeneral;

	private List<VerboIrregular> verbosIrregularesDesordenados = new ArrayList<>();
	private int indice;
	private int cantidadIntentos;
	private int cantidadItems;
	private int cantidadIntentosFallidos;
	private boolean soloPalabrasProblematicas;

	public JuegoEscribirVerboIrregularFragment(int cantidadIntentos, int cantidadItems, boolean soloPalabrasProblematicas) {
		this.cantidadIntentos = cantidadIntentos;
		this.cantidadItems = cantidadItems;
		this.soloPalabrasProblematicas = soloPalabrasProblematicas;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_juego_escribir_verbo_irregular, container, false);

		setearTitulo("Juego Escribir Palabra");

		tvJuegoCantidadPalabras = view.findViewById(R.id.tvJuegoCantidadPalabras);
		tvJuegoPalabraAdivinar = view.findViewById(R.id.tvJuegoPalabraAdivinar);

		etRespuestaInfinitivo = view.findViewById(R.id.etRespuesta);
		etRespuestaPasado = view.findViewById(R.id.etRespuesta);
		etRespuestaParticipio = view.findViewById(R.id.etRespuesta);
		tvSolucionInfinitivo = view.findViewById(R.id.tvSolucionInfinitivo);
		tvSolucionPasado = view.findViewById(R.id.tvSolucionPasado);
		tvSolucionParticipio = view.findViewById(R.id.tvSolucionParticipio);

		tablaRespuestas = view.findViewById(R.id.tablaRespuestas);
		btNext = view.findViewById(R.id.btNext);
		btEvaluar = view.findViewById(R.id.btEvaluar);
		btRestart = view.findViewById(R.id.btRestart);
		btPalabraProblematica = view.findViewById(R.id.btPalabraProblematica);
		ivImagenFinal = view.findViewById(R.id.ivImagenFinal);
		tvCantidadIntentosRestantes = view.findViewById(R.id.tvCantidadIntentosRestantes);
		btVolver = view.findViewById(R.id.btVolver);
		lyContenedorGeneral = view.findViewById(R.id.lyContenedorGeneral);


		inicializarJuego();

		btEvaluar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				if (

						etRespuestaInfinitivo.getText().toString().equalsIgnoreCase(verbosIrregularesDesordenados.get(indice).getInfinitivo())

								&& etRespuestaPasado.getText().toString().equalsIgnoreCase(verbosIrregularesDesordenados.get(indice).getPasado())

								&& etRespuestaParticipio.getText().toString().equalsIgnoreCase(verbosIrregularesDesordenados.get(indice).getParticipio())

				) {
					siguiente();
				} else {
					cantidadIntentosFallidos++;

					if (cantidadIntentosFallidos == cantidadIntentos) {
						//juego perdido
						// tvJuegoCantidadPalabras.setVisibility(View.INVISIBLE);
						// tvJuegoPalabraAdivinar.setVisibility(View.INVISIBLE);
						// tvSolucion.setVisibility(View.INVISIBLE);
						// btNext.setVisibility(View.INVISIBLE);
						// btEvaluar.setVisibility(View.INVISIBLE);
						// btPrevious.setVisibility(View.INVISIBLE);
						// btRestart.setVisibility(View.VISIBLE);
						// btPalabraProblematica.setVisibility(View.INVISIBLE);
						// lyRespuestaJuego.setVisibility(View.INVISIBLE);
						// tablaRespuestas.setVisibility(View.INVISIBLE);
						// ivImagenFinal.setVisibility(View.VISIBLE);

						lyContenedorGeneral.setVisibility(View.VISIBLE);

						Glide.with(getContext()).load(R.drawable.game_over).into(ivImagenFinal);
					} else {

						tablaRespuestas.setVisibility(View.VISIBLE);

						// tvSolucion.setText(new StringBuilder("Escribiste \"").append(etRespuesta.getText().toString()).append("\" y la respuesta correcta era \"").append(verbosIrregularesDesordenados.get(indice).getPalabraIng()).append("\"").toString());
						tvSolucionInfinitivo.setText(verbosIrregularesDesordenados.get(indice).getInfinitivo());
						tvSolucionPasado.setText(verbosIrregularesDesordenados.get(indice).getPasado());
						tvSolucionParticipio.setText(verbosIrregularesDesordenados.get(indice).getParticipio());


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

		btPalabraProblematica.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				realmService.cambiarPalabraProblematicaVerbosIrregulares(verbosIrregularesDesordenados.get(indice));
				setearColorPalabraProblematica();
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
		tablaRespuestas.setVisibility(View.INVISIBLE);
		etRespuestaInfinitivo.setText("");
		etRespuestaParticipio.setText("");
		etRespuestaPasado.setText("");
	}

	private void setearTitulo() {
		tvJuegoCantidadPalabras.setText(new StringBuilder(Integer.toString(indice + 1)).append(" de ").append(verbosIrregularesDesordenados.size()).toString());
	}

	private void continuarJuego() {

		if (indice == verbosIrregularesDesordenados.size()) {
			lyContenedorGeneral.setVisibility(View.INVISIBLE);
			Glide.with(getContext()).load(R.drawable.congratulation).into(ivImagenFinal);
		} else {
			btNext.setVisibility(View.INVISIBLE);
			btEvaluar.setVisibility(View.VISIBLE);
			setearTextoArribaYcolorDeBoton();
			setearTitulo();
		}
	}

	private void setearTextoArribaYcolorDeBoton() {
		tvJuegoPalabraAdivinar.setText(verbosIrregularesDesordenados.get(indice).getTraduccion());
		setearColorPalabraProblematica();
	}

	private void setearColorPalabraProblematica() {
		if (verbosIrregularesDesordenados.get(indice).isPalabraProblematica()) {
			btPalabraProblematica.setIconResource(R.drawable.ic_angry);
			btPalabraProblematica.setBackgroundTintList(getResources().getColorStateList(R.color.colorPalabraProblematica));
		} else {
			btPalabraProblematica.setIconResource(R.drawable.ic_smile);
			btPalabraProblematica.setBackgroundTintList(getResources().getColorStateList(R.color.colorPalabraBuena));
		}
	}

	private void inicializarJuego() {

		// ------------- Se hace esto porque si lo igualo a utilService.getLista() da error
		List<VerboIrregular> lista = utilService.getVerbosIrregulares(soloPalabrasProblematicas);

		realmService.cambiarMostrarRespuestasVerbosIrregulares(lista, false);

		verbosIrregularesDesordenados.clear();

		for (VerboIrregular x : lista) {
			verbosIrregularesDesordenados.add(x);
		}

		Collections.shuffle(verbosIrregularesDesordenados);
		// --------------------------------------------------------------

		//------- Esto es por si el usuario quita una palabra problematica y se resetea el juego
		if (cantidadItems > verbosIrregularesDesordenados.size()) {
			cantidadItems = verbosIrregularesDesordenados.size();
		}
		// ---------------------------------------------------------------------------------

		verbosIrregularesDesordenados = verbosIrregularesDesordenados.subList(0, cantidadItems);

		indice = 0;
		cantidadIntentosFallidos = 0;
		setearTitulo();

		// tvJuegoCantidadPalabras.setVisibility(View.VISIBLE);
		// tvJuegoPalabraAdivinar.setVisibility(View.VISIBLE);
		lyContenedorGeneral.setVisibility(View.VISIBLE);
		tablaRespuestas.setVisibility(View.VISIBLE);
		btEvaluar.setVisibility(View.VISIBLE);
		btPalabraProblematica.setVisibility(View.VISIBLE);

		btRestart.setVisibility(View.INVISIBLE);
		tablaRespuestas.setVisibility(View.INVISIBLE);
		btVolver.setVisibility(View.INVISIBLE);
		ivImagenFinal.setVisibility(View.INVISIBLE);
		btNext.setVisibility(View.INVISIBLE);

		setearTextoArribaYcolorDeBoton();
	}

}
