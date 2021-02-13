package com.example.cuantocuesta.Services;

import android.text.InputFilter;
import android.text.Spanned;

import java.util.regex.Pattern;

public class DecimalDigitsInputFilter222 implements InputFilter {
    private Pattern pattern;

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

    public DecimalDigitsInputFilter222(int digitsBeforeZero, int digitsAfterZero) {
        pattern = Pattern.compile("^(([1-9]{1}([0-9]{" + digitsBeforeZero + "}))|0{1})?(\\.[0-9]{1,2})?$");
    }

    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        return pattern.matcher(dest).matches() ? null : "";
    }
}
