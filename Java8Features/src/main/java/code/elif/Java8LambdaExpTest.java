package code.elif;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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


interface MathOperation {
    int operation(int a, int b);
}

interface GreetingService {
    void sayMessage(String message);
}

class MessageTest {

    static String name = "John";

    public static void main(String args[]) {
        String saluteText = "Hello! ";
        name = "Jane";
        GreetingService greetService1 = (name) -> {
            //saluteText = "Hi!!"; //Variable used in lambda expression should be final or effectively final
            System.out.println(saluteText + name );
        };
        greetService1.sayMessage("John");
    }
}

class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
       Thread thread = new Thread(()-> System.out.println("This is a child thread..."));
       thread.start();
       Thread.sleep(100);
       System.out.println("This is a main thread...");
    }
}

class ListSortLambdaExpressionTest {
    public static void main(String[] args) {
        Comparator<Integer> comparator2 = (x, y) -> x > y ? -1 : x > y ? 1 : 0;
        List<Integer> list = Arrays.asList(1,4,43,95,2,33,27,8);
        list.sort(comparator2);
        System.out.println(list);
    }
}

class AnonymousClassTest {
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



