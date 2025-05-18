package code.elif.datastructure.linkedlist;

import code.elif.datastructure.linkedlist.node.DoubleNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DoubleLinkedList<T> implements LinkedList<T> {

    private static final Logger logger = LoggerFactory.getLogger(DoubleLinkedList.class);

    private DoubleNode<T> head;
    private DoubleNode<T> tail;

    public DoubleLinkedList(T value) {
        DoubleNode<T> blankNode = new DoubleNode<>(null,
                value, null);
        head = blankNode;
        tail = blankNode;
    }

    public void addNode(int position, T value) {
        if (position == 0) {
            DoubleNode<T> newNode = new DoubleNode<>(null, value, head);
            head.previousNode = newNode;
            head = newNode;
        } else if (position == -1) {
            DoubleNode<T> newNode = new DoubleNode<>(tail, value, null);
            tail.nextNode = newNode;
            tail = newNode;
        } else {
            int location = 1;
            DoubleNode<T> tempNode = head;
            while (location < position) {
                tempNode = tempNode.nextNode;
                location++;
            }

            DoubleNode<T> newNode = new DoubleNode<>(tempNode, value, tempNode.nextNode);
            tempNode.nextNode = newNode;

            if (newNode.nextNode == null) {
                tail = newNode;
            }

        }
    }

    public void deleteNode(int position) {
        if (position == 0) {
            head = head.nextNode;
            head.previousNode = null;
        } else if (position == -1) {
            tail = tail.previousNode;
            tail.nextNode = null;
        } else {
            int index = 0;
            DoubleNode<T> tempNode = head;
            while (index != position && tempNode.nextNode != null) {
                tempNode = tempNode.nextNode;
                index++;
            }
            if (tempNode.previousNode != null) {
                tempNode.previousNode.nextNode = tempNode.nextNode;
            } else {
                head = tempNode.nextNode;
            }

            if (tempNode.nextNode != null) {
                tempNode.nextNode.previousNode = tempNode.previousNode;
            } else {
                tail = tempNode.previousNode;
            }
        }
        //delete node
    }

    @Override
    public void traverse() {
        if (head == null) {
            throw new IllegalStateException("LinkedList does not contain any node.");
        }
        DoubleNode<T> tempNode = head;
        while (tempNode.nextNode != tail) {
            logger.info((String) tempNode.value);
            tempNode = tempNode.nextNode;
        }
    }

    public int search(T i) {
        int index = 0;

        DoubleNode<T> node = head;
        while (node != null) {
            if (node.value.equals(i)) {
                return index;
            }
            index++;
            node = node.nextNode;
        }
        return -1;
    }

    public void traverseFromLast() {
        if (head == null) {
            throw new IllegalStateException("LinkedList does not contain any node.");
        }
        DoubleNode<T> tempNode = tail;
        System.out.print("NULL <-> ");
        while (tempNode.previousNode != head) {
            System.out.print(tempNode.value + " <-> ");
            tempNode = tempNode.previousNode;
        }
        System.out.print("NULL");
    }

    @Override
    public void deleteLinkedList() {
        DoubleNode temp = head;
        while (temp.nextNode != null) {
            temp.previousNode = null;
            temp = temp.nextNode;
        }
        tail = null;
        head = null;
    }

    public DoubleNode<T> getHead() {
        return head;
    }

    public DoubleNode<T> getTail() {
        return tail;
    }

}
