package com.pengxr.modular.eventbus.facade.exception;

/**
 * As its name
 * <p>
 * Created by pengxr on 12/8/2022
 */
public class IllegalEventBusFactoryException extends RuntimeException {

    /**
     * Constructs a new {@code RuntimeException} with the current stack trace
     * and the specified detail message.
     *
     * @param detailMessage the detail message for this exception.
     */
    public IllegalEventBusFactoryException(String detailMessage) {
        super(detailMessage);
    }
}
