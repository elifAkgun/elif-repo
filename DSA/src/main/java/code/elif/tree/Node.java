package code.elif.tree;

import code.elif.tree.exception.UnsupportedTreeDataException;
import org.apache.hadoop.shaded.com.google.common.collect.Comparators;

import javax.activation.UnsupportedDataTypeException;
import java.util.Comparator;


public class Node<T extends Comparable> implements Comparable<T> {
    Node<T> leftNode;
    Node<T> rightNode;
    T value;


    public Node(Node<T> leftNode, T value, Node<T> rightNode) {
        this.leftNode = leftNode;
        this.value = value;
        this.rightNode = rightNode;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }


    @Override
    public int compareTo(T o) {
        Comparable<T> thisValue = (Comparable<T>) this.value;
        Comparable<T> otherValue = (Comparable<T>) o;
        return thisValue.compareTo((T) otherValue);

    }
}
