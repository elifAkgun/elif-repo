package code.elif.datastructure.tree;

import java.util.List;

public interface ArrayTree<T extends Comparable> {
    T[] insertNode(T value);

    T[] insertNode(T value, int index);

    boolean deleteNode(T value);

    boolean deleteNode(int index);

    int search(T value);


    T getValue(int index);

    ArrayTree<T> mirrorTree();

    List<T> traverseAllNodes(Tree.Order orderType);

    boolean deleteTree();
}
