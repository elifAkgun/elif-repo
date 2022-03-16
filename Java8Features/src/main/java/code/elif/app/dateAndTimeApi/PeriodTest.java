package code.elif.app.dateAndTimeApi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class PeriodTest {

    public static void main(String[] args) {
        LocalDate birthDate = LocalDate.of(1989, 9, 04);
        LocalDate now = LocalDate.now();

        Period period = Period.between(birthDate, now);

        System.out.printf("There are %d years, %d months, %d days between your age and now."
                , period.getYears(), period.getMonths(), period.getDays());
    }
}
