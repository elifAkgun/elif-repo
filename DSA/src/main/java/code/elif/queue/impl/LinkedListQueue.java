package code.elif.queue.impl;

import code.elif.linkedlist.LinkedList;
import code.elif.linkedlist.SingleLinkedList;
import code.elif.queue.Queue;

public class LinkedListQueue<T> implements Queue<T> {

    LinkedList<T> queue;

    public LinkedListQueue() {
        queue = new SingleLinkedList<>();
    }

    @Override
    public boolean enQueue(T value) {
        queue.addNode(0, value);
        return true;
    }

    @Override
    public T deQueue() {
        if (queue.getHead() == null)
            throw new IllegalStateException("Queue is empty");

        T value = queue.getTail().getValue();
        queue.deleteNode(-1);

        return value;
    }

    @Override
    public T peekInQueue() {
        if (isEmpty())
            throw new IllegalStateException("Queue is empty");
        T value = queue.getTail().getValue();
        return value;
    }

    @Override
    public boolean isEmpty() {
        return queue == null || queue.getHead() == null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean deleteQueue() {
        queue = null;
        return true;
    }
}
