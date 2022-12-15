package code.elif.app.features.dateAndTimeApi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DateAndTimeApiTest {

    public static void main(String[] args) {
       // localTimeExample();
        localDateExample();
       // localDateTimeExample();


    }

    private static void localTimeExample() {
        LocalTime time = LocalTime.now();
        System.out.println(time);

        System.out.println(time.getHour());
        System.out.println(time.getMinute());
        System.out.println(time.getSecond());
        System.out.println(time.getNano());
    }

    private static void localDateExample() {
        LocalDate date = LocalDate.now();
        System.out.println(date);

        System.out.println("Day of Year is : " +  date.getDayOfYear()); //Day of Year is : 102

        System.out.println("Day of Month is : " +  date.getDayOfMonth()); //Day of Month is : 12

        System.out.println("Day of Week is : " +  date.getDayOfWeek());//Day of Week is : TUESDAY

        System.out.println("Month is : " +  date.getMonth()); //Month is : APRIL

        System.out.println("Month value is : " +  date.getMonthValue()); //Month value is : 4

        System.out.println("Year is : " +  date.getYear());//Year is : 2022

        System.out.println(date.plusDays(10));//2022-04-22
        System.out.println(date.plusMonths(10)); //2023-02-12
        System.out.println(date.plusYears(10)); //2032-04-12
        System.out.println(date.plusWeeks(10)); //2022-06-21
    }

    private static void localDateTimeExample() {
        LocalDateTime localDateTime = LocalDateTime.of(2022,9,4,12,21,7);
        System.out.println("localDateTime: " + localDateTime); //localDateTime: 2022-09-04T12:21:07
    }
}
