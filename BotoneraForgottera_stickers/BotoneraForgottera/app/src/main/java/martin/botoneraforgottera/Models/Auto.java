package martin.botoneraforgottera.Models;

public class Auto extends Vehiculo {

	private String nombre;

	public Auto() {
		toString();
	}

	public Auto(String nombre) {
		toString();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
