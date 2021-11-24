package by.epam.inner.Purchase;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataParser {
    private String date;
    private Pattern pattern;
    private Matcher matcher;

    public DataParser(String date, Pattern pattern) {
        this.date = date;
        this.pattern = pattern;
        this.matcher = this.pattern.matcher(this.date);
    }
    public DataParser() {}

    @Override
    public String toString() {
        return date;
    }

    public String getDate() {
        return date;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public Matcher getMatcher() {
        return matcher;
    }
}
