package org.bookingsystem.logging;

import org.bookingsystem.util.MessageUtil;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.slf4j.spi.LocationAwareLogger;

import java.util.Locale;

/**
 * Logger class for booking system
 *
 * @author HninHninToe
 */
public class BookingSystemLogger {

    /**
     * maker
     */
    private static final Marker MARKER = MarkerFactory.getMarker("applog");

    /**
     * FQCN for BookingSystemLogger
     */
    private static final String FQCN = BookingSystemLogger.class.getName();

    /**
     * LocationAwareLogger
     */
    private final LocationAwareLogger logger;

    /**
     * Constructor
     *
     * @param targetClass target class
     */
    private BookingSystemLogger(Class<?> targetClass) {
        this.logger = (LocationAwareLogger) LoggerFactory.getLogger(targetClass);
    }

    /**
     * Get logger
     *
     * @param targetClass target class
     * @return BookingSystemLogger
     */
    public static BookingSystemLogger getLogger(Class<?> targetClass) {
        return new BookingSystemLogger(targetClass);
    }

    /**
     * Info log
     *
     * @param messageId message ID
     * @param params    parameters
     */
    public void info(String messageId, Object... params) {
        String message = MessageUtil.getMessage(messageId, params);
        this.logger.log(MARKER, FQCN, LocationAwareLogger.INFO_INT, message, params, null);
    }

    /**
     * Warning log
     *
     * @param messageId message ID
     * @param params    parameters
     */
    public void warn(String messageId, Object... params) {
        String message = MessageUtil.getMessage(messageId, params, messageId, Locale.getDefault());
        this.logger.log(MARKER, FQCN, LocationAwareLogger.WARN_INT, message, params, null);
    }

    /**
     * Debug log
     *
     * @param messageId message ID
     * @param params    parameters
     */
    public void debug(String messageId, Object... params) {
        String message = MessageUtil.getMessage(messageId, params, messageId, Locale.getDefault());
        this.logger.log(MARKER, FQCN, LocationAwareLogger.DEBUG_INT, message, params, null);
    }

    /**
     * Error log
     *
     * @param messageId message ID
     * @param params    parameters
     */
    public void error(String messageId, Object... params) {
        String message = MessageUtil.getMessage(messageId, params, messageId, Locale.getDefault());
        this.logger.log(MARKER, FQCN, LocationAwareLogger.ERROR_INT, message, params, null);
    }
}
