package com.seccion04.seccion04_ciudades.app;

import com.seccion04.seccion04_ciudades.models.Ciudad;

import io.realm.Realm;

public class ApplicationService {

    private Realm realm = Realm.getDefaultInstance();

    public void eliminarCiudad(final Ciudad ciudad) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                ciudad.deleteFromRealm();
            }
        });
    }

    public void guardarCiudad(final Ciudad ciudad) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(ciudad);
            }
        });
    }

    public void eliminarTodo() {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.deleteAll();
            }
        });
    }

}
