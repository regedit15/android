package com.example.seccion10_tabs_tarea.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.seccion10_tabs_tarea.Interfaces.OnPersonaCreada;
import com.example.seccion10_tabs_tarea.Models.Pais;
import com.example.seccion10_tabs_tarea.Models.Persona;
import com.example.seccion10_tabs_tarea.R;

import androidx.fragment.app.Fragment;

public class FromFragment extends Fragment {

	private OnPersonaCreada onPersonaCreada;
	private Button btCrearPersona;
	private EditText etNombre;
	private Spinner spinner;

	public FromFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


		View view = inflater.inflate(R.layout.fragment_from, container, false);
		etNombre = view.findViewById(R.id.etNombre);

		//--------------- Spinner
		spinner = view.findViewById(R.id.spPaises);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.paises, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		//-----------------------------------------

		//--------------- Boton crear persona
		btCrearPersona = view.findViewById(R.id.btCrearPersona);
		btCrearPersona.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				Persona persona = new Persona();
				persona.setNombre(etNombre.getText().toString());
				persona.setPais(new Pais(spinner.getSelectedItem().toString(), getResources().getStringArray(R.array.paises_values)[spinner.getSelectedItemPosition()]));

				onPersonaCreada.enviarPersona(persona);
			}
		});
		//-----------------------------------------

		return view;
	}

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);

		try {
			onPersonaCreada = (OnPersonaCreada) context;
		} catch (Exception e) {
			throw new ClassCastException(context.toString() + " debe implementar DataListener");
		}
	}
}
