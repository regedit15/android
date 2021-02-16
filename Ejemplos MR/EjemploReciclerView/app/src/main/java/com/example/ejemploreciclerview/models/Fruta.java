package com.example.ejemploreciclerview.models;

public class Fruta {

    private String nombre;
    private String nombre2;
    private String descripcion;
    private int imagen;

    public Fruta(String nombre, String descripcion, int imagen) {
        this.nombre = nombre;
        this.nombre = "";
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

}
