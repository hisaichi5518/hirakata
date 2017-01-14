# 枚方（Hirakata）

```java
Hirakata hirakata = new Hirakata.Builder()
    .add((TextView) findViewById(R.id.text_email),
        new Validator.Builder()
            .message("メールアドレスが不正です")
            .validationBehavior(new EmailValidationBehavior())
            .build())
    .build();


hirakata.validate((TextView) findViewById(R.id.text_email)).subscribe(new Observer<ValidateResult>() {
    @Override
    public void onSubscribe(Disposable d) {
    }

    @Override
    public void onNext(ValidateResult validateResult) {
        Log.i("onNext", validateResult.toString());
    }

    @Override
    public void onError(Throwable e) {
        Log.i("onError", e.toString());
    }

    @Override
    public void onComplete() {
    }
});
```
