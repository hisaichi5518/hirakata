package com.github.hisaichi5518.hirakata;


import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

public class Hirakata {
    private final Map<TextView, Validator[]> validatorMap;

    private Hirakata(Map<TextView, Validator[]> validatorMap) {
        this.validatorMap = validatorMap;
    }

    public Observable<TextView> validate(final TextView textView) {
        return Observable.fromArray(validatorMap.get(textView)).flatMap(new Function<Validator, ObservableSource<TextView>>() {
            @Override
            public ObservableSource<TextView> apply(Validator validator) throws Exception {
                return validator.validate(textView);
            }
        });
    }

    public static final class Builder {
        private Map<TextView, Validator[]> validatorMap = new HashMap<>();

        public Builder add(TextView textView, Validator... validators) {
            validatorMap.put(textView, validators);

            return this;
        }


        public Hirakata build() {
            return new Hirakata(validatorMap);
        }
    }
}
