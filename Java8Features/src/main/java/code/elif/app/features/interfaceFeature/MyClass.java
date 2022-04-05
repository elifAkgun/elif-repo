package code.elif.app.features.interfaceFeature;

public class MyClass implements StaticMethodInterface {

    public static void main(String[] args) {
      // MyClass.myMethod(); //Static method may be invoked on containing interface class only
        StaticMethodInterface.myMethod();

    }
}

interface StaticMethodInterface {
    public static void myMethod() {
        System.out.println("I'm a method which is static in interface!");
    }
}
