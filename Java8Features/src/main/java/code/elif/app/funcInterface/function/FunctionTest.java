package code.elif.app.funcInterface.function;

import java.util.function.Function;

public class FunctionTest {

    public static void main(String[] args) {
      //  getGivenStringLengthWithFunction();
      //  removeWhiteSpacesFromGivenStringWithFunction();
       // getGivenStringWhiteSpaceCountFunction2();
       // combineTwoFunction2();
        functionIdentityMethod();

    }

    private static void getGivenStringLengthWithFunction() {
        Function<String,Integer> function = s-> s.length();
        System.out.println(function.apply("Pineapple"));
    }

    private static void removeWhiteSpacesFromGivenStringWithFunction() {
        Function<String,String> function = s-> s.replaceAll(" ", "");
        System.out.println(function.apply("Pineapple apple strawberry   "));
    }

    private static void getGivenStringWhiteSpaceCountFunction() {
        Function<String,Integer> function = s-> {
            char[] chars = s.toCharArray();
            int whiteSpaceCount = 0;
            for(int i =0; i< chars.length;i++){
                if((int) chars[i] == 32){
                    whiteSpaceCount++;
                }
            }
            return whiteSpaceCount;
        };
        System.out.println(function.apply("Pineapple apple strawberry   "));
    }

    private static void getGivenStringWhiteSpaceCountFunction2() {
        Function<String,Integer> function = s-> s.length()-s.replaceAll(" ","").length();
        System.out.println(function.apply("Pineapple apple strawberry   "));
    }

    private static void combineTwoFunction() {
        Function<String,String> function1 = s-> s.toUpperCase() + " strawberry";
        Function<String ,String> function2 = s -> s.substring(0,4) + " peach";

        System.out.println(function1.apply("Pineapple"));
        System.out.println(function2.apply("Pineapple"));
        System.out.println(function1.andThen(function2).apply("Pineapple"));
        System.out.println(function1.compose(function2).apply("Pineapple"));
    }

    private static void combineTwoFunction2() {
        Function<Integer,Integer> function1 = i -> i+i;
        Function<Integer ,Integer> function2 = i -> i*i*i;

        System.out.println(function1.andThen(function2).apply(5));
        System.out.println(function1.compose(function2).apply(5));
    }

    private static void functionIdentityMethod() {
        Function<Integer,Integer> function1 = Function.identity();
        System.out.println(function1.apply(5));
    }



}
