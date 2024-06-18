package code.elif.datastructure.stack.impl;

import code.elif.datastructure.linkedlist.LinkedList;
import code.elif.datastructure.linkedlist.SingleLinkedList;
import code.elif.datastructure.stack.Stack;

public class StackLinkedList<T> implements Stack<T> {

    LinkedList<T> stack;


    public StackLinkedList() {
        stack = new SingleLinkedList<>();
    }


    @Override
    public boolean push(T value) {
        stack.addNode(0, value);
        return true;
    }

    @Override
    public T pop() {
        if (stack.getHead() == null)
            throw new IllegalStateException("There is no element in the stack");

        T value = stack.getHead().getValue();
        stack.deleteNode(0);
        return value;
    }

    @Override
    public T peek() {
        if (stack.getHead() == null)
            throw new IllegalStateException("There is no element in the stack");

        T value = stack.getHead().getValue();
        return value;
    }

    @Override
    public boolean isEmpty() {
        return stack.getHead() == null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean deleteStack() {
        stack.deleteLinkedList();
        return true;
    }
}
