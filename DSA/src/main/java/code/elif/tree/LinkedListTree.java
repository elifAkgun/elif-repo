package code.elif.tree;

import code.elif.queue.Queue;
import code.elif.queue.impl.LinkedListQueue;

import java.util.ArrayList;
import java.util.List;

public class LinkedListTree<T> implements Tree<T> {

    Node<T> root;


    public LinkedListTree(T value) {
        root.leftNode = null;
        root.rightNode = null;
        root.value = null;
    }

    public LinkedListTree(Node<T> root) {
        this.root = root;
    }

    @Override
    public boolean insertNode(T value) {
        return false;
    }

    @Override
    public boolean deleteNode(int index) {
        return false;
    }

    @Override
    public int searchValue(T value) {
        return 0;
    }

    @Override
    public List<T> traverseAllNodes(Order orderType) {
        List<T> list = new ArrayList<>();
        if (root == null)
            throw new IllegalStateException("Tree is empty");

        switch (orderType) {
            case PRE_ORDER: {
                preOrderTraverse(root, list);
                break;
            }
            case IN_ORDER: {
                inOrderTraverse(root, list);
                break;
            }
            case POST_ORDER: {
                postOrderTraverse(root, list);
                break;
            }
            case LEVEL_ORDER: {
                levelOrder(root, list);
                break;
            }
        }
        return list;
    }

    private List<T> preOrderTraverse(Node<T> root, List<T> list) {
        if (root != null) {
            list.add(root.value);
            preOrderTraverse(root.leftNode, list);
            preOrderTraverse(root.rightNode, list);
        }
        return list;
    }

    private List<T> inOrderTraverse(Node<T> root, List<T> list) {
        if (root != null) {
            inOrderTraverse(root.leftNode, list);
            list.add(root.value);
            inOrderTraverse(root.rightNode, list);
        }
        return list;
    }

    private List<T> postOrderTraverse(Node<T> root, List<T> list) {
        if (root != null) {
            postOrderTraverse(root.leftNode, list);
            postOrderTraverse(root.rightNode, list);
            list.add(root.value);
        }
        return list;
    }

    private List<T> levelOrder(Node<T> root, List<T> list) {
        Queue<Node<T>> queue = new LinkedListQueue<>();
        queue.enQueue(root);
        while (!queue.isEmpty()) {
            Node<T> node = queue.deQueue();
            if(node!= null) {
                queue.enQueue(node.leftNode);
                queue.enQueue(node.rightNode);
                list.add(node.value);
            }
        }
        return list;
    }


    @Override
    public boolean deleteTree() {
        return false;
    }
}
