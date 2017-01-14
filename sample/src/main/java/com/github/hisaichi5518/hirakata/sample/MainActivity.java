package com.github.hisaichi5518.hirakata.sample;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;

import com.github.hisaichi5518.hirakata.Hirakata;
import com.github.hisaichi5518.hirakata.ValidateResult;
import com.github.hisaichi5518.hirakata.Validator;
import com.github.hisaichi5518.hirakata.sample.databinding.ActivityMainBinding;
import com.github.hisaichi5518.hirakata.validationbehavior.EmailValidationBehavior;
import com.github.hisaichi5518.hirakata.validationbehavior.NotEmptyValidationBehavior;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        final Hirakata hirakata = new Hirakata.Builder()
                .add(binding.textInputEmail,
                        new Validator.Builder()
                                .message("メールアドレスは必須です")
                                .validationBehavior(new NotEmptyValidationBehavior())
                                .build(),
                        new Validator.Builder()
                                .message("メールアドレスが不正です")
                                .validationBehavior(new EmailValidationBehavior())
                                .build())
                .build();

        binding.textInputEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                hirakata.validate(binding.textInputEmail).subscribe(new Observer<ValidateResult>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(ValidateResult validateResult) {
                        binding.textInputEmailLayout.setErrorEnabled(false);
                        binding.textInputEmailLayout.setError(null);
                    }

                    @Override
                    public void onError(Throwable e) {
                        binding.textInputEmailLayout.setErrorEnabled(true);
                        binding.textInputEmailLayout.setError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
            }
        });
    }
}
