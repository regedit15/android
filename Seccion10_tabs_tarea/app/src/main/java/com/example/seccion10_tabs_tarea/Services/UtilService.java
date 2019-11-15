package com.example.seccion10_tabs_tarea.Services;

import com.example.seccion10_tabs_tarea.Models.Pais;
import com.example.seccion10_tabs_tarea.Models.Persona;
import com.example.seccion10_tabs_tarea.R;

import java.util.ArrayList;

public class UtilService {

	public int getBandera(String codigoPais) {
		int resultado;

		switch (codigoPais) {
			case "ARG":
				resultado = R.drawable.argentina;
				break;
			case "ESP":
				resultado = R.drawable.espania;
				break;
			case "BRZ":
				resultado = R.drawable.brazil;
				break;
			case "EUA":
				resultado = R.drawable.united_states;
				break;
			case "URU":
				resultado = R.drawable.uruguay;
				break;
			case "AUS":
				resultado = R.drawable.australia;
				break;
			default:
				throw new IllegalStateException("Unexpected value: " + codigoPais);
		}

		return resultado;
	}

	public ArrayList<Persona> agregarPersonas() {
		return new ArrayList<Persona>() {{
			add(new Persona("Pepe", new Pais("Argentina", "ARG")));
			add(new Persona("Mercel", new Pais("España", "ESP")));
			add(new Persona("Uber", new Pais("Uruguay", "URU")));
			add(new Persona("Luacha", new Pais("Brazil", "BRZ")));
			add(new Persona("Mane", new Pais("Estados Unidos", "EUA")));
			add(new Persona("Luacha", new Pais("Australia", "AUS")));
		}};
	}

	public ArrayList<Pais> getPaises() {
		return new ArrayList<Pais>() {{
			add(new Pais());
			add(new Pais("Argentina", "ARG"));
			add(new Pais("España", "ESP"));
			add(new Pais("Brazil", "BRZ"));
			add(new Pais("EEUU", "EUA"));
			add(new Pais("Uruguay", "URU"));
			add(new Pais("Australia", "AUS"));
		}};
	}
}
