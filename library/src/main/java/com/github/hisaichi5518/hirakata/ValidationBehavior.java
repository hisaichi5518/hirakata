package com.github.hisaichi5518.hirakata;

import io.reactivex.Observable;

public interface ValidationBehavior {
    Observable<ValidateResult> validate();
}
