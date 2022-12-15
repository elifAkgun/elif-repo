package code.elif.app.features.lambdaExpression;

public class MessageTest {

    static String name = "John";

    public static void main(String args[]) {
        String saluteText = "Hello! ";
        name = "Jane";
        GreetingService greetService = (name) -> {
           // saluteText = "Hi!!"; //Error: java: local variables referenced from a lambda expression must be final or effectively final
            System.out.println(saluteText + name );
        };
        greetService.sayMessage("John");
    }
}
