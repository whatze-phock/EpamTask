package by.epam.inner.Purchase;

import by.epam.inner.Exceptions.*;


public class PriceDiscountPurchase extends Purchase {
    private int discount;

    public PriceDiscountPurchase(Product product, int unitsNumber, int discount) {
        super(product, unitsNumber);
        this.discount = discount;
        getDiscountCorrectPrice(discount,product);
    }

    public PriceDiscountPurchase(Product product, String unitsNumber, String discount) {
        super(product,unitsNumber);
        this.discount = getDiscount(discount);
        validateDiscount(this.discount);
        getDiscountCorrectPrice(this.discount,product);

    }

    public int getCost (Product product,int unitsNumber,int discount) {
        return (product.getPrice().getValue()-discount)*unitsNumber;
    }

    private int validateDiscount (int discount) {
       // а) ненулевой, б) меньше цены - это условия валидности.
        if (discount < 0) {
            throw new NonPositiveArgumentException("cant be less then a zero");

        }
        return discount;
    }
    private int getDiscountCorrectPrice (int discount, Product product) {
        if (discount > product.getPrice().getValue()) {
            throw new PatternArgumentException(discount,"final price cant be less then a discount");
        }
        return discount;
    }
    private int getDiscount (String discount) {
        boolean reg = discount.matches("\\d+.\\d\\d");
        if (!reg) {
            throw new PatternArgumentException(discount);
        }
        String[] mass = discount.split("\\.");
        int result = Integer.parseInt(mass[0]);
        int result2 = Integer.parseInt(mass[1]);
        int value = (result*100)+result2;
        return value;
    }


    public String toString() {
        return  super.fieldsToString() + ";" +"discount="+ discount;
    }

}
