package by.epam.inner.Exceptions;

public class RangeArgumentException extends IllegalArgumentException {
    public RangeArgumentException (long value) {
        super("Value exceeds acceptable range:"+" "+value);
    }
    public RangeArgumentException (int value) {
        super("Value exceeds acceptable range");
    }
    public RangeArgumentException (String value) {
        super("Value exceeds acceptable range");
    }
}
