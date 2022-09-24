package code.elif.linkedlist;

public interface LinkedList<T> {
    void addNode(int position, T value);
    void deleteNode(int position);
    void traverse();
    int search(T value);
    void deleteLinkedList();

}
