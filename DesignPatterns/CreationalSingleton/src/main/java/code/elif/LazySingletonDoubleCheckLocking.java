package code.elif;

public class LazySingletonDoubleCheckLocking {

    private LazySingletonDoubleCheckLocking() {
    }

    private static volatile LazySingletonDoubleCheckLocking INSTANCE; // (3) because of the two threads access possibility
    //we do not want to use cached version of this variable's value

    public static LazySingletonDoubleCheckLocking getInstance() {
        if (INSTANCE == null) {
            // (1) when 2 threads come this line,
            // one of them pass the other one still waits.
            synchronized (LazySingletonDoubleCheckLocking.class) {
                //(2) first thread initialized the instance but second one cannot realized it.
                //in order to avoid this situation, we can check the INSTANCE
                if (INSTANCE == null) {
                    INSTANCE = new LazySingletonDoubleCheckLocking();
                }
            }
        }
        return INSTANCE;
    }
}
