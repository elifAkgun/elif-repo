package code.elif.app.features.java17.switchPatternMatching;

import code.elif.app.features.java17.Fruit;

public class NullHandling {

    public static void main(String[] args) {


    }

    public static String getNameOfFruit(Fruit fruit) {
        return switch (fruit) {
            case null -> "Invalid fruit";
            case APPLE -> "Apple";
            case BANANA -> "Banana";
            case ORANGE -> "Orange";
            case STRAWBERRY -> "Strawberry";
        };
    }
}
