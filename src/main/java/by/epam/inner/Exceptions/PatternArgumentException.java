package by.epam.inner.Exceptions;

public class PatternArgumentException extends IllegalArgumentException {
    public PatternArgumentException (int value, String fieldName) {
        super("This doesn't match the right pattern"+" "+value);
    }
    public PatternArgumentException (String fieldName) {
        super("Not a valid name");
    }
}
