package code.elif.app.features.lambdaExpression;

public class LambdaExpressionWithThreadTest {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println("This is run method lambda expression");
        });
        t.start();
    }
}
