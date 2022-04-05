package code.elif.app.features.methodReference;

public class MethodReferenceTest {

    public static void myStaticMethod() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("This message is from myStaticMethod");
        }
    }

    public void myInstanceMethod() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("This message is from myInstanceMethod");
        }
    }

    public static void main(String[] args) {

        Runnable r1 = MethodReferenceTest::myStaticMethod; // this usage for static methods
        Thread t1 = new Thread(r1);
        t1.start();

        MethodReferenceTest mrt = new MethodReferenceTest();
        Runnable r2 = mrt::myInstanceMethod;
        Thread t2 = new Thread(r2);
        t2.start();

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("This message is from main method");
        }
    }
}
