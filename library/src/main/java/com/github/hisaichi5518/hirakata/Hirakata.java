package com.github.hisaichi5518.hirakata;


import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class Hirakata {
    private final Map<TextView, Validator[]> validatorMap;

    private Hirakata(Map<TextView, Validator[]> validatorMap) {
        this.validatorMap = validatorMap;
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
