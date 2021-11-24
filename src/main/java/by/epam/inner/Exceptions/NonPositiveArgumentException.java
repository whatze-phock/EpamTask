package by.epam.inner.Exceptions;

public class NonPositiveArgumentException extends IllegalArgumentException{
    public NonPositiveArgumentException (int nonPositiveValue, String fieldName) {
        super(String.format("Field: %s value: %s", fieldName, nonPositiveValue));
    }
    public NonPositiveArgumentException (String unitsNumber) {
        super("Not a positive value");
    }
}
