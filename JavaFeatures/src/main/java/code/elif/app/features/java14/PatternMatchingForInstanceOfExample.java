package code.elif.app.features.java14;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Random;

public class PatternMatchingForInstanceOfExample {

    public static void main(String[] args) {
        patternMatchingInstanceOf();
    }

    private static void patternMatchingInstanceOf() {
        Object object = someCode();
        if (object instanceof String result) {
            System.out.println(result.toUpperCase());
        } else if (object instanceof LocalDate result) {
            System.out.println(result + " - " + result.getMonthValue());
        } else if (object instanceof Number result) {
            System.out.println("Value : " + result.doubleValue());
        }
    }

    private static void oldStyleInstanceOf() {
        Object object = someCode();
        if (object instanceof String) {
            String result = (String) object;
            System.out.println(result.toUpperCase());
        } else if (object instanceof LocalDate) {
            LocalDate result = (LocalDate) object;
            System.out.println(result + " - " + result.getMonthValue());
        } else if (object instanceof Number) {
            Number result = (Number) object;
            System.out.println("Value : " + result.doubleValue());
        }
    }

    private static Object someCode() {
        Random random = new Random();
        int randomInt = random.nextInt(3);

        return switch (randomInt) {
            case 0 -> "String : " + randomInt;
            case 1 -> LocalDate.of(2023, randomInt, 1);
            case 2 -> new BigDecimal(randomInt);
            default -> throw new IllegalStateException("Unexpected value: " + randomInt);
        };
    }
}
