package code.elif.app.features.dateAndTimeApi;

import java.time.Year;
import java.util.Random;
import java.util.stream.IntStream;

public class YearExample {
    public static void main(String[] args) {

        Random random = new Random();
        int lowYear = 1000;
        int highYear = 3000;
        int randomYear = random.nextInt(highYear-lowYear) +lowYear ;

        Year year = Year.of(randomYear);
        if(year.isLeap()){
            System.out.println(randomYear + " is leap year");
        } else {
            System.out.println(randomYear + " is not leap year");
        }
    }
}
