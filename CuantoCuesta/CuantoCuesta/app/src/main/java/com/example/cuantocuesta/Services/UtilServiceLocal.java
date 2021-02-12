package com.example.cuantocuesta.Services;

import android.content.Context;

import com.example.cuantocuesta.Models.Calculo;

import java.util.Arrays;
import java.util.List;

import martin.library.UtilService;


public class UtilServiceLocal {


    public static final String TIPO_KILO = "Kilo";
    public static final String TIPO_GRAMOS = "Gramos";
    public static final String TIPO_LITRO = "Litro";
    public static final String TIPO_UNIDAD = "Unidad";
    public static final String TIPO_PAPEL_HIGIENICO = "Papel higiénico";


    public static final String DESCUENTO_MENOS_50_PORCIENTO_EN_SEGUNDA_UNIDAD = "DESCUENTO_MENOS_50_PORCIENTO_EN_SEGUNDA_UNIDAD";
    public static final String DESCUENTO_MENOS_70_PORCIENTO_EN_SEGUNDA_UNIDAD = "DESCUENTO_MENOS_70_PORCIENTO_EN_SEGUNDA_UNIDAD";
    public static final String DESCUENTO_MENOS_X_PORCIENTO_EN_SEGUNDA_UNIDAD = "DESCUENTO_MENOS_X_PORCIENTO_EN_SEGUNDA_UNIDAD";
    public static final String DESCUENTO_DOS_POR_UNO = "DESCUENTO_DOS_POR_UNO";
    public static final String DESCUENTO_TRES_POR_DOS = "DESCUENTO_TRES_POR_DOS";


    public List<Calculo> getCalculos() {
        return Arrays.asList(
                new Calculo()
        );
    }

    public static String[] getTipos() {
        return new String[]{TIPO_GRAMOS, TIPO_KILO, TIPO_LITRO, TIPO_UNIDAD, TIPO_PAPEL_HIGIENICO};
    }


    public static String[] getTiposDeDescuentos(Context context) {
        return new String[]{
                UtilService.getStringResourceByName(context, DESCUENTO_MENOS_50_PORCIENTO_EN_SEGUNDA_UNIDAD),
                UtilService.getStringResourceByName(context, DESCUENTO_MENOS_70_PORCIENTO_EN_SEGUNDA_UNIDAD),
                UtilService.getStringResourceByName(context, DESCUENTO_MENOS_X_PORCIENTO_EN_SEGUNDA_UNIDAD),
                UtilService.getStringResourceByName(context, DESCUENTO_DOS_POR_UNO),
                UtilService.getStringResourceByName(context, DESCUENTO_TRES_POR_DOS),
        };
    }


}
