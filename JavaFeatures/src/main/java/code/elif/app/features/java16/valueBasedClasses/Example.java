package code.elif.app.features.java16.valueBasedClasses;

public class Example {

    public static void main(String[] args) {
        Integer i = 10;

        synchronized (i){
            System.out.println(i);
        }
    }
}
