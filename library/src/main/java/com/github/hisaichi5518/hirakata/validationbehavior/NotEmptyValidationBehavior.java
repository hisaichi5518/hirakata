package com.github.hisaichi5518.hirakata.validationbehavior;

import android.text.TextUtils;
import android.widget.TextView;

import com.github.hisaichi5518.hirakata.ValidationBehavior;
import com.github.hisaichi5518.hirakata.exception.ValidationException;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class NotEmptyValidationBehavior implements ValidationBehavior {
    @Override
    public Observable<TextView> behave(final TextView textView, final String message) {
        return Observable.create(new ObservableOnSubscribe<TextView>() {
            @Override
            public void subscribe(ObservableEmitter<TextView> emitter) throws Exception {
                try {
                    boolean isEmpty = TextUtils.isEmpty(textView.getText());
                    if (isEmpty) {
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
