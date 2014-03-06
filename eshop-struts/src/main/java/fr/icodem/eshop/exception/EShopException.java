package fr.icodem.eshop.exception;

public class EShopException extends Exception {
    public EShopException() {
    }

    public EShopException(String message) {
        super(message);
    }

    public EShopException(String message, Throwable cause) {
        super(message, cause);
    }

    public EShopException(Throwable cause) {
        super(cause);
    }

    public EShopException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
