package com.github.savely03.exception;

public class InputDataException extends BaseException {

    @Override
    public String getMessage() {
        return "Введенные данные не соответствуют шаблону ";
    }
}
