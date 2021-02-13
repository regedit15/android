package com.example.cuantocuesta.Services;

import android.text.InputFilter;
import android.text.Spanned;

import java.util.regex.Pattern;

public class InputFilterCustomDecimals implements InputFilter {
    private Pattern pattern;

    public InputFilterCustomDecimals(int digitsBeforeZero, int digitsAfterZero) {
        pattern = Pattern.compile("[0-9]*+((\\.[0-9]{0,1})?)||(\\.)?");
    }

    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        return pattern.matcher(dest).matches() ? null : "";
    }
}
