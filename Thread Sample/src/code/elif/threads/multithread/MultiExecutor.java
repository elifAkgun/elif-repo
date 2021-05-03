package code.elif.threads.multithread;

import java.util.ArrayList;
import java.util.List;

public class MultiExecutor {

    // Add any necessary member variables here
    List<Thread> tasks;

    /*
     * @param tasks to executed concurrently
     */
    public MultiExecutor(List<Thread> tasks) {
        this.tasks = tasks;
    }

    /**
     * Starts and executes all the tasks concurrently
     */
    public void executeAll() {
        for (Thread t : tasks) {
            t.start();
        }
    }
}