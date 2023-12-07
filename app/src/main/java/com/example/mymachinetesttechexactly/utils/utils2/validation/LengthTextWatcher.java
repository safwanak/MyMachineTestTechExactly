package com.example.mymachinetesttechexactly.utils.utils2.validation;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;

public class LengthTextWatcher implements TextWatcher {

    String prevVal = "";
    int length;
    EditText editText;
    public LengthTextWatcher(int l) {
        length = l;
    }

    public LengthTextWatcher(int length, EditText editText) {
        this.length = length;
        this.editText = editText;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {}

    @Override
    public void afterTextChanged(Editable s) {
        if(s != null && s.length() > 0) {
            if(s.length() > length) {
                s.clear();
                s.insert(0, prevVal);

            }
            prevVal = s.toString();
        }
    }

}
