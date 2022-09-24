package code.elif.linkedlist;

import code.elif.linkedlist.node.Node;

import java.util.HashSet;
import java.util.Set;

public class SingleLinkedList<T> implements LinkedList<T> {

    private Node<T> head;
    private Node<T> tail;

    public SingleLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addNode(int position,T value) {
        if (position == 0) {
            Node<T> newNode = new Node<>(value, head);
            this.head = newNode;
        } else if (position == -1) { // last position
            Node<T> newNode = new Node<>(value, null);
            tail.nextNode = newNode;
            tail = newNode;
        } else {
            int location = 0;
            Node<T> tempNode = head;
            while (location < position && tempNode.nextNode != null) {
                tempNode = tempNode.nextNode;
                location++;
            }
            Node<T> newNode = new Node<>(value, tempNode.nextNode);
            tempNode.nextNode = newNode;

            if (newNode.nextNode == null) {
                tail = newNode;
            }
        }
    }

    public void deleteNode(int position) {
        if (position ==0) {
            head = head.nextNode;
        } else if (position == -1) { // last position
            Node<T> tempNode = head;
            while (tempNode.nextNode.nextNode != null) {
                tempNode = tempNode.nextNode;
            }
            tempNode.nextNode = null;
            tail = tempNode;
        } else {
            int location = 0;
            Node<T> tempNode = head;
            while (location < position - 1 && tempNode.nextNode != null) {
                tempNode = tempNode.nextNode;
                location++;
            }
            tempNode.nextNode = tempNode.nextNode.nextNode;
            if (tempNode.nextNode == null) {
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

    public int search(T value) {
        if (head == null) {
            throw new IllegalStateException("LinkedList does not contain any node.");
        }
        Node<T> tempNode = head;
        int index = 0;
        while (tempNode.nextNode != null) {
            tempNode = tempNode.nextNode;
            index++;
            if (tempNode.value.equals(value)) {
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
        Node<T> tempNode = head;
        while (tempNode.nextNode != null) {
            s.append(tempNode.nextNode);
            tempNode = tempNode.nextNode;
        }
        s.append('}');
        return s.toString();
    }

    public void deleteLinkedList() {
        head = null;
        tail = null;
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }
}