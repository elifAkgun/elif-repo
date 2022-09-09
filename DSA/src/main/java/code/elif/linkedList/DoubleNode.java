package code.elif.linkedList;

import java.util.Objects;

public class DoubleNode<T> {

    DoubleNode<T> previousNode;
    T value;
    DoubleNode<T> nextNode;

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
}
