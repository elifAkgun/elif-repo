package code.elif.linkedlist.node;

import java.util.Objects;

public class DoubleNode<T> implements Node<T>{

    public DoubleNode<T> previousNode;
    public T value;
    public DoubleNode<T> nextNode;

    public DoubleNode(DoubleNode<T> previousNode, T value, DoubleNode<T> nextNode) {
        this.previousNode = previousNode;
        this.value = value;
        this.nextNode = nextNode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DoubleNode)) return false;
        DoubleNode<?> that = (DoubleNode<?>) o;
        return Objects.equals(previousNode, that.previousNode) &&
                Objects.equals(value, that.value) &&
                Objects.equals(nextNode, that.nextNode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(previousNode, value, nextNode);
    }

    @Override
    public T getValue() {
        return value;
    }
}
