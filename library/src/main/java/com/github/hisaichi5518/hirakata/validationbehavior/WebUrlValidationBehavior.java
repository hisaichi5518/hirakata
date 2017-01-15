package com.github.hisaichi5518.hirakata.validationbehavior;


import android.util.Patterns;
import android.widget.TextView;

import com.github.hisaichi5518.hirakata.ValidationBehavior;
import com.github.hisaichi5518.hirakata.exception.ValidationException;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class WebUrlValidationBehavior implements ValidationBehavior {
    @Override
    public Observable<TextView> behave(final TextView textView, final String message) {
        return Observable.create(new ObservableOnSubscribe<TextView>() {
            @Override
            public void subscribe(ObservableEmitter<TextView> emitter) throws Exception {
                try {
                    boolean matched = Patterns.WEB_URL.matcher(textView.getText()).matches();
                    if (!matched) {
                        throw new ValidationException(message, textView);
                    }
                    emitter.onNext(textView);
                    emitter.onComplete();
                } catch (Exception e) {
                    emitter.onError(e);
                }
            }
        });
    }
}
