package code.elif;

public class EagerSingleton {

    private EagerSingleton() {
    }

    private static EagerSingleton INSTANCE = new EagerSingleton();

    public static EagerSingleton getInstance(){
        return INSTANCE;
    }

}
