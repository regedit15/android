package com.example.seccion10_tabs_tarea.Models;

public class Persona {

	private String nombre;
	private Pais pais;

	public Persona() {
	}

	public Persona(String nombre, Pais pais) {
		this.nombre = nombre;
		this.pais = pais;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
}
