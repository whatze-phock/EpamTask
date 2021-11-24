package by.epam.inner.Purchase;

import by.epam.inner.Exceptions.*;

public class WrapperEntry {
    private final WrapperDate date;
    private final Purchase purchase;

    public WrapperDate getDate() {
        return date;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public WrapperEntry(WrapperDate date, Purchase purchase) {
        this.date = date;
        this.purchase = purchase;
    }
    public WrapperEntry(String date, Purchase purchase) {
        this.date = new WrapperDate(date);
        this.purchase = purchase;
    }

    @Override
    public String toString() {
        return date +" "+purchase;
    }

    public static WrapperEntry getValidEntry(String csv) throws CsvLineException {
        String[] values = csv.split(";", 2);	//рассплитить line не более, чем  на 2 подстроки
        if (values.length < 2) {
            throw new CsvLineException(csv);
        }
       // создать экземпляр WrapperDate date из values[0];
        WrapperDate date = new WrapperDate(values[0]);
        //создать экземпляр Purchase purchase из values[1];
        Purchase purchase = PurchasesFactory.getPurchaseFromFactory(values[1]);
        return new WrapperEntry(date, purchase);
    }
}



