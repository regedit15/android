package martin.botoneraforgottera.Models;

public class Vehiculo {

	private String tipo;

	public Vehiculo() {
		toString();
	}

	public Vehiculo(String tipo) {
		toString();
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
