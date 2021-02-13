package com.example.cuantocuesta.Services;

import android.text.InputFilter;
import android.text.Spanned;

import java.util.regex.Pattern;

public class DecimalDigitsInputFilter implements InputFilter {
    //    private Pattern pattern = Pattern.compile("^(([1-9]{1}([0-9]*))|0{1})?(\\.[0-9]{1,2})?$");
    //    private Pattern pattern = Pattern.compile("^[0-9]*+((\\.[0-9]{0,2})?)|(\\.)?");


    //    private Pattern internet = Pattern.compile("[0-9]{0," + (5 - 1) + "}+((\\.[0-9]{0," + (2 - 1) + "})?)||(\\.)?");
    //
    //    private Pattern internetPasado = Pattern.compile("^[0-9]{0,4}+((\\.[0-9]{0,2})?)||(\\.)?$");
    //
    //    private Pattern internetPasado2 = Pattern.compile("^[0-9]{0,4}+(\\.)?$");

    private Pattern pattern = Pattern.compile("^(([1-9]{1}([0-9]*))|0{1})?(\\.[0-9]{1,2})?$");

    // 5 y 2
    //    public DecimalDigitsInputFilter(int digitsBeforeZero, int digitsAfterZero) {
    //        mPattern = Pattern.compile("[0-9]{0," + (digitsBeforeZero - 1) + "}+((\\.[0-9]{0," + (digitsAfterZero - 1) + "})?)||(\\.)?");
    //    }
    //
    //    @Override
    //    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
    //        Matcher matcher = mPattern.matcher(dest);
    //        if (!matcher.matches())
    //            return "";
    //        return null;
    //    }

    public DecimalDigitsInputFilter() {

    }

    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        return pattern.matcher(dest).matches() ? null : "";
    }
}
