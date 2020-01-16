package com.example.saytheword.Services;

import android.content.Context;

import com.example.saytheword.Models.Palabra;
import com.example.saytheword.Models.VerboIrregular;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.Sort;

public class RealmService {

	public static AtomicInteger palabraId = new AtomicInteger();
	public static AtomicInteger verboIrregularId = new AtomicInteger();

	public void setearConfiguracion(Context context) {

		// ----- Setear configuracion
		Realm.init(context);
		RealmConfiguration config = new RealmConfiguration.Builder().build();
		Realm.setDefaultConfiguration(config);
		//-----------------

		Realm realm = Realm.getDefaultInstance();
		palabraId = getIdByTabla(realm, Palabra.class);
		verboIrregularId = getIdByTabla(realm, VerboIrregular.class);
		realm.close();
	}

	public <T extends RealmObject> AtomicInteger getIdByTabla(Realm realm, Class<T> clase) {
		RealmResults<T> results = realm.where(clase).findAll();

		return (results.size() > 0) ? new AtomicInteger(results.max("id").intValue()) : new AtomicInteger();
	}

	// -------------------------- Palabra
	public List<Palabra> getPalabras() {
		return Realm.getDefaultInstance().where(Palabra.class).sort("palabraIng", Sort.ASCENDING).findAll();
	}

	public List<Palabra> getPalabrasProblematicas() {
		return Realm.getDefaultInstance().where(Palabra.class).equalTo("palabraProblematica", true).sort("palabraIng", Sort.ASCENDING).findAll();
	}

	public void insertarPalabras(final List<Palabra> palabras) {
		Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
			@Override
			public void execute(Realm realm) {
				Realm.getDefaultInstance().insert(palabras);
			}
		});
	}

	public void cambiarMostrarRespuestasPalabras(final List<Palabra> lista, final boolean valor) {
		Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
			@Override
			public void execute(Realm realm) {
				for (Palabra x : lista) {
					x.setMostrarRespuesta(valor);
				}
			}
		});
	}

	public void cambiarMostrarRespuestaPalabra(final Palabra x) {
		Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
			@Override
			public void execute(Realm realm) {
				x.setMostrarRespuesta(!x.isMostrarRespuesta());
			}
		});
	}

	public void cambiarPalabraProblematicaPalabra(final Palabra x) {
		Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
			@Override
			public void execute(Realm realm) {
				x.setPalabraProblematica(!x.isPalabraProblematica());
			}
		});
	}

	// ----------------------------------------------------
	// -------------------------- Verbo Irregular
	public List<VerboIrregular> getIrregularVerbs() {
		return Realm.getDefaultInstance().where(VerboIrregular.class).sort("infinitivo", Sort.ASCENDING).findAll();
	}

	public List<VerboIrregular> getIrregularVerbsProblematicos() {
		return Realm.getDefaultInstance().where(VerboIrregular.class).equalTo("palabraProblematica", true).sort("infinitivo", Sort.ASCENDING).findAll();
	}

	public void insertarIrregularVerbs(final List<VerboIrregular> palabras) {
		Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
			@Override
			public void execute(Realm realm) {
				Realm.getDefaultInstance().insert(palabras);
			}
		});
	}

	public void cambiarMostrarRespuestasVerbosIrregulares(final List<VerboIrregular> lista, final boolean valor) {
		Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
			@Override
			public void execute(Realm realm) {
				for (VerboIrregular x : lista) {
					x.setMostrarRespuesta(valor);
				}
			}
		});
	}

	public void cambiarMostrarRespuestaVerbosIrregulares(final VerboIrregular x) {
		Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
			@Override
			public void execute(Realm realm) {
				x.setMostrarRespuesta(!x.isMostrarRespuesta());
			}
		});
	}

	public void cambiarPalabraProblematicaVerbosIrregulares(final VerboIrregular x) {
		Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
			@Override
			public void execute(Realm realm) {
				x.setPalabraProblematica(!x.isPalabraProblematica());
			}
		});
	}
	// ----------------------------------------------------

	public void insertarPalabra(final Palabra palabra) {
		Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
			@Override
			public void execute(Realm realm) {
				realm.insert(palabra);
			}
		});
	}


}
