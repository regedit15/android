package martin.saytheword.Fragments;

import static martin.saytheword.Services.UtilService.ESTADO_DIFICIL;
import static martin.saytheword.Services.UtilService.ESTADO_FACIL;
import static martin.saytheword.Services.UtilService.ESTADO_NORMAL;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.bumptech.glide.Glide;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import martin.saytheword.Models.VerboIrregular;
import martin.saytheword.R;

public class JuegoEscribirVerboIrregularFragment extends BaseFragment {

	private LinearLayout tablaImagenConBotones;
	private TextView tvJuegoCantidadPalabras;
	private TextView tvJuegoPalabraAdivinar;
	private TextInputEditText etRespuestaInfinitivo;
	private TextInputEditText etRespuestaPasado;
	private TextInputEditText etRespuestaParticipio;
	private TextView tvSolucionInfinitivo;
	private TextView tvSolucionPasado;
	private TextView tvSolucionParticipio;

	private TextView tvPronunciacionInfinitivo;
	private TextView tvPronunciacionPasado;
	private TextView tvPronunciacionParticipio;

	private TableLayout tablaRespuestas;
	private TextView tvCantidadIntentosRestantes;
	private MaterialButton btEvaluar;
	private MaterialButton btVolver;
	private MaterialButton btNext;
	private MaterialButton btRestart;
	private MaterialButton btDificultad;
	private ImageView ivImagenFinal;
	private ImageView ivRespuestaInfinitivo;
	private ImageView ivRespuestaPasado;
	private ImageView ivRespuestaParticipio;
	private ConstraintLayout lyContenedorGeneral;

	private List<VerboIrregular> verbosIrregularesDesordenados = new ArrayList<>();
	private int indice;
	private int cantidadIntentos;
	private int cantidadItems;
	private int cantidadIntentosFallidos;

	private boolean faciles;
	private boolean normales;
	private boolean dificiles;

	public JuegoEscribirVerboIrregularFragment(int cantidadIntentos, int cantidadItems, boolean faciles, boolean normales, boolean dificiles) {
		this.cantidadIntentos = cantidadIntentos;
		this.cantidadItems = cantidadItems;
		this.faciles = faciles;
		this.normales = normales;
		this.dificiles = dificiles;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_juego_escribir_verbo_irregular, container, false);

		setearTitulo("Juego Escribir Palabra");

		tablaImagenConBotones = view.findViewById(R.id.tablaImagenConBotones);
		tvJuegoCantidadPalabras = view.findViewById(R.id.tvJuegoCantidadPalabras);
		tvJuegoPalabraAdivinar = view.findViewById(R.id.tvJuegoPalabraAdivinar);
		etRespuestaInfinitivo = view.findViewById(R.id.etRespuestaInfinitivo);
		etRespuestaPasado = view.findViewById(R.id.etRespuestaPasado);
		etRespuestaParticipio = view.findViewById(R.id.etRespuestaParticipio);
		tvSolucionInfinitivo = view.findViewById(R.id.tvSolucionInfinitivo);
		tvSolucionPasado = view.findViewById(R.id.tvSolucionPasado);
		tvSolucionParticipio = view.findViewById(R.id.tvSolucionParticipio);
		tvPronunciacionInfinitivo = view.findViewById(R.id.tvPronunciacionInfinitivo);
		tvPronunciacionPasado = view.findViewById(R.id.tvPronunciacionPasado);
		tvPronunciacionParticipio = view.findViewById(R.id.tvPronunciacionParticipio);
		tablaRespuestas = view.findViewById(R.id.tablaRespuestas);
		btNext = view.findViewById(R.id.btNext);
		btEvaluar = view.findViewById(R.id.btEvaluar);
		btRestart = view.findViewById(R.id.btRestart);
		btDificultad = view.findViewById(R.id.btDificultad);
		tvCantidadIntentosRestantes = view.findViewById(R.id.tvCantidadIntentosRestantes);
		btVolver = view.findViewById(R.id.btVolver);
		lyContenedorGeneral = view.findViewById(R.id.lyContenedorGeneral);
		ivImagenFinal = view.findViewById(R.id.ivImagenFinal);
		ivRespuestaInfinitivo = view.findViewById(R.id.ivRespuestaInfinitivo);
		ivRespuestaPasado = view.findViewById(R.id.ivRespuestaPasado);
		ivRespuestaParticipio = view.findViewById(R.id.ivRespuestaParticipio);

		inicializarJuego();

