package martin.ingles.saytheword.Exceptions;

public class GenericException extends Exception {

	private String titulo;
	private String mensaje;

	public GenericException(String titulo) {
		this.titulo = titulo;
	}

	public GenericException(String titulo, String mensaje) {
		this.titulo = titulo;
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}

