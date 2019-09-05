package com.example.seccion04v2.app;

import android.app.Application;

import com.example.seccion04v2.models.Nota;
import com.example.seccion04v2.models.Tablero;

import java.util.concurrent.atomic.AtomicInteger;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;

public class MyApplication extends Application {

    public static AtomicInteger tabledoId = new AtomicInteger();
    public static AtomicInteger notaId = new AtomicInteger();

    @Override
    public void onCreate() {

        Realm realm = Realm.getDefaultInstance();
        tabledoId = getIdByTabla(realm, Tablero.class);
        notaId = getIdByTabla(realm, Nota.class);
        realm.close();
    }

    public <T extends RealmObject> AtomicInteger getIdByTabla(Realm realm, Class<T> clase){
        RealmResults<T> results = realm.where(clase).findAll();

        return (results.size() > 0) ? new AtomicInteger(results.max("id").intValue()):new AtomicInteger();
    }
}
