package com.example.mymachinetesttechexactly.utils.utils2.validation;

import android.text.InputFilter;
import android.text.Spanned;

public class DecimalInputFilter implements InputFilter {
    private static final int MAX_NUMBER = 6;
    private static final int PRECISION = 2;

    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        StringBuilder builder = new StringBuilder(dest);
        builder.replace(dstart, dend, source.subSequence(start, end).toString());

        if (!builder.toString().matches("((\\d)(\\d{0," + (MAX_NUMBER - 1) + "})?)?(\\.\\d{0," + PRECISION + "})?")) {
            if (source.length() == 0)
                return dest.subSequence(dstart, dend);
            return "";
        }

        return null;
    }
}