package com.example.seccion10_tabs_tarea.Models;

public class Pais {

	private String nombre;
	private String codigo;

	public Pais() {
	}

	public Pais(String nombre, String codigo) {
		this.nombre = nombre;
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}
