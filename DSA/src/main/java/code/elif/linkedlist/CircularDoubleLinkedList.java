package code.elif.linkedlist;

import code.elif.linkedlist.node.DoubleNode;
import code.elif.linkedlist.node.Node;
import code.elif.linkedlist.node.SingleNode;

public class CircularDoubleLinkedList<T> implements LinkedList<T> {

    public DoubleNode<T> head;
    public DoubleNode<T> tail;

    public CircularDoubleLinkedList(T value) {
        DoubleNode blankNode = new DoubleNode<>(null, value, null);
        blankNode.previousNode = blankNode;
        blankNode.nextNode = blankNode;
        head = blankNode;
        tail = blankNode;
    }

    @Override
    public void addNode(int position, T value) {
        if (position == 0) {
            DoubleNode newNode = new DoubleNode(tail, value, head);
            head.previousNode = newNode;
            head = newNode;
            tail.nextNode = newNode;

        } else if (position == -1) { //last node
            DoubleNode newNode = new DoubleNode(tail, value, head);
            tail.nextNode = newNode;
            tail = newNode;
            head.previousNode = newNode;
        } else {
            int index = 0;
            DoubleNode temp = head;
            while (index != position && temp.nextNode != head) {
                temp = temp.nextNode;
                index++;
            }

            DoubleNode newNode = new DoubleNode(temp, value, temp.nextNode);
            temp.nextNode.previousNode = newNode;
            temp.nextNode = newNode;

            if (newNode.nextNode == head) {
                tail = temp.nextNode;
            }

            if (newNode.previousNode == tail) {
                head = temp.previousNode;
            }

        }
    }

    @Override
    public void deleteNode(int position) {
        if (position == 0) {
            head.nextNode.previousNode = head.previousNode;
            head.previousNode.nextNode = head.nextNode;
            head = head.nextNode;
        } else if (position == -1) {
            tail.previousNode.nextNode = tail.nextNode;
            tail.nextNode.previousNode = tail.previousNode;
            tail = tail.previousNode;
        } else {
            int index = 0;
            DoubleNode tempNode = head;
            while (index != position && tempNode.nextNode != head) {
                tempNode = tempNode.nextNode;
                index++;
            }

            tempNode.previousNode.nextNode = tempNode.nextNode;
            tempNode.nextNode.previousNode = tempNode.previousNode;

            if (tempNode.nextNode == head) {
                tail = tempNode.previousNode;
            }
        }
    }

    @Override
    public void traverse() {
        DoubleNode tempNode = head;
        System.out.print("<-> ");
        while (tempNode.nextNode != head) {
            System.out.print(tempNode.value + " <-> ");
            tempNode = tempNode.nextNode;
        }
    }

    @Override
    public int search(T value) {
        DoubleNode tempNode = head;

        if (tempNode == null) {
            return -1;
        }

        int index = 0;
        while (tempNode.nextNode != head) {
            if (value.equals(tempNode.value)) {
                return index;
            }
            tempNode = tempNode.nextNode;
            index++;
        }
        return -1;
    }

    @Override
    public void deleteLinkedList() {
        DoubleNode temp = head;
        tail.nextNode = null;
        while (temp.nextNode != null) {
            temp.previousNode = null;
            temp = temp.nextNode;
        }
        tail = null;
        head = null;
    }

    @Override
    public DoubleNode<T> getHead() {
        return head;
    }

    @Override
    public DoubleNode<T> getTail() {
        return tail;
    }
}
