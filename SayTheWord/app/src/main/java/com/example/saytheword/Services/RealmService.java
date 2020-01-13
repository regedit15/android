package com.example.saytheword.Services;

import android.content.Context;

import com.example.saytheword.Models.Palabra;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;

public class RealmService {

	public static AtomicInteger palabraId = new AtomicInteger();

	public void setearConfiguracion(Context context) {

		// ----- Setear configuracion
		Realm.init(context);
		RealmConfiguration config = new RealmConfiguration.Builder().build();
		Realm.setDefaultConfiguration(config);
		//-----------------

		Realm realm = Realm.getDefaultInstance();
		palabraId = getIdByTabla(realm, Palabra.class);
		realm.close();
	}

	public <T extends RealmObject> AtomicInteger getIdByTabla(Realm realm, Class<T> clase) {
		RealmResults<T> results = realm.where(clase).findAll();

		return (results.size() > 0) ? new AtomicInteger(results.max("id").intValue()) : new AtomicInteger();
	}

	public List<Palabra> getPalabras() {
		return Realm.getDefaultInstance().where(Palabra.class).findAll();
	}

	public List<Palabra> getPalabrasProblematicas() {
		return Realm.getDefaultInstance().where(Palabra.class).equalTo("palabraProblematica", true).findAll();
	}

	public void insertarPalabras(final List<Palabra> palabras) {
		Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
			@Override
			public void execute(Realm realm) {
				Realm.getDefaultInstance().insert(palabras);
			}
		});
	}

	public void cambiarTodo(final List<Palabra> lista, final boolean valor) {
		Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
			@Override
			public void execute(Realm realm) {
				for (Palabra palabra : lista) {
					palabra.setMostrarRespuesta(valor);
				}
			}
		});
	}

	public void cambiarMostrarRespuesta(final Palabra p) {
		Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
			@Override
			public void execute(Realm realm) {
				p.setMostrarRespuesta(!p.isMostrarRespuesta());
			}
		});
	}

	public void cambiarPalabraProblematica(final Palabra p) {
		Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
			@Override
			public void execute(Realm realm) {
				p.setPalabraProblematica(!p.isPalabraProblematica());
			}
		});
	}

	// public RealmResults<Audio> filtrarAudiosPorTitulo(String nombre) {
	// 	return Realm.getDefaultInstance().where(Audio.class).contains("nombre", nombre, Case.INSENSITIVE).findAll();
	// }
	//
	// public List<Audio> filtrarAudiosPorTituloYTags(String nombre, List<String> tagsList) {
	//
	// 	String[] tags = tagsList.toArray(new String[0]);
	//
	// 	return Realm.getDefaultInstance().where(Audio.class).contains("nombre", nombre, Case.INSENSITIVE)
	//
	// 			.and().in("tags.nombre", tags)
	//
	// 			.findAll();
	// }
}
