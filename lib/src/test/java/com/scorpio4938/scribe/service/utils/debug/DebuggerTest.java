package com.scorpio4938.scribe.service.utils.debug;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

public class DebuggerTest {
    @Test
    void testLogInfo() {
        // Arrange
        String message = "This is an test informational message.";

        // Act
        Debugger.log(message);

        // Assert
        Assertions.assertTrue(Debugger.getEnable(), "Debugger is not enabled.");
    }

    @Test
    void testLogWarning() {
        // Arrange
        String message = "This is a test warning message.";

        // Act
        Debugger.log("WARNING", message);

        // Assert
        Assertions.assertTrue(Debugger.getEnable(), "Debugger is not enabled.");
    }

    @Test
    void testInspect() {
        TestObject message = new TestObject("Hello");
        Debugger.inspect(message);
        Debugger.inspect("Test Object Detail", message);
    }

    @Test
    void testLogException() {
        // Arrange
        String message = "Stack trace of the exception.";

        // Act
        Exception exception = new RuntimeException("Test exception");
        Debugger.logException(exception);

        // Assert
        Assertions.assertTrue(Debugger.getEnable(), "Debugger is not enabled.");
    }

    private static class TestObject {
        private String name;

        private TestObject(String name) {
            this.name = name;
        }
    }
}
