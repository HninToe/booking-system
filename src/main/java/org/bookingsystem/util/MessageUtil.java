package org.bookingsystem.util;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Message Util class
 *
 * @author HninHninToe
 */
public class MessageUtil {

    /**
     * resource message
     */
    private static final ResourceBundle messages = ResourceBundle.getBundle("application-messages");

    /**
     * Get message
     *
     * @param messageId message ID
     * @param params    parameters
     * @return formatted message
     */
    public static String getMessage(String messageId, Object... params) {
        String messagePattern = messages.getString(messageId);
        return MessageFormat.format(messagePattern, params);
    }

    /**
     * Get message of target locale
     *
     * @param messageId message
     * @param locale    locale
     * @param params    parameters
     * @return formatted message
     */
    public static String getMessageWithLocale(String messageId, Locale locale, Object... params) {
        ResourceBundle localizedMessages = ResourceBundle.getBundle("application-messages", locale);
        String messagePattern = localizedMessages.getString(messageId);
        return MessageFormat.format(messagePattern, params);
    }
}
