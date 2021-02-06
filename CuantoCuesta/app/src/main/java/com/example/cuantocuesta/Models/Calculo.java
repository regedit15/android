package com.example.cuantocuesta.Models;

public class Calculo {

    private String nombre;
    private double precio;
    private String unidad;
    private double resultado;
    private double resultadoPorUnidad;

    public Calculo() {

    }

    public Calculo(String nombre, double precio, String unidad, double resultado, double resultadoPorUnidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.unidad = unidad;
        this.resultado = resultado;
        this.resultadoPorUnidad = resultadoPorUnidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public double getResultadoPorUnidad() {
        return resultadoPorUnidad;
    }

    public void setResultadoPorUnidad(double resultadoPorUnidad) {
        this.resultadoPorUnidad = resultadoPorUnidad;
    }
}
