package martin.botoneraforgottera.Models;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import martin.botoneraforgottera.Services.RealmService;

public class Audio extends RealmObject {

	@PrimaryKey
	private int id;
	private int idAudio;
	private String nombre;
	private String descripcion;
	private boolean favorito;

	private RealmList<Tag> tags;

	public Audio() {
	}

	public Audio(int idAudio, String nombre, String descripcion, RealmList<Tag> tags) {
		this.id = RealmService.audioId.incrementAndGet();
		this.idAudio = idAudio;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public Audio(int idAudio, String nombre, List<Tag> tagsList) {
		this.id = RealmService.audioId.incrementAndGet();
		this.idAudio = idAudio;
		this.nombre = nombre;
		this.tags = new RealmList<>();

		for (int i = 0; i > tagsList.size(); i++) {
			this.tags.add(tagsList.get(i));
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdAudio() {
		return idAudio;
	}

	public void setIdAudio(int idAudio) {
		this.idAudio = idAudio;
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

	public RealmList<Tag> getTags() {
		return tags;
	}

	public void setTags(RealmList<Tag> tags) {
		this.tags = tags;
	}

	public boolean isFavorito() {
		return favorito;
	}

	public void setFavorito(boolean favorito) {
		this.favorito = favorito;
	}
}
