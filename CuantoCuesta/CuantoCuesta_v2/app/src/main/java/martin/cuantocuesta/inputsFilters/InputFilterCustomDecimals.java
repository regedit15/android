package martin.cuantocuesta.inputsFilters;

import android.text.InputFilter;
import android.text.Spanned;

import java.util.regex.Pattern;

public class InputFilterCustomDecimals implements InputFilter {

    private static Pattern pattern;

    public InputFilterCustomDecimals(int digitsBeforeZero, int digitsAfterZero) {
        pattern = Pattern.compile("^(([1-9]{1}[0-9]{0," + (digitsBeforeZero - 1) + "})|0{1})?(\\.)?(\\.[0-9]{1," + digitsAfterZero + "})?$");
    }

    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        return pattern.matcher(dest + source.toString()).matches() ? null : "";
    }

}
