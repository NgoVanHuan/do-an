package com.example.manager_chemical_test.exception;

import lombok.Data;

@Data
public class AppException extends RuntimeException{
    private ErrorCode errorCode;

    public AppException(ErrorCode errorCode) {
        super((errorCode.getMessage()));
        this.errorCode = errorCode;
    }
}
