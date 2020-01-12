package com.example.saytheword.Models;

public class Palabra {

	private String palabraEsp;
	private String palabraIng;
	private String pronunciacion;
	private boolean mostrarRespuesta;

	public Palabra() {
	}

	public Palabra(String palabraEsp, String palabraIng, String pronunciacion) {
		this.palabraEsp = palabraEsp;
		this.palabraIng = palabraIng;
		this.pronunciacion = pronunciacion;
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

	public void cambiarMostrarRespuesta() {
		mostrarRespuesta = !mostrarRespuesta;
	}
}
