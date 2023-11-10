package code.elif.tree;

import org.apache.spark.internal.config.R;

import java.util.List;

public class NewTree<T extends Comparable> implements Tree<T> {

    private Node<T> root;

    public NewTree(Node<T> root) {
        this.root = root;
    }


    @Override
    public Node<T> insertNode(T value) {
        return insertNode(value, root);
    }

    private Node<T> insertNode(T value, Node root) {
        if (root == null) {
            return new Node<T>(null, value, null);
        }
        int comparison = value.compareTo(root.value);

        if (comparison < 0) {
            root.leftNode = insertNode(value, root.leftNode);
        } else if (comparison > 0) {
            root.rightNode = insertNode(value, root.rightNode);
        }
        return root;
    }

    @Override
    public boolean deleteNode(Node<T> root, T value) {
        return false;
    }

    @Override
    public Node<T> search(T value) {
        return null;
    }

    @Override
    public int getIndex(T value) {
        return 0;
    }

    @Override
    public Tree<T> mirrorTree() {
        return null;
    }

    @Override
    public List<T> traverseAllNodes(Order orderType) {
        return null;
    }

    @Override
    public boolean deleteTree() {
        return false;
    }
}
