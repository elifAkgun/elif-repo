package code.elif.threads.semaphore;

import java.util.concurrent.Semaphore;

public class Main14 {

    Semaphore full = new Semaphore(0);
    Semaphore empty = new Semaphore(1);
    String item = null;

}
