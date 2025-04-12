package code.elif.datastructure.tree;

import java.util.List;

public interface Tree<T extends Comparable> {

    Node<T> insertNode(T value);

    boolean deleteNode(Node<T> root, T value);

    Node<T> search(T value);

    int getIndex(T value);

    Tree<T> mirrorTree();

    List<T> traverseAllNodes(LinkedListTree.Order orderType);

    boolean deleteTree();

    enum Order {
        PRE_ORDER,
        IN_ORDER,
        POST_ORDER,
        LEVEL_ORDER
    }

}
