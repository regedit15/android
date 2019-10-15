package com.seccion04.seccion04_ciudades.models;

import com.seccion04.seccion04_ciudades.app.MyApplication;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Ciudad extends RealmObject {

	@PrimaryKey
	private int id;
	@Required
	private String nombre;
	@Required
	private String descripcion;
	@Required
	private String urlImagen;

	@Required
	private Float rating;

	public Ciudad() {
		this.id = MyApplication.ciudadId.incrementAndGet();
	}

	public Ciudad(String nombre, String descripcion, String urlImagen, Float rating) {
		this.id = MyApplication.ciudadId.incrementAndGet();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.urlImagen = urlImagen;
		this.rating = rating;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}
}
