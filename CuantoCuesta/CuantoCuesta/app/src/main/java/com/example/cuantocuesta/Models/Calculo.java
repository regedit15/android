package com.example.cuantocuesta.Models;

import com.example.cuantocuesta.Services.UtilServiceLocal;

import martin.library.UtilService;

import static com.example.cuantocuesta.Services.UtilServiceLocal.TIPO_GRAMOS;

public class Calculo {

    private String nombre;
    private double cantidad;
    private double precio;
    private String unidad;
    private int metro;
    private double resultado;
    private double resultadoPorUnidad;

    public Calculo() {
        this.unidad = TIPO_GRAMOS;
    }


    public Calculo(String nombre, double cantidad, double precio, String unidad, int metro, double resultado, double resultadoPorUnidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.unidad = unidad;
        this.metro = metro;
        this.resultado = resultado;
        this.resultadoPorUnidad = resultadoPorUnidad;
    }

    public int getMetro() {
        return metro;
    }

    public void setMetro(int metro) {
        this.metro = metro;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
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

    public String calcular() {

        String result = "";

        // aqui la cantidad y el precio si o si tienen que ser mayores a cero, pero si ademas esta en TIPO_PAPEL_HIGIENICO tiene que tener los metros mayor a cero
        if (cantidad > 0 && precio > 0 && (unidad != UtilServiceLocal.TIPO_PAPEL_HIGIENICO || (unidad == UtilServiceLocal.TIPO_PAPEL_HIGIENICO && metro > 0))) {


            double resultadoCuenta = 0;

            switch (unidad) {
                case UtilServiceLocal.TIPO_KILO:
                    //500 precio            3 cant
                    //  x = 1500             1
                    resultadoCuenta = precio * cantidad;
                    break;
                case UtilServiceLocal.TIPO_GRAMOS:
                    //500 precio            400 cant
                    //  x = 1250                 1000
                    resultadoCuenta = (1000 * precio) / cantidad;
                    break;
                case UtilServiceLocal.TIPO_UNIDAD:
                    //500 precio            5 cant
                    //  x = 100             1
                    resultadoCuenta = precio / cantidad;
                    break;
                case UtilServiceLocal.TIPO_LITRO:
                    //100 precio            2 cant
                    //  x = 100             1
                    resultadoCuenta = precio / cantidad;
                    break;
                case UtilServiceLocal.TIPO_PAPEL_HIGIENICO:
                    //100 precio      6 rollos,     20 metros
                    // precio por metros = 100 precio / 6 rollos /20 metros
                    resultadoCuenta = precio / cantidad / metro;
                    break;
            }

            result = "$ " + UtilService.parseDoubleToString(resultadoCuenta);
        }
        return result;
    }
}
