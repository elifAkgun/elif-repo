package code.elif.threads.atomicreference;

import java.util.concurrent.atomic.AtomicReference;

public class Main17 {

    public static void main(String[] args) {
        String oldValue = "old value";
        String newValue = "new value";

        AtomicReference<String> atomicReference = new AtomicReference<>(oldValue);

        atomicReference.set("other value");

        if(atomicReference.compareAndSet(oldValue,newValue)){
            System.out.println("new value is " + atomicReference.get());
        }
        else {
            System.out.println("nothing changed.");
        }
    }
}
