package com.scorpio4938.scribe.service.utils.debug;

import java.io.PrintWriter;
import java.io.StringWriter;

public class Debugger {
    private static final boolean ENABLED = true; // Set to false to disable debugging logs

    public static boolean getEnable() {
        return ENABLED;
    }

    /**
     * Logs a debug message with a timestamp.
     *
     * @param message The debug message to log.
     */
    public static void log(String message) {
        if (ENABLED) {
            System.out.println(" [DEBUG] " + message);
        }
    }

    /**
     * Logs a debug message with a timestamp and a log type.
     *
     * @param logType The type of log (e.g., "info", "warning", "error").
     * @param message The debug message to log.
     */
    public static void log(String logType, String message) {
        if (ENABLED) {
            System.out.println(" [" + logType.toUpperCase() + "] " + message);
        }
    }

    /**
     * Logs the stack trace of an exception.
     *
     * @param exception The exception to log.
     */
    public static void logException(Exception exception) {
        if (ENABLED) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            exception.printStackTrace(pw);
            System.out.println(" [EXCEPTION] " + sw);
        }
    }
}
