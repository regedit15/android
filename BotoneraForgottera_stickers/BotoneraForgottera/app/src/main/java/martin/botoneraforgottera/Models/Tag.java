package martin.botoneraforgottera.Models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import martin.botoneraforgottera.Services.RealmService;

public class Tag extends RealmObject {

	@PrimaryKey
	private int id;
	private String nombre;

	public Tag() {
	}

	public Tag(String nombre) {
		this.id = RealmService.tagId.incrementAndGet();
		this.nombre = nombre;
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
}
