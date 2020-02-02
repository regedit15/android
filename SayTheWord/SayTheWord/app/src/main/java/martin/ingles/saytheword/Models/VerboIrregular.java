package martin.ingles.saytheword.Models;

import martin.ingles.saytheword.Services.RealmService;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class VerboIrregular extends RealmObject {

	@PrimaryKey
	private int id;
	private String infinitivo;
	private String pronunciacion;
	private String traduccion;

	private String pasado;
	private String pasadoPronunciacion;

	private String participio;
	private String participioPronunciacion;

	private boolean mostrarRespuesta;
	private boolean palabraProblematica;

	public VerboIrregular() {
	}

	public VerboIrregular(String infinitivo, String pronunciacion, String traduccion, String pasado, String pasadoPronunciacion, String participio, String participioPronunciacion) {
		this.id = RealmService.palabraId.incrementAndGet();
		this.infinitivo = infinitivo;
		this.pronunciacion = pronunciacion;
		this.traduccion = traduccion;
		this.pasado = pasado;
		this.pasadoPronunciacion = pasadoPronunciacion;
		this.participio = participio;
		this.participioPronunciacion = participioPronunciacion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInfinitivo() {
		return infinitivo;
	}

	public void setInfinitivo(String infinitivo) {
		this.infinitivo = infinitivo;
	}

	public String getPronunciacion() {
		return pronunciacion;
	}

	public void setPronunciacion(String pronunciacion) {
		this.pronunciacion = pronunciacion;
	}

	public String getTraduccion() {
		return traduccion;
	}

	public void setTraduccion(String traduccion) {
		this.traduccion = traduccion;
	}

	public String getPasado() {
		return pasado;
	}

	public void setPasado(String pasado) {
		this.pasado = pasado;
	}

	public String getPasadoPronunciacion() {
		return pasadoPronunciacion;
	}

	public void setPasadoPronunciacion(String pasadoPronunciacion) {
		this.pasadoPronunciacion = pasadoPronunciacion;
	}

	public String getParticipio() {
		return participio;
	}

	public void setParticipio(String participio) {
		this.participio = participio;
	}

	public String getParticipioPronunciacion() {
		return participioPronunciacion;
	}

	public void setParticipioPronunciacion(String participioPronunciacion) {
		this.participioPronunciacion = participioPronunciacion;
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
