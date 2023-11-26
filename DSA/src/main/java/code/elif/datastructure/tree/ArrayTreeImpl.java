package code.elif.datastructure.tree;

import code.elif.datastructure.tree.exception.*;

import java.util.ArrayList;
import java.util.List;

public class ArrayTreeImpl<T extends Comparable> implements ArrayTree<T> {

    private int insertionIndex;
    private T[] root;
    private int size;

    public ArrayTreeImpl(int depth) {
        int size = (int) Math.pow(2, depth);
        this.root = (T[]) new Comparable[size];
        this.size = size;
        this.insertionIndex = 1;
    }

    @Override
    public T[] insertNode(T value) {
        if (insertionIndex == size) {
            throw new ArrayTreeFullException();
        } else if (root[insertionIndex] == null) {
            root[insertionIndex] = value;
        } else if (root[insertionIndex + 1] == null) {
            root[insertionIndex + 1] = value;
        }
        insertionIndex = insertionIndex + 1;
        return root;
    }

    @Override
    public T[] insertNode(T value, int index) {
        if (root[index] != null) {
            throw new ArrayTreeInvalidIndexException();
        }
        root[index] = value;
        return root;
    }

    @Override
    public boolean deleteNode(T value) {
        for (int i = 0; i < size; i++) {
            if (value == root[i]) {
                root[i] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteNode(int index) {
        if (index > size || index < 1) {
            throw new ArrayTreeInvalidIndexException();
        }
        root[index] = null;
        return true;
    }

    @Override
    public int search(T value) {
        for (int i = 0; i < insertionIndex; i++) {
            if (root[i] == value) {
                return i;
            }
        }
        throw new TreeNodeNotFoundException();
    }

    @Override
    public T getValue(int index) {
        return root[index];
    }

    @Override
    public ArrayTree<T> mirrorTree() {
        return null;
    }


    @Override
    public List<T> traverseAllNodes(Tree.Order orderType) {
        List<T> list = new ArrayList<>();

        if (root == null)
            throw new TreeNotExistsException();

        switch (orderType) {
            case PRE_ORDER: {
                preOrderTraverse(1, list);
                return list;
            }
            case IN_ORDER: {
                inOrderTraverse(1,list);
                return list;
            }
            case POST_ORDER: {
                postOrderTraverse(1, list);
                return list;
            }
            case LEVEL_ORDER: {
                return levelOrderTraverse();
            }
        }
        throw new TreeOrderTypeIsNotValidException();
    }

    private void preOrderTraverse(int index, List<T> list) {
        if (index >= insertionIndex) {
            return;
        }
        list.add(root[index]);
        preOrderTraverse(index * 2, list);
        preOrderTraverse(index * 2 + 1, list);
    }

    private void postOrderTraverse(int index, List<T> list) {
        if (index >= insertionIndex) {
            return;
        }
        postOrderTraverse(index * 2, list);
        postOrderTraverse(index * 2 + 1, list);
        list.add(root[index]);
    }

    private void inOrderTraverse(int index, List<T> list) {
        if (index >= insertionIndex) {
            return;
        }
        inOrderTraverse(index * 2, list);
        list.add(root[index]);
        inOrderTraverse(index * 2 + 1, list);

    }

    private List<T> levelOrderTraverse() {
        return List.of(root);
    }

    @Override
    public boolean deleteTree() {
        return false;
    }
}
