package code.elif.linkedList;

public class SingleLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;

    public SingleLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addNode(Node<T> node, Integer position) {
        addNode(node.value, position);
    }

    public void addNode(T value, Integer position) {
        if (position.equals(0)) {
            Node<T> newNode = new Node<>(value, head);
            this.head = newNode;
        } else if (position.equals(-1)) { // last position
            Node<T> newNode = new Node<T>(value, null);
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

    public boolean deleteNode(int position) {
        if (position == 0) {
            head = head.nextNode;
        } else if (position == -1) {
            Node tempNode = head;
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
        return true;
    }

    public int search(T value) {
        if (head == null) {
            throw new IllegalStateException("LinkedList does not contain any node.");
        }
        Node tempNode = head;
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
        String s = "SingleLinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                ", next = {";
        Node tempNode = head;
        while (tempNode.nextNode != null) {
            s = s + tempNode.nextNode;
            tempNode = tempNode.nextNode;
        }
        s = s + '}';
        return s;
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
