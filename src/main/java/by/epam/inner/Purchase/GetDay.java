package by.epam.inner.Purchase;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class GetDay {
    public static DayOfWeek getDay (String csv) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd");
        String[] mass = csv.split("\\-");
        DayOfWeek day;
        try {
            if (Integer.parseInt(mass[1])>12) {
                return null;
            }
            LocalDate date = LocalDate.of(Integer.parseInt(mass[0]), Month.of(Integer.parseInt(mass[1])), Integer.parseInt(mass[2]));

            day = date.getDayOfWeek();
            return day;
        }
        catch (ArrayIndexOutOfBoundsException e) {

        }
        return null;
    }
}
