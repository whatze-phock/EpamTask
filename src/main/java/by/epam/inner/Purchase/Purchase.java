package by.epam.inner.Purchase;

import by.epam.inner.Exceptions.*;


public class Purchase {
    private final Product product;
    private final int unitsNumber;

    public Purchase (Product product, int unitsNumber) {
        this.product = product;
        this.unitsNumber = positiveUnitsValue(unitsNumber);
        validCost(product,unitsNumber);
    }
    public Purchase (Product product, String unitsNumber) {
        this.product = product;
        this.unitsNumber = positiveUnitsValue(unitsNumber);
        validCost(product,this.unitsNumber);
    }

    @Override
    public String toString() {
        return  product +
                ", quantity=" + unitsNumber;
    }

    private static int positiveUnitsValue (int unitsNumber) {
        if (unitsNumber <= 0) {
            throw new NonPositiveArgumentException(unitsNumber,"less then 1");
        }
        return unitsNumber;
    }
    private static int positiveUnitsValue (String unitsNumber) {
        if (!(unitsNumber.matches("\\d*[1-9]\\d*"))) {
            throw new NonPositiveArgumentException(unitsNumber);
        }
        return Integer.parseInt(unitsNumber);
    }

    //цена * количество <= максимальное значение поля value в классе Byn (не факт, что это максимум диапазона int).
    private static void validCost(Product product,int unitsNumber) {
        long max = Integer.MAX_VALUE;
        if ((long) product.getPrice().getValue() *unitsNumber>=max) {
            throw new RangeArgumentException(unitsNumber);
        }
    }
    public int getCost(Product product,int unitsNumber) {
        return product.getPrice().getValue()*unitsNumber;
    }
    protected String fieldsToString() {
        return  product + ";" + unitsNumber;
    }

}
