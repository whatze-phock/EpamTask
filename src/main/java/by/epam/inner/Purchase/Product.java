package by.epam.inner.Purchase;

import by.epam.inner.Exceptions.*;


public class Product {
    private final String name;
    private final Byn price;

    public Product(String name, Byn price) {
      this.name = getValidName(name);
      this.price = getPositiveValue(price);
    }

    public Byn getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return  name + '\'' +
                ", price=" + price;
    }


    private static String getValidName (String name) {
        boolean matcher = name.matches("[a-zA-Z]{2,}");
        if (!matcher) {
            throw new PatternArgumentException(name);
        }
        return name;
    }
    private static Byn getPositiveValue (Byn price) {
        if (price.getValue() < 0) {
            throw new NonPositiveArgumentException(price.getValue(),"less then a zero");
        }
        return price;
    }
}
