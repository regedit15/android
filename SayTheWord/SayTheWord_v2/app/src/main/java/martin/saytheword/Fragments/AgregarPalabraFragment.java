package martin.saytheword.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.textfield.TextInputEditText;

import martin.saytheword.Models.Palabra;
import martin.saytheword.R;

public class AgregarPalabraFragment extends BaseFragment {

	public AgregarPalabraFragment() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		final View view = inflater.inflate(R.layout.fragment_agregar_palabra, container, false);

		setearTitulo("Alta de Palabra");

		view.findViewById(R.id.btAltaGuardar).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				realmService.insertarPalabra(new Palabra(

						((TextInputEditText) view.findViewById(R.id.etAltaIngles)).getText().toString(),

						((TextInputEditText) view.findViewById(R.id.etAltaEspaniol)).getText().toString(),

						((TextInputEditText) view.findViewById(R.id.etAltaPronunciacion)).getText().toString()

				));

			}
		});

		view.findViewById(R.id.btAltaCancelar).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				volverAlFragmentAnterior();
			}
		});

		return view;
	}

}
