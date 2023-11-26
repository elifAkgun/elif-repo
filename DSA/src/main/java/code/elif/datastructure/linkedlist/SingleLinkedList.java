package code.elif.datastructure.linkedlist;

import code.elif.datastructure.linkedlist.node.SingleNode;

public class SingleLinkedList<T> implements LinkedList<T> {

    private SingleNode<T> head;
    private SingleNode<T> tail;

    public SingleLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addNode(int position, T value) {
        SingleNode<T> newSingleNode;
        if (position == 0) {
            newSingleNode = new SingleNode<>(value, head);
            this.head = newSingleNode;
        } else if (position == -1) { // last position
            newSingleNode = new SingleNode<>(value, null);
            tail.nextSingleNode = newSingleNode;
            tail = newSingleNode;
        } else {
            int location = 0;
            SingleNode<T> tempSingleNode = head;
            while (location < position && tempSingleNode.nextSingleNode != null) {
                tempSingleNode = tempSingleNode.nextSingleNode;
                location++;
            }
            newSingleNode = new SingleNode<>(value, tempSingleNode.nextSingleNode);
            tempSingleNode.nextSingleNode = newSingleNode;
        }
        if (newSingleNode.nextSingleNode == null) {
            tail = newSingleNode;
        }
    }

    public void deleteNode(int position) {
        SingleNode<T> tempSingleNode;
        if (position == 0) {
            head = head.nextSingleNode;
            if(head==null){
                tail = null;
            }
        } else if (position == -1) { // last position
            tempSingleNode = head;
            while (tempSingleNode.nextSingleNode != null
                    && tempSingleNode.nextSingleNode.nextSingleNode != null) {
                tempSingleNode = tempSingleNode.nextSingleNode;
            }
            if (tempSingleNode.nextSingleNode == null) {
                tail = null;
                head = null;
            } else {
                tempSingleNode.nextSingleNode = null;
                tail = tempSingleNode;
            }
        } else {
            int location = 0;
            tempSingleNode = head;
            while (location < position - 1
                    && tempSingleNode.nextSingleNode != null) {
                tempSingleNode = tempSingleNode.nextSingleNode;
                location++;
            }
            tempSingleNode.nextSingleNode = tempSingleNode.nextSingleNode.nextSingleNode;
            if (tempSingleNode.nextSingleNode == null) {
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
        while (tempSingleNode.nextSingleNode != tail) {
            System.out.println(tempSingleNode);
            tempSingleNode = tempSingleNode.nextSingleNode;
        }
    }

    public int search(T value) {
        if (head == null) {
            throw new IllegalStateException("LinkedList does not contain any node.");
        }
        SingleNode<T> tempSingleNode = head;
        int index = 0;
        while (tempSingleNode.nextSingleNode != null) {
            tempSingleNode = tempSingleNode.nextSingleNode;
            index++;
            if (tempSingleNode.value.equals(value)) {
                return index;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("SingleLinkedList{")
                .append("head=" + head)
                .append(", tail=" + tail)
                .append(", next = {");
        SingleNode<T> tempSingleNode = head;
        while (tempSingleNode.nextSingleNode != null) {
            s.append(tempSingleNode.nextSingleNode);
            tempSingleNode = tempSingleNode.nextSingleNode;
        }
        s.append('}');
        return s.toString();
    }

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