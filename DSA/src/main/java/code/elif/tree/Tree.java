package code.elif.tree;

import java.util.List;

public interface Tree<T> {

    enum Order {
        PRE_ORDER,
        IN_ORDER,
        POST_ORDER,
        LEVEL_ORDER
    }

    boolean insertNode(T value);

    boolean deleteNode(Node<T> root, T value);

    Node<T> search(T value);

    int getIndex(T value);

    Tree<T>  mirrorTree();

    List<T> traverseAllNodes(LinkedListTree.Order orderType);

    boolean deleteTree();

}
