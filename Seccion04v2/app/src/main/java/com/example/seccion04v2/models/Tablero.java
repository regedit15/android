package com.example.seccion04v2.models;

import com.example.seccion04v2.app.MyApplication;

import java.util.Date;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Tablero extends RealmObject {

    @PrimaryKey
    private int id;
    @Required
    private String titulo;
    @Required
    private Date fechaCreacion;

    private RealmList<Nota> notas;

    public Tablero() {

    }

    public Tablero(String titulo) {
        this.id = MyApplication.tabledoId.incrementAndGet();
        this.titulo = titulo;
        this.fechaCreacion = new Date();
        this.notas = new RealmList<Nota>();
    }


    public int getId() {
        return id;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public RealmList<Nota> getNotas() {
        return notas;
    }

}
