package code.elif.datastructure.stack.impl;

import code.elif.datastructure.stack.Stack;

import java.lang.reflect.Array;

public class StackArray<T> implements Stack<T> {
    T[] stack;
    int stackSize;
    int capacity;

    public StackArray(Class<T> clazz, int capacity) {
        stack = (T[]) Array.newInstance(clazz, capacity);
        this.capacity = capacity;
    }

    @Override
    public boolean push(T value) {
        stack[stackSize] = value;
        stackSize++;
        return true;
    }

    @Override
    public T pop() {
        if(stackSize==0){
            throw  new IllegalStateException("There is no element in the stack");
        }
        T t = stack[stackSize-1];
        stackSize--;
        return t;
    }

    @Override
    public T peek() {
        return stack[stackSize-1];
    }

    @Override
    public boolean isEmpty() {
        return stackSize == 0;
    }

    @Override
    public boolean isFull() {
        return stackSize == capacity;
    }

    @Override
    public boolean deleteStack() {
        stack = null;
        return true;
    }
}
