package by.epam.inner.Exceptions;

public class CoinOutOfRangeException extends IllegalArgumentException {
    public CoinOutOfRangeException (int coin) {
        super("Error, coins must be not less then a hundred"+" "+ coin);
    }
}
