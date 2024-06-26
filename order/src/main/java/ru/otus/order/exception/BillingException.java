package ru.otus.order.exception;

public class BillingException extends RuntimeException {
    public BillingException(String message) {
        super(message);
    }
}
