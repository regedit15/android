package com.example.saytheword.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.saytheword.Models.Palabra;
import com.example.saytheword.R;
import com.google.android.material.textfield.TextInputEditText;

public class AgregarPalabraFragment extends BaseFragment {

	public AgregarPalabraFragment() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		final View view = inflater.inflate(R.layout.fragment_agregar_palabra, container, false);

		setearTitulo("Alta Palabra");

		view.findViewById(R.id.btAltaGuardar).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				realmService.insertarPalabra(new Palabra(

						((TextInputEditText) view.findViewById(R.id.etAltaIngles)).getText().toString(),

						((TextInputEditText) view.findViewById(R.id.etAltaEspaniol)).getText().toString(),

						((TextInputEditText) view.findViewById(R.id.etAltaPronunciacion)).getText().toString()

				));

				if (getFragmentManager().getBackStackEntryCount() > 0) {
					getFragmentManager().popBackStackImmediate();
				}
				// getFragmentManager().popBackStack();
			}
		});

		view.findViewById(R.id.btAltaCancelar).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				if (getFragmentManager().getBackStackEntryCount() > 0) {
					getFragmentManager().popBackStackImmediate();
				}
			}
		});

		return view;
	}

}
