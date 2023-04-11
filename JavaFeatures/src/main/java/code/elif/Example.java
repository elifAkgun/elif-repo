package code.elif;

import java.util.concurrent.atomic.AtomicInteger;

public class Example {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(10);
        atomicInteger.compareAndSet(10, 20);
        System.out.println(atomicInteger.get());

        atomicInteger.compareAndSet(10, 30);
        System.out.println(atomicInteger.get());
    }
}
