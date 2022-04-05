package code.elif.app.features.interfaceFeature;

public class DefaultMethodTest implements Left, Right {
    @Override
    public void m1() {
        Left.super.m1();
    }
}

interface Left {
    default void m1() {
        System.out.println("This is Left");
    }
}

interface Right {
    default void m1() {
        System.out.println("This is Right");
    }
}
