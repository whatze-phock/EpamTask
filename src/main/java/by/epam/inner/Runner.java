package by.epam.inner;

import by.epam.inner.Exceptions.*;
import by.epam.inner.Purchase.*;

import java.io.*;
import java.time.DayOfWeek;
import java.util.*;

public class Runner {
  static Map<Purchase,WrapperDate> firstMap = new HashMap<>();
  static EnumMap<DayOfWeek, List<Purchase>> weekDayMap = new EnumMap<>(DayOfWeek.class);



    public static void main(String[] args) throws FileNotFoundException {
        //String regex = "\\d\\d-\\d[0-1]\\d[1-9]-\\d\\d";
        //String qq = "19-12-15";
        //if(qq.matches(regex)) {
        //    System.out.println("+");
        //    }

         //String date = "19-12-15";
         //Date date1 = WrapperDate.parseDate(date);
         //System.out.println(date1);
//
//
        // Byn byn = new Byn(0, 80);
        // Product product = new Product("moloko", byn);


         FileReader fileReader = new FileReader("123.txt");

         try (Scanner sc = new Scanner(fileReader)) {
             while (sc.hasNext()) {
                 String line = sc.nextLine();

                 try {
                     String[] mass = line.split(";", 2);

                     Purchase pricePurchase = PurchasesFactory.getPurchaseFromFactory(mass[1]);
                     WrapperEntry wrapperEntry = new WrapperEntry(mass[0],pricePurchase);

                     WrapperEntry wrapperEntry1 = WrapperEntry.getValidEntry(line);
                     firstMap.put(wrapperEntry1.getPurchase(),wrapperEntry1.getDate());
                     DayOfWeek day = GetDay.getDay(mass[0]);

                     if (weekDayMap.containsKey(day) && day!=null) {
                         List<Purchase> list = weekDayMap.get(day);
                         list.add(pricePurchase);
                         weekDayMap.replace(day,list);
                     }
                     else if (day!=null) {
                         List<Purchase> list1 = new ArrayList<>();
                         list1.add(pricePurchase);
                         weekDayMap.put(day,list1);
                     }


                 } catch (CsvLineException e) {
                     e.printStackTrace();
                 }
             }

         }
        //for (Map.Entry<Purchase,WrapperDate> i:firstMap.entrySet()) {
        //    System.out.println(i);
        //}

        // Map<String,String> map = new HashMap<>();
        // map.put("1","raz");
        //map.put("2","dva");
        //map.put("3","tri");
        //System.out.println(map.get("3"));


        for (Map.Entry<DayOfWeek,List<Purchase>> i:weekDayMap.entrySet()) {
            System.out.println(i.getKey());

            for (Purchase j: i.getValue()) {
                System.out.println(j);
            }
        }


    }

}
