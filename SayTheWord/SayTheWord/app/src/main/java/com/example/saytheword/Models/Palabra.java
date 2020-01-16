package com.example.saytheword.Models;

import com.example.saytheword.Services.RealmService;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Palabra extends RealmObject {

	@PrimaryKey
	private int id;
	private String palabraEsp;
	private String palabraIng;
	private String pronunciacion;
	private boolean mostrarRespuesta;
	private boolean palabraProblematica;

	public Palabra() {
	}

	public Palabra(String palabraIng, String palabraEsp, String pronunciacion) {
		this.id = RealmService.palabraId.incrementAndGet();
		this.palabraIng = palabraIng;
		this.palabraEsp = palabraEsp;
		this.pronunciacion = pronunciacion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPalabraEsp() {
		return palabraEsp;
	}

	public void setPalabraEsp(String palabraEsp) {
		this.palabraEsp = palabraEsp;
	}

	public String getPalabraIng() {
		return palabraIng;
	}

	public void setPalabraIng(String palabraIng) {
		this.palabraIng = palabraIng;
	}

	public String getPronunciacion() {
		return pronunciacion;
	}

	public void setPronunciacion(String pronunciacion) {
		this.pronunciacion = pronunciacion;
	}

	public boolean isMostrarRespuesta() {
		return mostrarRespuesta;
	}

	public void setMostrarRespuesta(boolean mostrarRespuesta) {
		this.mostrarRespuesta = mostrarRespuesta;
	}

	public boolean isPalabraProblematica() {
		return palabraProblematica;
	}

	public void setPalabraProblematica(boolean palabraProblematica) {
		this.palabraProblematica = palabraProblematica;
	}

}
