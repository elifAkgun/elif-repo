package code.elif.linkedlist;

import code.elif.linkedlist.node.Node;

public class CircularSingleLinkedList<T> implements LinkedList<T>{
    private Node<T> head;
    private Node<T> tail;

    public CircularSingleLinkedList(T value) {
        Node<T> blankNode = new Node<>(value, null);
        blankNode.nextNode = blankNode;
        this.head = blankNode;
        this.tail = blankNode;
        this.tail.nextNode = head;
    }

    @Override
    public void addNode(int position ,T value) {
        if (position ==0) {
            Node<T> newNode = new Node<>(value, head);
            this.head = newNode;
            if (this.tail != null) {
                this.tail.nextNode = head;
            } else {
                this.tail = head.nextNode;
            }

        } else if (position == -1) { // last position
            Node<T> newNode = new Node<>(value, head);
            tail.nextNode = newNode;
            tail = newNode;
        } else {
            int location = 0;
            Node<T> tempNode = head;
            while (location < position - 1) {
                tempNode = tempNode.nextNode;
                location++;
            }
            Node<T> newNode = new Node<>(value, tempNode.nextNode);
            tempNode.nextNode = newNode;
            if (tempNode.nextNode.nextNode == head) {
                tail = tempNode.nextNode;
            }
        }
    }

    @Override
    public void deleteNode(int position) {
        if (position == 0) {
            head = head.nextNode;
            tail.nextNode = head;

            if (head.nextNode == head) {
                head.nextNode = null;
                head = null;
                tail = null;
            }


        } else if (position == -1) {
            Node<T> tempNode = head;
            while (tempNode.nextNode.nextNode != head) {
                tempNode = tempNode.nextNode;
            }
            tempNode.nextNode = null;
            tail = tempNode;
        } else {
            int location = 0;
            Node<T> tempNode = head;
            while (location < position - 1 && tempNode.nextNode != head) {
                tempNode = tempNode.nextNode;
                location++;
            }
            tempNode.nextNode = tempNode.nextNode.nextNode;
            if (tempNode.nextNode == head) {
                tail = tempNode;
            }
        }
    }

    @Override
    public void traverse() {
        if (head == null) {
            throw new IllegalStateException("LinkedList does not contain any node.");
        }
        Node<T> tempNode = head;
        while (tempNode.nextNode != tail) {
            System.out.println(tempNode);
            tempNode = tempNode.nextNode;
        }
    }

    @Override
    public int search(T value) {
        if (head == null) {
            throw new IllegalStateException("LinkedList does not contain any node.");
        }
        Node<T> tempNode = head;
        int index = 0;
        while (tempNode.nextNode != head) {
            if (tempNode.value.equals(value)) {
                return index;
            }
            tempNode = tempNode.nextNode;
            index++;
        }
        return -1;
    }

    @Override
    public void deleteLinkedList() {
        head = null;
        tail.nextNode = null;
        tail = null;
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }
}
