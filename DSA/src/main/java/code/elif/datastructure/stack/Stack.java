package code.elif.datastructure.stack;

public interface Stack<T> {

    boolean push(T value);

    T pop();

    T peek();

    boolean isEmpty();

    boolean isFull();

    boolean deleteStack();
}
