package martin.cuantocuesta.inputsFilters;

import android.text.InputFilter;
import android.text.Spanned;

import java.util.regex.Pattern;

public class InputFilterPorcentaje implements InputFilter {

    private Pattern pattern;

    public InputFilterPorcentaje() {
        pattern = getPatternConCero();
    }

    public InputFilterPorcentaje(boolean incluyeCero) {
        pattern = incluyeCero ? getPatternConCero() : getPatternSinCero();
    }

    private Pattern getPatternConCero() {
        return Pattern.compile("^(100|[1-9]?[0-9])$");
    }

    private Pattern getPatternSinCero() {
        return Pattern.compile("^(100|[1-9][0-9]?)$");
    }

    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        return pattern.matcher(dest.toString() + source).matches() ? null : "";
    }
}
