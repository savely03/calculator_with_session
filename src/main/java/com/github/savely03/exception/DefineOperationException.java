package com.github.savely03.exception;

public class DefineOperationException extends BaseException {
    private final String operation;

    public DefineOperationException(String operation) {
        this.operation = operation;
    }

    @Override
    public String getMessage() {
        return String.format("Невозможно определить операцию - %s", operation);
    }
}
