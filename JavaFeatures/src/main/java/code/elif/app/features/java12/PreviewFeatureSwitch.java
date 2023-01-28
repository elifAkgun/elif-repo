package code.elif.app.features.java12;

import java.util.List;
import java.util.Random;

public class PreviewFeatureSwitch {
    private static final String ORDERED = "ORDERED";
    private static final String COOKING = "COOKING";
    private static final String DELIVERED = "DELIVERED";
    private static final String CANCELLED = "CANCELLED";

    private static final List<String> STATUS_LIST = List.of(ORDERED, COOKING, DELIVERED, CANCELLED);

    public static void main(String[] args) {

        Random random = new Random();
        int myRandInt = random.ints(0,
                        3)
                .findAny().getAsInt();

        var status = STATUS_LIST.get(myRandInt);
        var result = switch (status) {
            case ORDERED -> "Food ordered, Restaurant will confirm";
            case COOKING -> "Restaurant confirmed order, food is being cooked";
            case DELIVERED -> "Food has been delivered";
            case CANCELLED -> {
                processCancellation();
               yield  "Food order has been cancelled";
            }
            default -> throw  new IllegalArgumentException("Invalid status of order");
        };

        System.out.println(result);
    }

    private static void processCancellation() {
    }
}
