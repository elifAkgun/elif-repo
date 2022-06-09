package code.elif;

public class LazySingletonWithInitializationHolder {
    private LazySingletonWithInitializationHolder() {
    }

    private static class InnerClass{
       static LazySingletonWithInitializationHolder INSTANCE = new LazySingletonWithInitializationHolder();
    }

    public static LazySingletonWithInitializationHolder getInstance(){
        return InnerClass.INSTANCE;
    }
}
