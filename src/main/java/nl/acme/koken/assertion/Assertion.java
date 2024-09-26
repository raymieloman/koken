package nl.acme.koken.assertion;

public class Assertion {

    public static void require(boolean b, String message) {
        if (!b) {
            throw new AssertionError(message);
        }
    }

    public static void require(boolean b) {
        if (!b) {
            throw new AssertionError();
        }
    }

    public static void assertFalse(boolean b) {
        if (b) {
            throw new AssertionError();
        }
    }

    public static void assertFalse(boolean b, String message) {
        if (b) {
            throw new AssertionError(message);
        } else {
            System.out.printf("OK => %s%n", message);
        }
    }

    public static void ensure(boolean b) {
        if (!b) {
            throw new AssertionError();
        }
    }

    public static void ensure(boolean b, String message) {
        if (!b) {
            throw new AssertionError(message);
        } else {
            System.out.printf("OK => %s%n", message);
        }
    }

    public static void fail(String message) {
        throw new AssertionError(message);
    }

    public static void ok(String message) {
        System.out.println(message);
    }

    public static void equals(Object expected, Object actual) {
        require(expected != null && actual != null, "Expected and actual must not be null");
        ensure(actual.equals(expected), "Expected and actual must be equal");
    }

    public static void equals(long expected, long actual) {
        ensure(actual == expected, "expected: %d, actual: %d".formatted(expected, actual));
    }
}
