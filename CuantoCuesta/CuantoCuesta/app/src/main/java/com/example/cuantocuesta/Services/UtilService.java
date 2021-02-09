package com.example.cuantocuesta.Services;

import android.text.Editable;
import android.text.TextWatcher;

import com.example.cuantocuesta.Interfaces.LambdaInterfaceWithOneParameterString;
import com.example.cuantocuesta.Models.Calculo;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;


public class UtilService {

    private static DecimalFormat decimalFormat = new DecimalFormat("###,##0.00", new DecimalFormatSymbols(new Locale("es", "ES")));
    public static final String TIPO_KILO = "Kilo";
    public static final String TIPO_GRAMOS = "Gramos";
    public static final String TIPO_LITRO = "Litro";
    public static final String TIPO_UNIDAD = "Unidad";
    public static final String TIPO_PAPEL_HIGIENICO = "Papel higiénico";


    public List<Calculo> getCalculos() {
        return Arrays.asList(
                new Calculo()
        );
    }

    public static String[] getTipos() {
        return new String[]{TIPO_GRAMOS, TIPO_KILO, TIPO_LITRO, TIPO_UNIDAD, TIPO_PAPEL_HIGIENICO};
    }


    public static TextWatcher getTextWatcher(LambdaInterfaceWithOneParameterString function) {
        return new TextWatcher() {
            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                function.execute(s.toString());
            }
        };
    }

    public static double parseStringToDouble(String number) {
        double result;
        try {
            result = Double.parseDouble(number);
        } catch (Exception e) {
            result = 0;
        }
        return result;
    }

    public static int parseStringToInteger(String text) {
        int result;
        try {
            result = Integer.parseInt(text);
        } catch (Exception e) {
            result = 0;
        }
        return result;
    }


    public static String parseDoubleToString(Double number) {
        String result;
        try {
            result = decimalFormat.format(number);
        } catch (Exception e) {
            result = "";
        }
        return result;
    }

}
