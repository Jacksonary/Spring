package com.hhu.springjdbc.springtx;

/**
 * Created by WeiguoLiu on 2018/2/28.
 */
public class NumException extends RuntimeException{
    public NumException() {
    }

    public NumException(String message) {
        super(message);
    }

    public NumException(String message, Throwable cause) {
        super(message, cause);
    }

    public NumException(Throwable cause) {
        super(cause);
    }

    public NumException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

