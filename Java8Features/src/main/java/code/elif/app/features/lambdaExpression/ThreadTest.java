package code.elif.app.features.lambdaExpression;

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
       Thread thread = new Thread(()-> System.out.println("This is a child thread..."));
       thread.start();
       Thread.sleep(100);
       System.out.println("This is a main thread...");
    }
}
