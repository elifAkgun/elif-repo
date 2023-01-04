package code.elif.app.features.java11;

import lombok.NonNull;

import java.util.function.Function;

public class LocalVariableForLambdaParameters {
    public static void main(String[] args) {
        subString();
    }

    private static void subString() {
        Function<String, String> subString = (@NonNull String s) -> s.substring(0, s.length() - 1);
    }
}
