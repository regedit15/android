package com.example.seccion09_fragment_tarea.models;

import java.io.Serializable;

//  Esto es para que no de error el intent.putExtra("mail", mails.get(position));
public class Mail implements Serializable {

	private String titulo;
	private String mensaje;
	private String mail;

	public Mail() {
	}

	public Mail(String titulo, String mensaje, String mail) {
		this.titulo = titulo;
		this.mensaje = mensaje;
		this.mail = mail;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
}
