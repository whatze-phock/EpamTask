package by.epam.inner.Purchase;

import by.epam.inner.Exceptions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;


public class WrapperDate extends DataParser{

    private static final String regex = "([0-3]?[0-9]-[0-1]?[0-9]-(?:[0-9]{2})?[0-9]{2})";
    private static final Pattern pattern = Pattern.compile(regex);

    public WrapperDate(String date, Pattern pattern) {
        super(date, pattern);
    }

    public WrapperDate(String date) {
        super(date,pattern);
    }

    public WrapperDate() {
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static Date parseDate (String date)  {
        if (!(date.matches(regex))) {
            throw new PatternArgumentException(date);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd");
        Date date1 = null;
        try {
            date1 = simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date1;
    }

}
