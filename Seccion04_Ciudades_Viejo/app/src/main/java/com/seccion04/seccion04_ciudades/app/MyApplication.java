package com.seccion04.seccion04_ciudades.app;

import android.app.Application;

import com.seccion04.seccion04_ciudades.models.Ciudad;

import java.util.concurrent.atomic.AtomicInteger;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;

public class MyApplication extends Application {

	public static AtomicInteger tabledoId = new AtomicInteger();

	@Override
	public void onCreate() {

		setUpRealConfig();

		Realm realm = Realm.getDefaultInstance();
		tabledoId = getIdByTabla(realm, Ciudad.class);
		realm.close();
	}

	private void setUpRealConfig() {
		// RealmConfiguration config = new RealmConfiguration.Builder(getApplicationContext()).deleteRealmIfMigrationNeeded().build();
		Realm.init(this);
		RealmConfiguration config = new RealmConfiguration.Builder().build();
		Realm.setDefaultConfiguration(config);
	}

	public <T extends RealmObject> AtomicInteger getIdByTabla(Realm realm, Class<T> clase) {
		RealmResults<T> results = realm.where(clase).findAll();

		return (results.size() > 0) ? new AtomicInteger(results.max("id").intValue()) : new AtomicInteger();
	}
}
