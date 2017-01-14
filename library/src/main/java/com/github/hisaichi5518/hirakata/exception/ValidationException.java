package com.github.hisaichi5518.hirakata.exception;

import android.widget.TextView;

public class ValidationException extends Exception {
    private final TextView textView;

    public ValidationException(String message, TextView textView) {
        super(message);
        this.textView = textView;
    }
}
