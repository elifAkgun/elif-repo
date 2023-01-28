package code.elif.app.features.java16.patternMatching;

import java.util.Objects;

public class PatternMatchingWithCondition {

    public static void main(String[] args) {

        Object o = "Apple";

        if (o instanceof String s && s.length() == 5){
            System.out.println(s);
        }
    }
}
