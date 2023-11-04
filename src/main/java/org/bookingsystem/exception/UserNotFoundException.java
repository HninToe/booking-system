package org.bookingsystem.exception;

import org.bookingsystem.util.MessageUtil;

/**
 * Exception class for user not found
 *
 * @author HninHninToe
 */
public class UserNotFoundException extends RuntimeException {

    /**
     * Constructor
     */
    public UserNotFoundException() {
    }

    /**
     * Exception for exclusive control.
     *
     * @param messageId message ID
     * @param args      arguments
     */
    public UserNotFoundException(String messageId, Object... args) {
        super(MessageUtil.getMessage(messageId, args));
    }

    /**
     * Exception for exclusive control.
     *
     * @param messageId message ID
     * @param cause     cause of exception
     * @param args      arguments
     */
    public UserNotFoundException(String messageId, Throwable cause, Object... args) {
        super(MessageUtil.getMessage(messageId, args), cause);
    }

    /**
     * Exception for exclusive control.
     *
     * @param cause cause of exception
     */
    public UserNotFoundException(Throwable cause) {
        super(cause);
    }
}
