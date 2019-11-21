package martin.botoneraforgottera.Models;

import java.util.List;

public class Audio {

	private int id;
	private String nombre;
	private String descripcion;
	private List<Tag> tags;

	public Audio() {
	}

	public Audio(int id, String nombre, String descripcion) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public Audio(int id, String nombre, String descripcion, List<Tag> tags) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tags = tags;
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

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
}
