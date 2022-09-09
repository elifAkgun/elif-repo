package code.elif.linkedList;

public class DoubleLinkedList<T> {

    private DoubleNode head;
    private DoubleNode tail;

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
            int location = 0;
            DoubleNode<T> tempNode = head;
            while (location < position && tempNode.nextNode != null) {
                tempNode = tempNode.nextNode;
                location++;
            }

            DoubleNode<T> newNode = new DoubleNode<>(tempNode, value, tempNode.nextNode);
            if (tempNode.nextNode != null) {
                tempNode.nextNode.previousNode = newNode;
            }

            tempNode.nextNode = newNode;

            if (newNode.nextNode == null) {
                tail = newNode;
            }

        }
        return true;
    }

    

    public DoubleNode getHead() {
        return head;
    }

    public DoubleNode getTail() {
        return tail;
    }
}
