package com.example.seccion10_tabs_tarea.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.seccion10_tabs_tarea.Adapters.ListaPersonasAdapter;
import com.example.seccion10_tabs_tarea.Models.Pais;
import com.example.seccion10_tabs_tarea.Models.Persona;
import com.example.seccion10_tabs_tarea.R;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;

public class ListFragment extends Fragment {

	private ListView listView;
	private List<Persona> personas = new ArrayList<>();
	ListaPersonasAdapter listaPersonasAdapter;

	public ListFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_list, container, false);
		agregarPersonas();

		listView = view.findViewById(R.id.lvPersonas);
		listaPersonasAdapter = new ListaPersonasAdapter(getContext(), R.layout.persona_item, personas);
		listView.setAdapter(listaPersonasAdapter);
		return view;
	}

	private void agregarPersonas() {
		personas.add(new Persona("Pepe", new Pais("Argentina", "ARG")));
		personas.add(new Persona("Mercel", new Pais("España", "ESP")));
		personas.add(new Persona("Uber", new Pais("Uruguay", "URU")));
		personas.add(new Persona("Luacha", new Pais("Brazil", "BRZ")));
		personas.add(new Persona("Mane", new Pais("Estados Unidos", "EUA")));
		personas.add(new Persona("Luacha", new Pais("Australia", "AUS")));
	}

	public void agregarPersona(Persona persona) {
		personas.add(persona);
	}
}
