package code.elif.datastructure.queue.impl;

import code.elif.datastructure.queue.Queue;

import java.lang.reflect.Array;

public class CircularArrayQueue<T> implements Queue<T> {

    T[] queue;
    int capacity;
    int beginningOfQueue = -1;
    int topOfQueue = -1;

    public CircularArrayQueue(Class<T> clazz, int capacity) {
        queue = (T[]) Array.newInstance(clazz, capacity);
        this.capacity = capacity;
    }

    @Override
    public boolean enQueue(T value) {
        if (isFull())
            throw new IllegalStateException("Queue is full.");

        if (beginningOfQueue == -1)
            beginningOfQueue = 0;

        if (topOfQueue + 1 == capacity)
            topOfQueue = 0;
        else
            topOfQueue++;

        queue[topOfQueue] = value;
        return true;
    }

    @Override
    public T deQueue() {
        if (isEmpty())
            throw new IllegalStateException("Queue is empty.");

        T value = queue[beginningOfQueue];
        queue[beginningOfQueue] = null;

        if (beginningOfQueue == topOfQueue) {
            topOfQueue = beginningOfQueue = -1;
        } else if (topOfQueue > capacity - 1) {
            beginningOfQueue = 0;
        } else {
            beginningOfQueue++;
        }
        return value;
    }

    @Override
    public T peekInQueue() {
        if (isEmpty())
            throw new IllegalStateException("Queue is empty.");

        return queue[beginningOfQueue];
    }

    @Override
    public boolean isEmpty() {
        return topOfQueue == -1;
    }

    @Override
    public boolean isFull() {
        if (topOfQueue + 1 == beginningOfQueue)
            return true;
        else if (beginningOfQueue == 0 && topOfQueue == capacity - 1)
            return true;

        return false;
    }

    @Override
    public boolean deleteQueue() {
        topOfQueue = -1;
        beginningOfQueue = -1;
        queue = null;
        return true;
    }
}
