package martin.cuantocuesta.Models;

import martin.cuantocuesta.Services.UtilServiceLocal;
import martin.library.services.UtilService;

import static martin.cuantocuesta.Services.UtilServiceLocal.TIPO_GRAMOS;

public class Calculo {

    private String nombre;
    private Double cantidad;
    private Double precio;
    private String unidad;
    private Integer metro;
    private Integer porcentajeDescuentoCustom;
    private String tipoDescuento;
    private Double resultado;
    private Double resultadoPorUnidad;

    public Calculo() {
        this.unidad = TIPO_GRAMOS;
    }


    public Calculo(String nombre, Double cantidad, Double precio, String unidad, Integer metro, String tipoDescuento, Double resultado, Double resultadoPorUnidad, Integer porcentajeDescuentoCustom) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.unidad = unidad;
        this.metro = metro;
        this.tipoDescuento = tipoDescuento;
        this.resultado = resultado;
        this.resultadoPorUnidad = resultadoPorUnidad;
        this.porcentajeDescuentoCustom = porcentajeDescuentoCustom;
    }

    public Integer getPorcentajeDescuentoCustom() {
        return porcentajeDescuentoCustom;
    }

    public void setPorcentajeDescuentoCustom(Integer porcentajeDescuentoCustom) {
        this.porcentajeDescuentoCustom = porcentajeDescuentoCustom;
    }

    public String getTipoDescuento() {
        return tipoDescuento;
    }

    public void setTipoDescuento(String tipoDescuento) {
        this.tipoDescuento = tipoDescuento;
    }

    public Integer getMetro() {
        return metro;
    }

    public void setMetro(Integer metro) {
        this.metro = metro;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public Double getResultado() {
        return resultado;
    }

    public void setResultado(Double resultado) {
        this.resultado = resultado;
    }

    public Double getResultadoPorUnidad() {
        return resultadoPorUnidad;
    }

    public void setResultadoPorUnidad(Double resultadoPorUnidad) {
        this.resultadoPorUnidad = resultadoPorUnidad;
    }

    // no es la unidad de cada cosa sino el kilo, litro, gramo, etc
    public String calcularPrecioPorUnidad() {

        String result = "";

        // aqui la cantidad y el precio si o si tienen que ser mayores a cero, pero si ademas esta en TIPO_PAPEL_HIGIENICO tiene que tener los metros mayor a cero
        if (precio != null && precio > 0 && cantidad != null && cantidad > 0
                && (unidad != UtilServiceLocal.TIPO_PAPEL_HIGIENICO || (unidad == UtilServiceLocal.TIPO_PAPEL_HIGIENICO  && metro != null && metro > 0))
                && (tipoDescuento != UtilServiceLocal.DESCUENTO_MENOS_X_PORCIENTO_EN_SEGUNDA_UNIDAD || (tipoDescuento == UtilServiceLocal.DESCUENTO_MENOS_X_PORCIENTO_EN_SEGUNDA_UNIDAD && porcentajeDescuentoCustom > 0 && porcentajeDescuentoCustom < 101))
        ) {

            // esto es cuanto vale el kilo, litro, etc
            Double resultadoCuenta = new Double(0);

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


            if (tipoDescuento != null) {
                switch (tipoDescuento) {
                    case UtilServiceLocal.DESCUENTO_MENOS_50_PORCIENTO_EN_SEGUNDA_UNIDAD:
                        // si el $ por quilo sale 1250
                        // cuanto sale cada unidad
                        // cuanto sale el kilo con ese descuento comprando dos unidades

                        // $1250           100%
                        //                        x = 625             50
                        //
                        //                        sdasd
                        resultadoCuenta = calcularPorcentaje(resultadoCuenta, new Double(50));
                        break;
                    case UtilServiceLocal.DESCUENTO_MENOS_70_PORCIENTO_EN_SEGUNDA_UNIDAD:
                        resultadoCuenta = calcularPorcentaje(resultadoCuenta, new Double(70));
                        break;
                    case UtilServiceLocal.DESCUENTO_MENOS_X_PORCIENTO_EN_SEGUNDA_UNIDAD:
                        resultadoCuenta = calcularPorcentaje(resultadoCuenta, new Double(porcentajeDescuentoCustom));
                        break;
                    case UtilServiceLocal.DESCUENTO_DOS_POR_UNO:
                        resultadoCuenta = resultadoCuenta / 2;
                        break;
                    case UtilServiceLocal.DESCUENTO_TRES_POR_DOS:
                        // $por k es 500
                        //$por k final = 500 + 500 /3
                        resultadoCuenta = (resultadoCuenta * 2) / 3;
                        break;
                }
            }


            result = "$ " + UtilService.parseDoubleToString(resultadoCuenta);
        }
        return result;
    }


    public String calcularPrecioPorProducto() {

        String result = "";

        // aqui el precio si o si tienen que ser mayores a cero, pero si ademas esta en TIPO_PAPEL_HIGIENICO tiene que tener los metros mayor a cero
        if (precio != null && precio > 0
                && (unidad != UtilServiceLocal.TIPO_PAPEL_HIGIENICO || (unidad == UtilServiceLocal.TIPO_PAPEL_HIGIENICO && metro != null && metro > 0))
                && (tipoDescuento != UtilServiceLocal.DESCUENTO_MENOS_X_PORCIENTO_EN_SEGUNDA_UNIDAD || (tipoDescuento == UtilServiceLocal.DESCUENTO_MENOS_X_PORCIENTO_EN_SEGUNDA_UNIDAD && porcentajeDescuentoCustom > 0 && porcentajeDescuentoCustom < 101))
        ) {

            // esto es cuanto vale cafa unidad de lo que estas comprando cuando tenes un descuento
            Double precioPorProducto = new Double(0);


            if (tipoDescuento != null) {
                switch (tipoDescuento) {
                    case UtilServiceLocal.DESCUENTO_MENOS_50_PORCIENTO_EN_SEGUNDA_UNIDAD:
                        precioPorProducto = calcularPorcentaje(precio, new Double(50));
                        break;
                    case UtilServiceLocal.DESCUENTO_MENOS_70_PORCIENTO_EN_SEGUNDA_UNIDAD:
                        precioPorProducto = calcularPorcentaje(precio, new Double(70));
                        break;
                    case UtilServiceLocal.DESCUENTO_MENOS_X_PORCIENTO_EN_SEGUNDA_UNIDAD:
                        precioPorProducto = calcularPorcentaje(precio, new Double(porcentajeDescuentoCustom));
                        break;
                    case UtilServiceLocal.DESCUENTO_DOS_POR_UNO:
                        precioPorProducto = precio / 2;
                        break;
                    case UtilServiceLocal.DESCUENTO_TRES_POR_DOS:
                        precioPorProducto = (precio * 2) / 3;
                        break;
                }
            }

            result = "$ " + UtilService.parseDoubleToString(precioPorProducto);
        }
        return result;
    }


    private Double calcularPorcentaje(Double calculo, Double porcentaje) {
        return (calculo + (calculo - ((porcentaje * calculo) / 100))) / 2;
    }

}
