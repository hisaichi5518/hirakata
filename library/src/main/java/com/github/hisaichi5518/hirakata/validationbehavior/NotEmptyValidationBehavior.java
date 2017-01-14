package com.github.hisaichi5518.hirakata.validationbehavior;

import android.text.TextUtils;
import android.widget.TextView;

import com.github.hisaichi5518.hirakata.ValidateResult;
import com.github.hisaichi5518.hirakata.ValidationBehavior;
import com.github.hisaichi5518.hirakata.exception.ValidationException;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class NotEmptyValidationBehavior implements ValidationBehavior {
    @Override
    public Observable<ValidateResult> behave(final TextView textView, final String message) {
        return Observable.create(new ObservableOnSubscribe<ValidateResult>() {
            @Override
            public void subscribe(ObservableEmitter<ValidateResult> emitter) throws Exception {
                try {
                    boolean isEmpty = TextUtils.isEmpty(textView.getText());
                    if (isEmpty) {
                        throw new ValidationException(message, textView);
                    }
                    emitter.onNext(new ValidateResult()); // TODO
                    emitter.onComplete();
                } catch (Exception e) {
                    emitter.onError(e);
                }

            }
        });
    }
}
