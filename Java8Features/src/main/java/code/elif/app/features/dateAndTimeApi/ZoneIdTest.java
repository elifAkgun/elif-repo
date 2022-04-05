package code.elif.app.features.dateAndTimeApi;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Comparator;

public class ZoneIdTest {
    public static void main(String[] args) {
        ZoneId zone = ZoneId.systemDefault();
        System.out.println(zone);

        ZoneId zone2 = ZoneId.of("America/Los_Angeles");
        System.out.println(zone2);
        ZonedDateTime zonedDateTimeLA = ZonedDateTime.now(zone2);
        System.out.println(zonedDateTimeLA);
        System.out.println(zonedDateTimeLA.toLocalDateTime());


        Comparator<Integer> comparable = (a, b) -> (a < b) ? 1 : -1;
        System.out.println(comparable.compare(10,20));
    }
}
