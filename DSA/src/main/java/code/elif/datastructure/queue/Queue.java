package code.elif.datastructure.queue;

public interface Queue<T> {

    boolean enQueue(T value);

    T deQueue();

    T peekInQueue();

    boolean isEmpty();

    boolean isFull();

    boolean deleteQueue();
}
