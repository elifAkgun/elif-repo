package code.elif.app.features.lambdaExpression;

public class Java8LambdaExpTest {

    public static void main(String args[]) {

        // with type declaration
        MathOperation add = (int a, int b) -> a + b;

        // with out type declaration
        MathOperation sub = (a, b) -> a - b;

        // with return statement along with curly braces
        MathOperation multi = (int a, int b) -> {
            return a * b;
        };

        // without return statement and without curly braces
        MathOperation div = (int a, int b) -> a / b;

        System.out.println("8 + 2 = " + operate(8, 2, add));
        System.out.println("8 - 2 = " + operate(8, 2, sub));
        System.out.println("8 x 2 = " + operate(8, 2, multi));
        System.out.println("8 / 2 = " + operate(8, 2, div));

        // without parenthesis
        GreetingService greetService1 = message -> System.out.println("Hello " + message);

        // with parenthesis
        GreetingService greetService2 = (message) -> System.out.println("Hello " + message);

        greetService1.sayMessage("John");
        greetService2.sayMessage("Jane");
    }

    public static int operate(int a, int b, MathOperation mathOps) {
        return mathOps.operation(a, b);
    }

}



