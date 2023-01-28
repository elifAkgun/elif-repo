package code.elif.app.features.java16.sealed;

public class MainApp {

    public static void main(String[] args) {
        // 2 + 5 * 3
        Expression expression = new Add(new Constant(2), new Multiply(new Constant(5), new Constant(3)));
        System.out.println(expression.evaluate());
    }
}
