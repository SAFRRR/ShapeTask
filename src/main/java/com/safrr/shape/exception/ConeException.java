package com.safrr.shape.exception;

public class ConeException extends Exception{
    public ConeException() {
    }

    public ConeException(String msg) {
        super(msg);
    }

    public ConeException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public ConeException(Throwable cause) {
        super(cause);
    }
}
