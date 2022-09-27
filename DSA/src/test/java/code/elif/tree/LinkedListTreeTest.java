package code.elif.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LinkedListTreeTest {

    Tree<Integer> tree;

    @BeforeEach
    void init() {
        Node<Integer> childOfLeftNode = new Node<Integer>(null, 40, null);
        Node<Integer> leftNode = new Node<Integer>(childOfLeftNode, 20, null);
        Node<Integer> rightNode = new Node<Integer>(null, 30, null);
        Node<Integer> root = new Node<Integer>(leftNode, 10, rightNode);
        tree = new LinkedListTree<>(root);
    }

    @Test
    void traverseNode_preOrder() {
        List<Integer> list = tree.traverseAllNodes(Tree.Order.PRE_ORDER);
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(40, list.get(2));
        assertEquals(30, list.get(3));
    }

    @Test
    void traverseNode_postOrder() {
        List<Integer> list = tree.traverseAllNodes(Tree.Order.POST_ORDER);
        assertEquals(40, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));
        assertEquals(10, list.get(3));
    }

    @Test
    void traverseNode_inOrder() {
        List<Integer> list = tree.traverseAllNodes(Tree.Order.IN_ORDER);
        assertEquals(40, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(10, list.get(2));
        assertEquals(30, list.get(3));
    }

    @Test
    void traverseNode_levelOrder() {
        List<Integer> list = tree.traverseAllNodes(Tree.Order.LEVEL_ORDER);
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));
        assertEquals(40, list.get(3));
    }

}