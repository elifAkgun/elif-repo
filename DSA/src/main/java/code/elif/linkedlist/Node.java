package code.elif.linkedlist;

import java.util.Objects;

public class Node<T> {

    T value;
    Node<T> nextNode;


    public Node(T value, Node<T> nextNodeReference) {
        this.value = value;
        this.nextNode = nextNodeReference;
    }

    public Node() {
    }

    public Node(T value) {

    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node<?> node = (Node<?>) o;
        return value.equals(node.value) &&
                Objects.equals(nextNode, node.nextNode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, nextNode);
    }
}
