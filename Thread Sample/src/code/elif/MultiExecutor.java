import java.util.List;

public class MultiExecutor {

    // Add any necessary member variables here

    /*
     * @param tasks to executed concurrently
     */
    public MultiExecutor(List<Runnable> tasks) {
        for(Runnable r : tasks) {
            r.run();
        }
    }

    /**
     * Starts and executes all the tasks concurrently
     */
    public void executeAll() {
        // complete your code here
    }
}