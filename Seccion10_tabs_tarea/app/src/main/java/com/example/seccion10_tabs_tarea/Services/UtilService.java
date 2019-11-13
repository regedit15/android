package com.example.seccion10_tabs_tarea.Services;

import com.example.seccion10_tabs_tarea.R;

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
				resultado = R.drawable.argentina;
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
}
