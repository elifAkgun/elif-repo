package code.elif.datastructure.tree;

import java.util.List;

public interface Tree<T extends Comparable> {

    enum Order {
        PRE_ORDER,
        IN_ORDER,
        POST_ORDER,
        LEVEL_ORDER
    }

    Node<T> insertNode(T value);

    boolean deleteNode(Node<T> root, T value);

    Node<T> search(T value);

    int getIndex(T value);

    Tree<T>  mirrorTree();

    List<T> traverseAllNodes(LinkedListTree.Order orderType);

    boolean deleteTree();

}
