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
        if (root == null) {
            root = new Node<T>(null, value, null);
            return true;
        }

        Queue<Node<T>> queue = new LinkedListQueue<>();
        queue.enQueue(root);
        while (!queue.isEmpty()) {
            Node<T> node = queue.deQueue();
            if (node != null) {
                if (node.leftNode == null) {
                    node.leftNode = new Node<T>(null, value, null);
                    return true;
                } else if (node.rightNode == null) {
                    node.rightNode = new Node<T>(null, value, null);
                    return true;
                }
                queue.enQueue(node.leftNode);
                queue.enQueue(node.rightNode);
            }
        }
        return false;
    }

    @Override
    public boolean deleteNode(Node<T> root, T value) {
        if (this.root == null) {
            throw new IllegalStateException("Tree is empty.");
        }
        if (value == null) {
            return false;
        }
        Node<T> deletedNode = search(value);
        if (deletedNode != null) {
            Node<T> deepestNode = getDeepestNode();
            deletedNode.value = deepestNode.value;
            deepestNode.value = null;
            return true;
        }
        return false;
    }

    private Node<T> getDeepestNode() {
        Node<T> deepestNode = root;
        Queue<Node<T>> queue = new LinkedListQueue<>();
        queue.enQueue(root);
        while (!queue.isEmpty()) {
            Node<T> node = queue.deQueue();
            if (node != null) {
                queue.enQueue(node.leftNode);
                queue.enQueue(node.rightNode);
                deepestNode = node;
            }
        }
        return deepestNode;
    }

    @Override
    public int getIndex(T value) {
        if (root == null) {
            throw new IllegalStateException("Tree is empty.");
        }
        Queue<Node<T>> queue = new LinkedListQueue<>();
        queue.enQueue(root);
        int index = 1;
        while (!queue.isEmpty()) {
            Node<T> node = queue.deQueue();
            if (node != null && node.value == value) {
                return index;
            } else if (node != null) {
                queue.enQueue(node.leftNode);
                queue.enQueue(node.rightNode);
            }
            index++;
        }
        return -1;
    }

    @Override
    public Node<T> search(T value) {
        if (root == null) {
            throw new IllegalStateException("Tree is empty.");
        }
        Queue<Node<T>> queue = new LinkedListQueue<>();
        queue.enQueue(root);
        while (!queue.isEmpty()) {
            Node<T> node = queue.deQueue();
            if (node != null && node.value == value) {
                return node;
            } else if (node != null) {
                queue.enQueue(node.leftNode);
                queue.enQueue(node.rightNode);
            }
        }
        return null;
    }

    @Override
    public Tree<T> mirrorTree() {
        if (root == null) {
            throw new IllegalStateException("Tree is empty.");
        }
        reverseNode(root);
        return new LinkedListTree<T>(root);
    }

    public Node<T> reverseNode(Node<T> node) {
        if (node == null)
            return null;

        reverseNode(node.leftNode);
        reverseNode(node.rightNode);

        Node<T> tempNode = node.rightNode;
        node.rightNode = node.leftNode;
        node.leftNode = tempNode;

        return node;
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

    private void preOrderTraverse(Node<T> root, List<T> list) {
        if (root != null) {
            list.add(root.value);
            preOrderTraverse(root.leftNode, list);
            preOrderTraverse(root.rightNode, list);
        }
    }

    private void inOrderTraverse(Node<T> root, List<T> list) {
        if (root != null) {
            inOrderTraverse(root.leftNode, list);
            list.add(root.value);
            inOrderTraverse(root.rightNode, list);
        }
    }

    private void postOrderTraverse(Node<T> root, List<T> list) {
        if (root != null) {
            postOrderTraverse(root.leftNode, list);
            postOrderTraverse(root.rightNode, list);
            list.add(root.value);
        }
    }

    private void levelOrder(Node<T> root, List<T> list) {
        Queue<Node<T>> queue = new LinkedListQueue<>();
        queue.enQueue(root);
        while (!queue.isEmpty()) {
            Node<T> node = queue.deQueue();
            if (node != null) {
                queue.enQueue(node.leftNode);
                queue.enQueue(node.rightNode);
                list.add(node.value);
            }
        }
    }

    public List<List<T>> levelOrderLevel(Node<T> root) {
        List<List<T>> lists = new ArrayList<>();
        Queue<Node<T>> queue = new LinkedListQueue<>();

        queue.enQueue(root);
        while (!queue.isEmpty()) {
            int qSize = ((LinkedListQueue) queue).getSize();
            List<T> list = new ArrayList<>();
            for (int i = 0; i < qSize; i++) {
                Node<T> node = queue.deQueue();
                if (node != null) {
                    list.add(node.value);
                    queue.enQueue(node.leftNode);
                    queue.enQueue(node.rightNode);
                }
            }
            if (!list.isEmpty())
                lists.add(list);
        }
        return lists;
    }

    @Override
    public boolean deleteTree() {
        root = null;
        return true;
    }
}