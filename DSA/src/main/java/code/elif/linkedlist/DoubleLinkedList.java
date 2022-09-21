package code.elif.linkedlist;

public class DoubleLinkedList<T> {

    private DoubleNode<T> head;
    private DoubleNode<T> tail;

    public DoubleLinkedList(T value) {
        DoubleNode<T> blankNode = new DoubleNode<>(null,
                value, null);
        head = blankNode;
        tail = blankNode;
    }

    public boolean addNode(int position, T value) {
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
        return true;
    }


    public DoubleNode<T> getHead() {
        return head;
    }

    public DoubleNode<T> getTail() {
        return tail;
    }

    public void deleteNode(int index) {
        //delete node
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
}
