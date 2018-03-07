package com.hhu.exception;

/**
 * Created by WeiguoLiu on 2018/3/3.
 */
public class StockException extends RuntimeException {
    public StockException() {
        super();
    }

    public StockException(String message) {
        super(message);
    }

    public StockException(String message, Throwable cause) {
        super(message, cause);
    }

    public StockException(Throwable cause) {
        super(cause);
    }

    protected StockException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
