package code.elif.linkedlist;

public class CircleSingleLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    public CircleSingleLinkedList(T value) {
        Node<T> blankNode = new Node<>(value, null);
        blankNode.nextNode = blankNode;
        this.head = blankNode;
        this.tail = blankNode;
        this.tail.nextNode = head;
    }

    public void addNode(T value, Integer position) {
        if (position.equals(0)) {
            Node<T> newNode = new Node<>(value, head);
            this.head = newNode;
            if (this.tail != null) {
                this.tail.nextNode = head;
            } else {
                this.tail = head.nextNode;
            }

        } else if (position.equals(-1)) { // last position
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
            tempNode.nextNode = new Node<>(value, tempNode.nextNode);
            if (tempNode.nextNode.nextNode == head) {
                tail = tempNode.nextNode;
            }
        }
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void deleteNode(Integer position) {
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
        while (tempNode.nextNode != head) {
            if (tempNode.value.equals(value)) {
                return index;
            }
            tempNode = tempNode.nextNode;
            index++;
        }
        return -1;
    }

    public void deleteLinkedList() {
        head = null;
        tail.nextNode = null;
        tail = null;
    }
}
