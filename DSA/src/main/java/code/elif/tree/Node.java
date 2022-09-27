package code.elif.tree;

public class Node<T> {
    Node<T> leftNode;
    Node<T> rightNode;
    T value;


    public Node(Node<T> leftNode, T value, Node<T> rightNode) {
        this.leftNode = leftNode;
        this.value = value;
        this.rightNode = rightNode;
    }
}
