package com.scorpio4938.scribe.service.utils.debug;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

public class DebuggerTest {
    @Test
    public void testLogInfo() {
        // Arrange
        String message = "This is an informational message.";

        // Act
        Debugger.log("This is an informational message.");

        // Assert
        Assertions.assertTrue(Debugger.getEnable(), "Debugger is not enabled.");
    }

    @Test
    public void testLogWarning() {
        // Arrange
        String message = "This is a warning message.";

        // Act
        Debugger.log("WARNING", "This is a warning message.");

        // Assert
        Assertions.assertTrue(Debugger.getEnable(), "Debugger is not enabled.");
    }

    @Test
    public void testLogException() {
        // Arrange
        String message = "Stack trace of the exception.";

        // Act
        Exception exception = new RuntimeException("Test exception");
        Debugger.logException(exception);

        // Assert
        Assertions.assertTrue(Debugger.getEnable(), "Debugger is not enabled.");
    }
}
