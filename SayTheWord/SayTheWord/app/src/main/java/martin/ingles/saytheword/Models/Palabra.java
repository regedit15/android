package martin.ingles.saytheword.Models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import martin.ingles.saytheword.Services.RealmService;

public class Palabra extends RealmObject {

	@PrimaryKey
	private int id;
	private String palabraEsp;
	private String palabraIng;
	private String pronunciacion;
	private boolean mostrarRespuesta;
	private int dificultad;

	public Palabra() {
	}

	public Palabra(String palabraIng, String palabraEsp, String pronunciacion) {
		this.id = RealmService.palabraId.incrementAndGet();
		this.palabraIng = palabraIng;
		this.palabraEsp = palabraEsp;
		this.pronunciacion = pronunciacion;
		this.dificultad = 3;
	}

	public Palabra(String palabraIng, String palabraEsp, String pronunciacion, int dificultad) {
		this.id = RealmService.palabraId.incrementAndGet();
		this.palabraIng = palabraIng;
		this.palabraEsp = palabraEsp;
		this.pronunciacion = pronunciacion;
		this.dificultad = dificultad;
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

	public int getDificultad() {
		return dificultad;
	}

	public void setDificultad(int dificultad) {
		this.dificultad = dificultad;
	}

}
