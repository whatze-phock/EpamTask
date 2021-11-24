package by.epam.inner.Purchase;

import by.epam.inner.Exceptions.*;

public class Byn {
    private int value;

    public Byn(int value) {
        if (value < 0) {
            throw new NonPositiveArgumentException(value,"coins");
        }
        this.value = value;
    }

    public Byn(int rubs, int coins) {
        this(getValidValue(rubs, coins));
    }

    public Byn(String strByn) {
      this(getValidValue(strByn));
    }

    public Byn() {}

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value+" ";
    }

    private static int getValidValue(int rubs, int coins) {

        //rubs * 100 + coins <= максимальное значение поля value в классе Byn.
        if (rubs < 0) {
            throw new NonPositiveArgumentException(rubs,"rubs");
        }
        if (coins < 0) {
            throw new NonPositiveArgumentException(coins, "coins");
        }
        if (coins > 100) {
            throw  new CoinOutOfRangeException(coins);
        }
        long maxValue = (long) rubs*100+coins;
        if (maxValue >= Integer.MAX_VALUE) {
            throw new RangeArgumentException(maxValue);
        }
        return (int)maxValue;
    }

    private static int getValidValue(String strByn) {
        //Для конструктора 4 используйте предварительно скомпилированное регулярное выражение. d+.dd
        // Если аргумент strByn ему не соответствует, то выбросьте экземпляр PatternArgumentException - пользовательского подкласса IllegalArgumentException.
        boolean matches = strByn.matches("\\d+.\\d\\d"); //переделать и проверить
        if (!matches) {
            throw new PatternArgumentException(Integer.valueOf(strByn), "byn value");
        }
        String[] mass = strByn.split("\\.");
        int answer = getValidValue(Integer.parseInt(mass[0]),Integer.parseInt(mass[1]));
        return answer;
    }
}
