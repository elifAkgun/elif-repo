package code.elif.app.features.lambdaExpression;

public class AnonymousClassTest {
    public static void main(String[] args) throws InterruptedException {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("This is runnable interface anonymous class");
                System.out.println(getClass());
            }
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("This is runnable interface anonymous class");
                System.out.println(getClass());
            }
        };

        Thread t = new Thread(r);
        t.start();

        Thread t2 = new Thread(r2);
        t2.start();

    }
}
