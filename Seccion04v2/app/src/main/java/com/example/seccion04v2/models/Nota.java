package com.example.seccion04v2.models;

import com.example.seccion04v2.app.MyApplication;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Nota extends RealmObject {

	@PrimaryKey
	private int id;
	@Required
	private String descripcion;
	@Required
	private Date fechaCreacion;

	public Nota() {

	}

	public Nota(String descripcion) {
		this.id = MyApplication.notaId.incrementAndGet();
		this.descripcion = descripcion;
		this.fechaCreacion = new Date();
	}

	public int getId() {
		return id;
	}


	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

}
