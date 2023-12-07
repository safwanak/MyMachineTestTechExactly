package com.example.mymachinetesttechexactly.utils.utils2.validation;

import android.text.InputFilter;
import android.text.Spanned;
import android.util.Log;

public class NameInputFilter implements InputFilter {
    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        String stringSource = source.toString();
        String stringDest = dest.toString();
        if (stringSource.equals(" ")) {
            if (stringDest.length() == 0)
                return "";
            if (stringDest.length() >= 1)
                if ((dstart > 0 && stringDest.charAt(dstart - 1) == ' ') || (stringDest.length() >  dstart && stringDest.charAt(dend) == ' ') || dstart == 0)
                    return "";
        }
        return null;
    }
}
