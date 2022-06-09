package code.elif;

public class Client {

    public static void main(String[] args) {
        EagerSingleton eager1 =  EagerSingleton.getInstance();;
        EagerSingleton eager2 =  EagerSingleton.getInstance();;

        System.out.println(eager1 != eager2
                ? "They are not in the same reference"
                : "Two objects are equal");

        LazySingletonDoubleCheckLocking lazy1 = LazySingletonDoubleCheckLocking.getInstance();
        LazySingletonDoubleCheckLocking lazy2 = LazySingletonDoubleCheckLocking.getInstance();

        System.out.println(lazy1 != lazy2
                ? "They are not in the same reference"
                : "Two objects are equal");

        LazySingletonWithInnerClass lazyInner1 = LazySingletonWithInnerClass.getInstance();
        LazySingletonWithInnerClass lazyInner2 = LazySingletonWithInnerClass.getInstance();

        System.out.println(lazyInner1 != lazyInner2
                ? "They are not in the same reference"
                : "Two objects are equal");

        EnumSingleton enumSingleton1 = EnumSingleton.INSTANCE;
        EnumSingleton enumSingleton2 = EnumSingleton.INSTANCE;

        System.out.println(enumSingleton1 != enumSingleton2
                ? "They are not in the same reference"
                : "Two objects are equal");
    }
}
