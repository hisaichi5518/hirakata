package com.github.hisaichi5518.hirakata.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.github.hisaichi5518.hirakata.Hirakata;
import com.github.hisaichi5518.hirakata.ValidateResult;
import com.github.hisaichi5518.hirakata.Validator;
import com.github.hisaichi5518.hirakata.validationbehavior.EmailValidationBehavior;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

    }
}
