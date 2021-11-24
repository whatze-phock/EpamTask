package by.epam.inner.Exceptions;

public class CsvLineException extends IllegalArgumentException {
    public CsvLineException (String csv) {
        super(csv);
    }
}
