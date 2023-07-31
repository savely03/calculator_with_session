package com.github.savely03.exception;

public class DivideOnZeroException extends BaseException {
    @Override
    public String getMessage() {
        return "Ошибка деления на 0!";
    }
}