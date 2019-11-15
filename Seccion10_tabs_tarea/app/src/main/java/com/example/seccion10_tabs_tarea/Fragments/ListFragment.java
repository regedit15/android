package com.example.seccion10_tabs_tarea.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.seccion10_tabs_tarea.Adapters.ListaPersonasAdapter;
import com.example.seccion10_tabs_tarea.Models.Persona;
import com.example.seccion10_tabs_tarea.R;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends BaseFragment {

	private ListView listView;
	private List<Persona> personas = new ArrayList<>();
	private ListaPersonasAdapter listaPersonasAdapter;

	public ListFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_list, container, false);
		personas = utilService.agregarPersonas();

		listView = view.findViewById(R.id.lvPersonas);
		listaPersonasAdapter = new ListaPersonasAdapter(getContext(), R.layout.persona_item, personas);
		listView.setAdapter(listaPersonasAdapter);
		return view;
	}

	public void agregarPersona(Persona persona) {
		personas.add(persona);
		listaPersonasAdapter.notifyDataSetChanged();
	}
}
