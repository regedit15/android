package com.example.seccion10_tabs_tarea.Models;

public class Persona {

	private String nombre;
	private String pais;

	public Persona() {
	}

	public Persona(String nombre, String pais) {
		this.nombre = nombre;
		this.pais = pais;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
}
