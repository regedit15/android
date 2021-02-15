package martin.cuantocuesta.Services;

import android.content.Context;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import martin.cuantocuesta.Models.Calculo;
import martin.library.services.UtilService;


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


    public static final List<String> descuentos = Arrays.asList(
            DESCUENTO_MENOS_50_PORCIENTO_EN_SEGUNDA_UNIDAD,
            DESCUENTO_MENOS_70_PORCIENTO_EN_SEGUNDA_UNIDAD,
            DESCUENTO_MENOS_X_PORCIENTO_EN_SEGUNDA_UNIDAD,
            DESCUENTO_DOS_POR_UNO,
            DESCUENTO_TRES_POR_DOS
    );

    public static String[] descuentosTraducidos;

    public UtilServiceLocal() {

    }


    public static List<Calculo> getCalculos() {
        return new ArrayList<>(Arrays.asList(new Calculo()));
    }

    public static String[] getTipos() {
        return new String[]{TIPO_GRAMOS, TIPO_KILO, TIPO_LITRO, TIPO_UNIDAD, TIPO_PAPEL_HIGIENICO};
    }


    public static String getTipoDeDescuentoValor(int index) {
        return descuentos.get(index);
    }

    public static String[] getDescuentosTraducidos(Context context) {

        if (descuentosTraducidos == null) {

            descuentosTraducidos = new String[descuentos.size()];

            for (int i = 0; i < descuentos.size(); i++) {
                descuentosTraducidos[i] = UtilService.getStringResourceByName(context, descuentos.get(i));
            }
        }

        return descuentosTraducidos;
    }


}
