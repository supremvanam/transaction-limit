package com.sv.customerlimits.error;

import com.sv.customerlimits.constants.HTTPStatusCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class InvalidTransactionLimitException extends Exception{

    public InvalidTransactionLimitException() {
        super();
    }

    public InvalidTransactionLimitException(String message) {
        super(message);
    }

    public InvalidTransactionLimitException(HTTPStatusCode code, String message) {
        super(message);

        if (code == HTTPStatusCode.BAD_REQUEST) {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }

    }

    public InvalidTransactionLimitException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidTransactionLimitException(Throwable cause) {
        super(cause);
    }

    protected InvalidTransactionLimitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
