package martin.saytheword.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Switch;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import martin.saytheword.Exceptions.GenericException;
import martin.saytheword.R;

public class JuegoConfiguracionInicial extends BaseFragment {

	private TextInputLayout etCantidadIntentosContenedor;
	private TextInputEditText etCantidadIntentos;
	private TextInputEditText etCantidadItems;
	private Switch swFaciles;
	private Switch swNormales;
	private Switch swDificiles;
	private MaterialButton btComenzarJuego;
	private RadioGroup rgEscrituraOVisualizacion;
	private RadioGroup rgPalabrasOVerbosIrregulares;

	public JuegoConfiguracionInicial() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		final View view = inflater.inflate(R.layout.fragment_juego_configuracion_inicial, container, false);

		setearTitulo("Configurar Juego");

		btComenzarJuego = view.findViewById(R.id.btComenzarJuego);
		etCantidadIntentos = view.findViewById(R.id.etCantidadIntentos);
		etCantidadItems = view.findViewById(R.id.etCantidadItems);
		swFaciles = view.findViewById(R.id.swFaciles);
		swNormales = view.findViewById(R.id.swNormales);
		swDificiles = view.findViewById(R.id.swDificiles);
		rgEscrituraOVisualizacion = view.findViewById(R.id.rgEscrituraOVisualizacion);
		rgPalabrasOVerbosIrregulares = view.findViewById(R.id.rgPalabrasOVerbosIrregulares);
		etCantidadIntentos = view.findViewById(R.id.etCantidadIntentos);
		etCantidadIntentosContenedor = view.findViewById(R.id.etCantidadIntentosContenedor);

		setearCantidadItems(utilService.getPalabras(true, true, true).size());

		btComenzarJuego.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					validar();

					if (rgEscrituraOVisualizacion.getCheckedRadioButtonId() == R.id.rdVisualizacion) {

						if (rgPalabrasOVerbosIrregulares.getCheckedRadioButtonId() == R.id.rbPalabras) {
							cambiarFragment(new JuegoPalabrasFragment(swFaciles.isChecked(), swNormales.isChecked(), swDificiles.isChecked(), Integer.parseInt(etCantidadItems.getText().toString())), R.id.frame_layout);

						} else if (rgPalabrasOVerbosIrregulares.getCheckedRadioButtonId() == R.id.rbVerbosIrregulares) {
							cambiarFragment(new JuegoVerbosIrregularesFragment(swFaciles.isChecked(), swNormales.isChecked(), swDificiles.isChecked(), Integer.parseInt(etCantidadItems.getText().toString())), R.id.frame_layout);

						}

					} else if (rgEscrituraOVisualizacion.getCheckedRadioButtonId() == R.id.rbEscritura) {
						if (rgPalabrasOVerbosIrregulares.getCheckedRadioButtonId() == R.id.rbPalabras) {
							cambiarFragment(new JuegoEscribirPalabra(

									Integer.parseInt(etCantidadIntentos.getText().toString()),

									Integer.parseInt(etCantidadItems.getText().toString()),

									swFaciles.isChecked(),

									swNormales.isChecked(),

									swDificiles.isChecked()

							), R.id.frame_layout);
						} else if (rgPalabrasOVerbosIrregulares.getCheckedRadioButtonId() == R.id.rbVerbosIrregulares) {
							cambiarFragment(new JuegoEscribirVerboIrregularFragment(

									Integer.parseInt(etCantidadIntentos.getText().toString()),

									Integer.parseInt(etCantidadItems.getText().toString()),

									swFaciles.isChecked(),

									swNormales.isChecked(),

									swDificiles.isChecked()

							), R.id.frame_layout);
						}
					}
				} catch (GenericException e) {
					mostrarPopup(e.getTitulo(), e.getMensaje());
				}
			}
		});

		rgEscrituraOVisualizacion.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {

				if (checkedId == R.id.rdVisualizacion) {
					etCantidadIntentosContenedor.setVisibility(View.GONE);
				} else if (checkedId == R.id.rbEscritura) {
					etCantidadIntentosContenedor.setVisibility(View.VISIBLE);
				}

				calcularCantidadItems();
			}
		});

		rgPalabrasOVerbosIrregulares.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				calcularCantidadItems();
			}
		});

		swFaciles.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				calcularCantidadItems();
			}
		});

		swNormales.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				calcularCantidadItems();
			}
		});

		swDificiles.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				calcularCantidadItems();
			}
		});

		return view;
	}

	private void validar() throws GenericException {

		int cantidadItems = 0;

		if (rgPalabrasOVerbosIrregulares.getCheckedRadioButtonId() == R.id.rbPalabras) {
			cantidadItems = utilService.getPalabras(swFaciles.isChecked(), swNormales.isChecked(), swDificiles.isChecked()).size();
		} else if (rgPalabrasOVerbosIrregulares.getCheckedRadioButtonId() == R.id.rbVerbosIrregulares) {
			cantidadItems = utilService.getVerbosIrregulares(swFaciles.isChecked(), swNormales.isChecked(), swDificiles.isChecked()).size();
		}

		int cantidadPalabras = Integer.parseInt(etCantidadItems.getText().toString());

		if (cantidadPalabras > cantidadItems) {

			String palabra;

			if (cantidadItems == 1) {
				palabra = " palabra";
			} else {
				palabra = " palabras";
			}

			throw new GenericException(

					"No hay tantas palabras!",

					new StringBuilder("Pusiste ").append(cantidadPalabras).append(" y solo hay ").append(cantidadItems).append(palabra).toString()

			);
		}

		if (cantidadItems == 0) {
			throw new GenericException("No hay ninguna palabra!");
		}
	}

	private void calcularCantidadItems() {

		int cantidad = 0;

		if (rgPalabrasOVerbosIrregulares.getCheckedRadioButtonId() == R.id.rbPalabras) {
			cantidad = utilService.getPalabras(swFaciles.isChecked(), swNormales.isChecked(), swDificiles.isChecked()).size();
		} else if (rgPalabrasOVerbosIrregulares.getCheckedRadioButtonId() == R.id.rbVerbosIrregulares) {
			cantidad = utilService.getVerbosIrregulares(swFaciles.isChecked(), swNormales.isChecked(), swDificiles.isChecked()).size();
		}

		setearCantidadItems(cantidad);
	}

	private void setearCantidadItems(int cantidad) {
		etCantidadItems.setText(String.valueOf(cantidad));
	}
}
