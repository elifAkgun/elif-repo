package code.elif.linkedlist;

import code.elif.linkedlist.node.SingleNode;

public class CircularSingleLinkedList<T> implements LinkedList<T> {
    private SingleNode<T> head;
    private SingleNode<T> tail;

    public CircularSingleLinkedList(T value) {
        SingleNode<T> blankSingleNode = new SingleNode<>(value, null);
        blankSingleNode.nextSingleNode = blankSingleNode;
        this.head = blankSingleNode;
        this.tail = blankSingleNode;
        this.tail.nextSingleNode = head;
    }

    @Override
    public void addNode(int position, T value) {
        if (position == 0) {
            SingleNode<T> newSingleNode = new SingleNode<>(value, head);
            this.head = newSingleNode;
            if (this.tail != null) {
                this.tail.nextSingleNode = head;
            } else {
                this.tail = head.nextSingleNode;
            }

        } else if (position == -1) { // last position
            SingleNode<T> newSingleNode = new SingleNode<>(value, head);
            tail.nextSingleNode = newSingleNode;
            tail = newSingleNode;
        } else {
            int location = 0;
            SingleNode<T> tempSingleNode = head;
            while (location < position - 1) {
                tempSingleNode = tempSingleNode.nextSingleNode;
                location++;
            }
            SingleNode<T> newSingleNode = new SingleNode<>(value, tempSingleNode.nextSingleNode);
            tempSingleNode.nextSingleNode = newSingleNode;
            if (tempSingleNode.nextSingleNode.nextSingleNode == head) {
                tail = tempSingleNode.nextSingleNode;
            }
        }
    }

    @Override
    public void deleteNode(int position) {
        if (position == 0) {
            head = head.nextSingleNode;
            tail.nextSingleNode = head;

            if (head.nextSingleNode == head) {
                head.nextSingleNode = null;
                head = null;
                tail = null;
            }

        } else if (position == -1) {
            SingleNode<T> tempSingleNode = head;
            while (tempSingleNode.nextSingleNode.nextSingleNode != head) {
                tempSingleNode = tempSingleNode.nextSingleNode;
            }
            tempSingleNode.nextSingleNode = null;
            tail = tempSingleNode;
        } else {
            int location = 0;
            SingleNode<T> tempSingleNode = head;
            while (location < position - 1 && tempSingleNode.nextSingleNode != head) {
                tempSingleNode = tempSingleNode.nextSingleNode;
                location++;
            }
            tempSingleNode.nextSingleNode = tempSingleNode.nextSingleNode.nextSingleNode;
            if (tempSingleNode.nextSingleNode == head) {
                tail = tempSingleNode;
            }
        }
    }

    @Override
    public void traverse() {
        if (head == null) {
            throw new IllegalStateException("LinkedList does not contain any node.");
        }
        SingleNode<T> tempSingleNode = head;
        while (tempSingleNode.nextSingleNode != head) {
            System.out.println(tempSingleNode);
            tempSingleNode = tempSingleNode.nextSingleNode;
        }
    }

    @Override
    public int search(T value) {
        if (head == null) {
            throw new IllegalStateException("LinkedList does not contain any node.");
        }
        SingleNode<T> tempSingleNode = head;
        int index = 0;
        while (tempSingleNode.nextSingleNode != head) {
            if (tempSingleNode.value.equals(value)) {
                return index;
            }
            tempSingleNode = tempSingleNode.nextSingleNode;
            index++;
        }
        return -1;
    }

    @Override
    public void deleteLinkedList() {
        head = null;
        tail = null;
    }

    public SingleNode<T> getHead() {
        return head;
    }

    public SingleNode<T> getTail() {
        return tail;
    }

}
