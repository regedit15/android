package martin.botoneraforgottera.Services;

import android.content.Context;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import io.realm.Case;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;
import martin.botoneraforgottera.Models.Audio;
import martin.botoneraforgottera.Models.Tag;

public class RealmService {

	public static AtomicInteger audioId = new AtomicInteger();
	public static AtomicInteger tagId = new AtomicInteger();

	public void setearConfiguracion(Context context) {

		// ----- Setear configuracion
		Realm.init(context);
		RealmConfiguration config = new RealmConfiguration.Builder().build();
		Realm.setDefaultConfiguration(config);
		//-----------------

		Realm realm = Realm.getDefaultInstance();
		audioId = getIdByTabla(realm, Audio.class);
		tagId = getIdByTabla(realm, Tag.class);
		realm.close();
	}

	public <T extends RealmObject> AtomicInteger getIdByTabla(Realm realm, Class<T> clase) {
		RealmResults<T> results = realm.where(clase).findAll();

		return (results.size() > 0) ? new AtomicInteger(results.max("id").intValue()) : new AtomicInteger();
	}

	public RealmResults<Audio> getAudios() {
		return Realm.getDefaultInstance().where(Audio.class).findAll();
	}

	public RealmResults<Audio> getAudiosFavoritos() {
		return Realm.getDefaultInstance().where(Audio.class).equalTo("favorito", true).findAll();
	}

	public void insertarAudios(List<Audio> audios) {
		Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
			@Override
			public void execute(Realm realm) {
				Realm.getDefaultInstance().insert(audios);
			}
		});
	}

	public RealmResults<Audio> filtrarAudiosPorTitulo(String nombre) {
		return Realm.getDefaultInstance().where(Audio.class).contains("nombre", nombre, Case.INSENSITIVE).findAll();
	}

	public List<Audio> filtrarAudiosPorTituloYTags(String nombre, List<String> tagsList) {

		String[] tags = tagsList.toArray(new String[0]);

		return Realm.getDefaultInstance().where(Audio.class).contains("nombre", nombre, Case.INSENSITIVE)

				.and().in("tags.nombre", tags)

				.findAll();
	}
}
