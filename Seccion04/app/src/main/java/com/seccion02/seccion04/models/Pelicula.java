package com.seccion02.seccion04.models;

public class Pelicula {

	private String nombre;
	private String descripcion;
	private int imagen;
	private int cantidad;
	public static final int LIMITE_CANTIDAD = 10;
	public static final int LIMITE_CANTIDAD_DEFAULT = 0;

	public Pelicula(String nombre, String descripcion, int imagen) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.cantidad = 0;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getImagen() {
		return imagen;
	}

	public void setImagen(int imagen) {
		this.imagen = imagen;
	}

	public void agregarCantidad(int cantidad) {
		if (cantidad < LIMITE_CANTIDAD) {
			this.cantidad = +cantidad;
		}
	}

	public void resetearCantidad() {
		cantidad = LIMITE_CANTIDAD_DEFAULT;
	}
}
