package com.example.saytheword.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

import com.example.saytheword.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class JuegoConfiguracionInicial extends BaseFragment {

	public JuegoConfiguracionInicial() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		final View view = inflater.inflate(R.layout.fragment_juego_configuracion_inicial, container, false);


		MaterialButton btComenzarJuego = view.findViewById(R.id.btComenzarJuego);
		// final RadioGroup rgModoDeJuego = view.findViewById(R.id.rgModoDeJuego);
		final TextInputEditText etCantidadIntentos = view.findViewById(R.id.etCantidadIntentos);
		final Switch swSoloPalabrasProblematicas = view.findViewById(R.id.swSoloPalabrasProblematicas);

		btComenzarJuego.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				// String juegoTipo = null;

				// switch (rgModoDeJuego.getCheckedRadioButtonId()) {
				// 	case R.id.rbModoJuegoIngEsp:
				// 		juegoTipo = JUEGO_TIPO_TRADUCCION_INGLES_ESPANIOL;
				// 		break;
				// 	case R.id.rbModoJuegoEspIng:
				// 		juegoTipo = JUEGO_TIPO_TRADUCCION_ESPANIOL_INGLES;
				// 		break;
				// }

						// juegoTipo,
				cambiarFragment(new JuegoEscribirPalabra(

						Integer.parseInt(etCantidadIntentos.getText().toString()),

						swSoloPalabrasProblematicas.isChecked()

				), R.id.frame_layout);
			}
		});

		return view;
	}

}
