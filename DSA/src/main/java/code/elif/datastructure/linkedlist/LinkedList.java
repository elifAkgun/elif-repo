package code.elif.datastructure.linkedlist;

import code.elif.datastructure.linkedlist.node.Node;

public interface LinkedList<T> {

    void addNode(int position, T value);

    void deleteNode(int position);

    void traverse();

    int search(T value);

    void deleteLinkedList();

    Node<T> getHead();

    Node<T> getTail();

}
