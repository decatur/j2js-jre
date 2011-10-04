package org.junit;

public class Assert {
    
    /**
     * Asserts that two objects are equal. If they are not, an
     * {@link AssertionError} is thrown with the given message. If
     * <code>expected</code> and <code>actual</code> are <code>null</code>,
     * they are considered equal.
     * 
     * @param message
     *            the identifying message for the {@link AssertionError} (<code>null</code>
     *            okay)
     * @param expected
     *            expected value
     * @param actual
     *            actual value
     */
    static public void assertEquals(String message, Object expected,
            Object actual) {
        if (expected == null && actual == null)
            return;
        if (expected != null && isEquals(expected, actual))
            return;
        else if (expected instanceof String && actual instanceof String) {
            String cleanMessage= message == null ? "" : message;
            throw new ComparisonFailure(cleanMessage, (String) expected,
                    (String) actual);
        } else
            failNotEquals(message, expected, actual);
    }
    
    private static boolean isEquals(Object expected, Object actual) {
        return expected.equals(actual);
    }
    
    /**
     * Asserts that two objects are equal. If they are not, an
     * {@link AssertionError} without a message is thrown. If
     * <code>expected</code> and <code>actual</code> are <code>null</code>,
     * they are considered equal.
     * 
     * @param expected
     *            expected value
     * @param actual
     *            the value to check against <code>expected</code>
     */
    static public void assertEquals(Object expected, Object actual) {
        assertEquals(null, expected, actual);
    }
    
    /**
     * Asserts that a condition is true. If it isn't it throws an
     * {@link AssertionError} with the given message.
     * 
     * @param message
     *            the identifying message for the {@link AssertionError} (<code>null</code>
     *            okay)
     * @param condition
     *            condition to be checked
     */
    static public void assertTrue(String message, boolean condition) {
        if (!condition)
            fail(message);
    }

    /**
     * Asserts that a condition is true. If it isn't it throws an
     * {@link AssertionError} without a message.
     * 
     * @param condition
     *            condition to be checked
     */
    static public void assertTrue(boolean condition) {
        assertTrue(null, condition);
    }
    
    /**
     * Asserts that a condition is false. If it isn't it throws an
     * {@link AssertionError} with the given message.
     * 
     * @param message
     *            the identifying message for the {@link AssertionError} (<code>null</code>
     *            okay)
     * @param condition
     *            condition to be checked
     */
    static public void assertFalse(String message, boolean condition) {
        assertTrue(message, !condition);
    }

    /**
     * Asserts that a condition is false. If it isn't it throws an
     * {@link AssertionError} without a message.
     * 
     * @param condition
     *            condition to be checked
     */
    static public void assertFalse(boolean condition) {
        assertFalse(null, condition);
    }
    
    /**
     * Fails a test with the given message.
     * 
     * @param message
     *            the identifying message for the {@link AssertionError} (<code>null</code>
     *            okay)
     * @see AssertionError
     */
    static public void fail(String message) {
        throw new AssertionError(message == null ? "" : message);
    }
    
    static private void failNotEquals(String message, Object expected,
            Object actual) {
        fail(format(message, expected, actual));
    }
    
    static String format(String message, Object expected, Object actual) {
        String formatted= "";
        if (message != null && !message.equals(""))
            formatted= message + " ";
        String expectedString= String.valueOf(expected);
        String actualString= String.valueOf(actual);
        if (expectedString.equals(actualString))
            return formatted + "expected: "
                    + formatClassAndValue(expected, expectedString)
                    + " but was: " + formatClassAndValue(actual, actualString);
        else
            return formatted + "expected:<" + expectedString + "> but was:<"
                    + actualString + ">";
    }

    private static String formatClassAndValue(Object value, String valueString) {
        String className= value == null ? "null" : value.getClass().getName();
        return className + "<" + valueString + ">";
    }
}
