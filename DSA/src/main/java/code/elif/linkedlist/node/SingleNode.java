package code.elif.linkedlist.node;

import java.util.Objects;

public class SingleNode<T> implements Node<T>{

    public T value;
    public SingleNode<T> nextSingleNode;


    public SingleNode(T value, SingleNode<T> nextSingleNodeReference) {
        this.value = value;
        this.nextSingleNode = nextSingleNodeReference;
    }

    public SingleNode() {
    }

    public SingleNode(T value) {

    }

    @Override
    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "SingleNode{" +
                "value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SingleNode)) return false;
        SingleNode<?> singleNode = (SingleNode<?>) o;
        return value.equals(singleNode.value) &&
                Objects.equals(nextSingleNode, singleNode.nextSingleNode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, nextSingleNode);
    }
}
