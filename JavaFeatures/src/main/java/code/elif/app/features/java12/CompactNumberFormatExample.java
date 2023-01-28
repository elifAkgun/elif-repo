package code.elif.app.features.java12;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

public class CompactNumberFormatExample {

    public static void main(String[] args) {
        NumberFormat numberFormat = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);
        numberFormat.setMinimumFractionDigits(1);

        System.out.println("1200 = " + numberFormat.format(1200));
        System.out.println("1700 = " + numberFormat.format(1700));

    }
}
