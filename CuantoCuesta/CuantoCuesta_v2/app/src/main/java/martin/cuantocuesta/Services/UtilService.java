package martin.cuantocuesta.Services;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import martin.cuantocuesta.Interfaces.LambdaInterfaceWithOneParameterString;


public class UtilService {

    private static DecimalFormat decimalFormat = new DecimalFormat("###,##0.00", new DecimalFormatSymbols(new Locale("es", "ES")));

    // -------------------------------------- Resource
    public static String getStringResourceByName(Context context, String nameResource) {
        String result;
        try {
            int resId = context.getResources().getIdentifier(nameResource, "string", context.getPackageName());
            result = context.getString(resId);
        } catch (Exception e) {
            result = "";
        }
        return result;
    }
    // --------------------------------------------------------------------------

    // -------------------------------------- Parse
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
    // --------------------------------------------------------------------------


    // -------------------------------------- Otros
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
    // --------------------------------------------------------------------------
}
