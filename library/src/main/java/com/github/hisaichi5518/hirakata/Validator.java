package com.github.hisaichi5518.hirakata;


public class Validator {
    private final String message;
    private final ValidationBehavior validationBehavior;

    public Validator(String message, ValidationBehavior validationBehavior) {
        this.message = message;
        this.validationBehavior = validationBehavior;
    }

    public static final class Builder {
        private String message;
        private ValidationBehavior validationBehavior;

        public Builder message(String message) {
            this.message = message;

            return this;
        }

        public Builder validationBehavior(ValidationBehavior validationBehavior) {
            this.validationBehavior = validationBehavior;

            return this;
        }

        public Validator build() {
            return new Validator(message, validationBehavior);
        }
    }
}
