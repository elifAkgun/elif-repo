package code.elif.datastructure.queue.impl;

import code.elif.datastructure.queue.Queue;

import java.lang.reflect.Array;

public class LinearArrayQueue<T> implements Queue<T> {

    T[] queue;
    int capacity;
    int beginningOfQueue = -1;
    int topOfQueue = -1;

    public LinearArrayQueue(Class<T> clazz, int capacity) {
        queue = (T[]) Array.newInstance(clazz, capacity);
        this.capacity = capacity;
    }

    @Override
    public boolean enQueue(T value) {
        if (this.isFull())
            throw new IllegalStateException("Queue is full.");

        if (beginningOfQueue == -1)
            beginningOfQueue = 0;

        queue[++topOfQueue] = value;
        return true;
    }

    @Override
    public T deQueue() {
        if (this.isEmpty())
            throw new IllegalStateException("Queue is empty.");

        T value = queue[beginningOfQueue];
        queue[beginningOfQueue] = null;

        if (beginningOfQueue >= topOfQueue)
            beginningOfQueue = topOfQueue = -1;
        else
            beginningOfQueue++;

        return value;
    }

    @Override
    public T peekInQueue() {
        if (this.isEmpty())
            throw new IllegalStateException("Queue is empty.");

        return queue[beginningOfQueue];
    }

    @Override
    public boolean isEmpty() {
        return beginningOfQueue == -1;
    }

    @Override
    public boolean isFull() {
        return topOfQueue == capacity - 1;
    }

    @Override
    public boolean deleteQueue() {
        queue = null;
        beginningOfQueue =-1;
        topOfQueue =-1;
        return true;
    }
}