		btEvaluar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				boolean respuestaInfinitivo = utilService.compararPalabra(etRespuestaInfinitivo.getText().toString(), verbosIrregularesDesordenados.get(indice).getInfinitivo());
				boolean respuestaPasado = utilService.compararPalabra(etRespuestaPasado.getText().toString(), verbosIrregularesDesordenados.get(indice).getPasado());
				boolean respuestaParticipio = utilService.compararPalabra(etRespuestaParticipio.getText().toString(), verbosIrregularesDesordenados.get(indice).getParticipio());

				if (respuestaInfinitivo && respuestaPasado && respuestaParticipio) {
					siguiente();
				} else {
					cantidadIntentosFallidos++;

					if (cantidadIntentosFallidos == cantidadIntentos) {
						lyContenedorGeneral.setVisibility(View.INVISIBLE);
						tablaImagenConBotones.setVisibility(View.VISIBLE);
						Glide.with(getContext()).load(R.drawable.game_over).into(ivImagenFinal);
					} else {

						tablaRespuestas.setVisibility(View.VISIBLE);

						tvSolucionInfinitivo.setText(verbosIrregularesDesordenados.get(indice).getInfinitivo());
						tvSolucionPasado.setText(verbosIrregularesDesordenados.get(indice).getPasado());
						tvSolucionParticipio.setText(verbosIrregularesDesordenados.get(indice).getParticipio());

						tvPronunciacionInfinitivo.setText(verbosIrregularesDesordenados.get(indice).getPronunciacion());
						tvPronunciacionPasado.setText(verbosIrregularesDesordenados.get(indice).getPasadoPronunciacion());
						tvPronunciacionParticipio.setText(verbosIrregularesDesordenados.get(indice).getParticipioPronunciacion());


						if (respuestaInfinitivo) {
							Glide.with(getContext()).load(R.drawable.ic_iconfinder_sign_check).into(ivRespuestaInfinitivo);
						} else {
							Glide.with(getContext()).load(R.drawable.ic_iconfinder_sign_error).into(ivRespuestaInfinitivo);
						}
						if (respuestaPasado) {
							Glide.with(getContext()).load(R.drawable.ic_iconfinder_sign_check).into(ivRespuestaPasado);
						} else {
							Glide.with(getContext()).load(R.drawable.ic_iconfinder_sign_error).into(ivRespuestaPasado);
						}
						if (respuestaParticipio) {
							Glide.with(getContext()).load(R.drawable.ic_iconfinder_sign_check).into(ivRespuestaParticipio);
						} else {
							Glide.with(getContext()).load(R.drawable.ic_iconfinder_sign_error).into(ivRespuestaParticipio);
						}


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
				realmService.cambiarDificultadVerboIrregular(verbosIrregularesDesordenados.get(indice));
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
		tablaRespuestas.setVisibility(View.INVISIBLE);
		etRespuestaInfinitivo.setText("");
		etRespuestaParticipio.setText("");
		etRespuestaPasado.setText("");

		etRespuestaInfinitivo.requestFocus();
	}

	private void setearTitulo() {
		tvJuegoCantidadPalabras.setText(new StringBuilder(Integer.toString(indice + 1)).append(" de ").append(verbosIrregularesDesordenados.size()).toString());
	}

	private void continuarJuego() {

		if (indice == verbosIrregularesDesordenados.size()) {
			lyContenedorGeneral.setVisibility(View.INVISIBLE);
			tablaImagenConBotones.setVisibility(View.VISIBLE);
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
		setearColorDificultad();
	}

	private void setearColorDificultad() {
		switch (verbosIrregularesDesordenados.get(indice).getDificultad()) {
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
		List<VerboIrregular> lista = utilService.getVerbosIrregulares(faciles, normales, dificiles);

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

		tvJuegoCantidadPalabras.setVisibility(View.VISIBLE);
		tvJuegoPalabraAdivinar.setVisibility(View.VISIBLE);
		lyContenedorGeneral.setVisibility(View.VISIBLE);
		tablaRespuestas.setVisibility(View.VISIBLE);
		btEvaluar.setVisibility(View.VISIBLE);
		btDificultad.setVisibility(View.VISIBLE);

		tablaImagenConBotones.setVisibility(View.INVISIBLE);
		tablaRespuestas.setVisibility(View.INVISIBLE);
		btNext.setVisibility(View.INVISIBLE);

		setearTextoArribaYcolorDeBoton();

		etRespuestaInfinitivo.setText("");
		etRespuestaParticipio.setText("");
		etRespuestaPasado.setText("");
	}
}
