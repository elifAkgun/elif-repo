package code.elif.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LinkedListTreeTest {

    LinkedListTree<Integer> tree;

    @BeforeEach
    void init() {

        Node<Integer> childOfLeftNode2 = new Node<Integer>(null, 50, null);
        Node<Integer> childOfLeftNode = new Node<Integer>(null, 40, null);
        Node<Integer> leftNode = new Node<Integer>(childOfLeftNode, 20, childOfLeftNode2);
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
        assertEquals(50, list.get(3));
        assertEquals(30, list.get(4));
    }

    @Test
    void traverseNode_postOrder() {
        List<Integer> list = tree.traverseAllNodes(Tree.Order.POST_ORDER);
        assertEquals(40, list.get(0));
        assertEquals(50, list.get(1));
        assertEquals(20, list.get(2));
        assertEquals(30, list.get(3));
        assertEquals(10, list.get(4));
    }

    @Test
    void traverseNode_inOrder() {
        List<Integer> list = tree.traverseAllNodes(Tree.Order.IN_ORDER);
        assertEquals(40, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(50, list.get(2));
        assertEquals(10, list.get(3));
        assertEquals(30, list.get(4));
    }

    @Test
    void traverseNode_levelOrder() {
        List<Integer> list = tree.traverseAllNodes(Tree.Order.LEVEL_ORDER);
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));
        assertEquals(40, list.get(3));
    }

    @Test
    void search() {
        assertEquals(0, tree.searchValue(10));
        assertEquals(1, tree.searchValue(20));
        assertEquals(2, tree.searchValue(30));
        assertEquals(3, tree.searchValue(40));
    }

    @Test
    void traverse_levelOrder() {
        Node<Integer> node4 = new Node<Integer>(null, 50, null);
        Node<Integer> node3 = new Node<Integer>(null, 40, node4);
        Node<Integer> node2 = new Node<Integer>(node3, 30, null);
        Node<Integer> node1 = new Node<Integer>(null, 20, node2);
        Node<Integer> root = new Node<Integer>(node1, 10, null);
        tree = new LinkedListTree<>(root);


        List<List<Integer>> lists = tree.levelOrderLevel(tree.root);
        System.out.print(lists);
        assertEquals(5, lists.size());
    }

    @Test
    void traverse_levelOrder2() {
        Node<Integer> node4 = new Node<Integer>(null, 50, null);
        Node<Integer> node3 = new Node<Integer>(null, 40, null);
        Node<Integer> node2 = new Node<Integer>(null, 30, node4);
        Node<Integer> node1 = new Node<Integer>(node3, 20, null);
        Node<Integer> root = new Node<Integer>(node1, 10, node2);
        tree = new LinkedListTree<>(root);


        List<List<Integer>> lists = tree.levelOrderLevel(tree.root);
        System.out.print(lists);
        assertEquals(3, lists.size());
    }

    @Test
    void traverse_levelOrder3() {
        Node<Integer> node9 = new Node<Integer>(null, 8, null);
        Node<Integer> node8 = new Node<Integer>(null, 6, null);
        Node<Integer> node7 = new Node<Integer>(null, 1, null);
        Node<Integer> node6 = new Node<Integer>(null, 5, null);
        Node<Integer> node5 = new Node<Integer>(null, -1, node9);
        Node<Integer> node4 = new Node<Integer>(null, 3, node8);
        Node<Integer> node3 = new Node<Integer>(node6, 1, node7);
        Node<Integer> node2 = new Node<Integer>(node4, 4, node5);
        Node<Integer> node1 = new Node<Integer>(node3, 2, null);
        Node<Integer> root = new Node<Integer>(node1, 0, node2);
        tree = new LinkedListTree<>(root);


        List<List<Integer>> lists = tree.levelOrderLevel(tree.root);
        System.out.print(lists);
        assertEquals(4, lists.size());
    }

}