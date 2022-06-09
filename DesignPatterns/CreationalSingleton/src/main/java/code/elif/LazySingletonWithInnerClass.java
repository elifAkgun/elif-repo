package code.elif;

public class LazySingletonWithInnerClass {
    private LazySingletonWithInnerClass() {
    }

    private static class InnerClass{
       static LazySingletonWithInnerClass INSTANCE = new LazySingletonWithInnerClass();
    }

    public static LazySingletonWithInnerClass getInstance(){
        return InnerClass.INSTANCE;
    }
}
