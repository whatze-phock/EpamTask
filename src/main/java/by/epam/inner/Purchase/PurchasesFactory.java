package by.epam.inner.Purchase;

import by.epam.inner.Exceptions.*;

public class PurchasesFactory {

        public static Purchase getPurchaseFromFactory(String csv) throws CsvLineException {
            String[] values = csv.split(";");
            try {
                switch(values.length) {
                    case 3:
                        return new Purchase(new Product(values[0],new Byn(values[1])),values[2]);
                    case 4:
                        return new PriceDiscountPurchase(new Product(values[0],new Byn(values[1])),values[2],values[3]);
                    default :
                        throw new CsvLineException(csv);
                }
            } catch (IllegalArgumentException e) {
                throw new CsvLineException(csv);
            }
        }


    }


