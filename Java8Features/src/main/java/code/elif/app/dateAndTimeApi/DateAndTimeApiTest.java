package code.elif.app.dateAndTimeApi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DateAndTimeApiTest {

    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        System.out.println(date);

        LocalTime time = LocalTime.now();
        System.out.println(time);

        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);

        System.out.println("Day of Year is : " +  date.getDayOfYear());
        System.out.println("Day of Month is : " +  date.getDayOfMonth());
        System.out.println("Day of Week is : " +  date.getDayOfWeek());

        System.out.println("Month is : " +  date.getMonth());
        System.out.println("Month value is : " +  date.getMonthValue());

        System.out.println("Year is : " +  date.getYear());

    }
}
