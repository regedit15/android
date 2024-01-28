package martin.saytheword.Services;

import android.content.Context;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.Sort;
import martin.saytheword.Models.Palabra;
import martin.saytheword.Models.VerboIrregular;

public class RealmService {

	public static AtomicInteger palabraId = new AtomicInteger();
	public static AtomicInteger verboIrregularId = new AtomicInteger();

	public void setearConfiguracion(Context context) {

		// ------------------- Config Realm Nueva
		// Fuente: https://www.mongodb.com/docs/realm/sdk/java/quick-starts/quick-start-local/
		// String realmName = "sayTheWordRealm";
		// RealmConfiguration config = new RealmConfiguration.Builder()
		// 		.name(realmName)
		// 		.allowQueriesOnUiThread(true)
		// 		.allowWritesOnUiThread(true)
		// 		.build();


		// Realm backgroundThreadRealm = Realm.getInstance(config);


		// Realm.getInstanceAsync(config, new Realm.Callback() {
		// 	@Override
		// 	public void onSuccess(Realm realm) {
		// 		Log.v(
		// 				"EXAMPLE",
		// 				"Successfully opened a realm with reads and writes allowed on the UI thread."
		// 		);
		// 	}
		// });

		// --------------------------------------------

		// ----- Setear configuracionSyncConfiguration
		Realm.init(context);
		RealmConfiguration config = new RealmConfiguration
				.Builder()
				// .allowQueriesOnUiThread(true)
				// .allowWritesOnUiThread(true)
				.build();
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

	public void eliminarTodo() {
		Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
			@Override
			public void execute(Realm realm) {
				realm.deleteAll();
			}
		});
	}

	// -------------------------- Palabra
	public List<Palabra> getPalabras() {
		return Realm.getDefaultInstance().where(Palabra.class).sort("palabraIng", Sort.ASCENDING).findAll();
	}

	public List<Palabra> getPalabrasPorDificultad(Integer[] dificultades) {
		return Realm.getDefaultInstance().where(Palabra.class).in("dificultad", dificultades).sort("palabraIng", Sort.ASCENDING).findAll();
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

	public void cambiarDificultadPalabra(final Palabra x) {
		Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
			@Override
			public void execute(Realm realm) {
				x.setDificultad(getSiguienteValor(x.getDificultad()));
			}
		});
	}
	// ----------------------------------------------------

	// -------------------------- Verbo Irregular
	public List<VerboIrregular> getIrregularVerbs() {
		return Realm.getDefaultInstance().where(VerboIrregular.class).sort("infinitivo", Sort.ASCENDING).findAll();
	}

	public List<VerboIrregular> getIrregularVerbsProblematicos(Integer[] dificultades) {
		return Realm.getDefaultInstance().where(VerboIrregular.class).in("dificultad", dificultades).sort("infinitivo", Sort.ASCENDING).findAll();
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

	public void cambiarDificultadVerboIrregular(final VerboIrregular x) {
		Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
			@Override
			public void execute(Realm realm) {
				x.setDificultad(getSiguienteValor(x.getDificultad()));
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

	public int getSiguienteValor(int valor) {
		int respuesta = valor;
		respuesta++;

		if (respuesta == 4) {
			respuesta = 1;
		}
		return respuesta;
	}


}
