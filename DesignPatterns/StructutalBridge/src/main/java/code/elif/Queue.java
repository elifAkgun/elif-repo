package code.elif;

import code.elif.linkedList.LinkedList;

//A refined abstraction.
public class Queue<T> implements  FifoCollection<T> {

    LinkedList<T> linkedList;

    public Queue(LinkedList linkedList){
        this.linkedList = linkedList;
    }

    @Override
    public void offer(T t) {
        linkedList.addFirst(t);
    }

    @Override
    public T poll() {
        return linkedList.removeFirst();
    }
}
