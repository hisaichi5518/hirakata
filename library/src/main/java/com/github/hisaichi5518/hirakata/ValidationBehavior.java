package com.github.hisaichi5518.hirakata;

import android.widget.TextView;

import io.reactivex.Observable;

public interface ValidationBehavior {
    Observable<TextView> behave(TextView textView, String message);
}
