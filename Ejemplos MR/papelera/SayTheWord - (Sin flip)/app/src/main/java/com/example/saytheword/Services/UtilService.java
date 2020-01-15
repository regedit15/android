package com.example.saytheword.Services;

import com.example.saytheword.Models.Palabra;

import java.util.ArrayList;
import java.util.List;

public class UtilService {

	private List<Palabra> palabras;

	public UtilService() {
		palabras = getPalabras();
	}

	public List<Palabra> getPalabras() {
		return new ArrayList<Palabra>() {{

			add(new Palabra("Car", "Auto", "Caa"));

			add(new Palabra("Saw", "Vió", "Soo"));

			add(new Palabra("Table", "Mesa", "Teibol"));

		}};
	}
}
