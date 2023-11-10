package code.elif.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LinkedListTreeTest {

    LinkedListTree<Integer> tree;

    @BeforeEach
    void init() {
        Node<Integer> childOfRightNode2 = new Node<>(null, 70, null);
        Node<Integer> childOfRightNode = new Node<>(null, 60, null);
        Node<Integer> childOfLeftNode2 = new Node<>(null, 50, null);
        Node<Integer> childOfLeftNode = new Node<>(null, 40, null);
        Node<Integer> leftNode = new Node<>(childOfLeftNode, 20, childOfLeftNode2);
        Node<Integer> rightNode = new Node<>(childOfRightNode, 30, childOfRightNode2);
        Node<Integer> root = new Node<>(leftNode, 10, rightNode);
        tree = new LinkedListTree<>(root);
    }

    @Test
    public void givenValidTreeNodes_whenInsertCalled_thenReturnTrue() {
        // given- precondition or setup
        Node<Integer> root = new Node<>(null, 5, null);
        Tree<Integer> integerTree = new LinkedListTree<>(root);

        // when - action or the behaviour that we are going test

        integerTree.insertNode(10);
        integerTree.insertNode(1);
        integerTree.insertNode(2);
        integerTree.insertNode(3);

        // then - verify the output
        assertEquals(10, root.leftNode.value);
        assertEquals(5, root.value);
        assertEquals(1,root.rightNode.value);

        List<Integer> integerList = integerTree.traverseAllNodes(Tree.Order.LEVEL_ORDER);
        System.out.println(integerList);


    }

    @Test
    void traverseNode_preOrder() {
        List<Integer> list = tree.traverseAllNodes(Tree.Order.PRE_ORDER);
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(40, list.get(2));
        assertEquals(50, list.get(3));
        assertEquals(30, list.get(4));
        assertEquals(60, list.get(5));
        assertEquals(70, list.get(6));
    }

    @Test
    void traverseNode_postOrder() {
        List<Integer> list = tree.traverseAllNodes(Tree.Order.POST_ORDER);
        assertEquals(40, list.get(0));
        assertEquals(50, list.get(1));
        assertEquals(20, list.get(2));
        assertEquals(60, list.get(3));
        assertEquals(70, list.get(4));
        assertEquals(30, list.get(5));
        assertEquals(10, list.get(6));
    }

    @Test
    void traverseNode_inOrder() {
        List<Integer> list = tree.traverseAllNodes(Tree.Order.IN_ORDER);
        assertEquals(40, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(50, list.get(2));
        assertEquals(10, list.get(3));
        assertEquals(60, list.get(4));
        assertEquals(30, list.get(5));
        assertEquals(70, list.get(6));
    }

    @Test
    void traverseNode_levelOrder() {
        List<Integer> list = tree.traverseAllNodes(Tree.Order.LEVEL_ORDER);
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));
        assertEquals(40, list.get(3));
        assertEquals(50, list.get(4));
        assertEquals(60, list.get(5));
        assertEquals(70, list.get(6));
    }

    @Test
    void search() {
        assertEquals(1, tree.getIndex(10));
        assertEquals(2, tree.getIndex(20));
        assertEquals(3, tree.getIndex(30));
        assertEquals(4, tree.getIndex(40));
    }

    @Test
    void traverse_levelOrder() {
        Node<Integer> node4 = new Node<>(null, 50, null);
        Node<Integer> node3 = new Node<>(null, 40, node4);
        Node<Integer> node2 = new Node<>(node3, 30, null);
        Node<Integer> node1 = new Node<>(null, 20, node2);
        Node<Integer> root = new Node<>(node1, 10, null);
        tree = new LinkedListTree<>(root);


        List<List<Integer>> lists = tree.levelOrderLevel(tree.root);
        System.out.print(lists);
        assertEquals(5, lists.size());
    }

    @Test
    void traverse_levelOrder2() {
        Node<Integer> node4 = new Node<>(null, 50, null);
        Node<Integer> node3 = new Node<>(null, 40, null);
        Node<Integer> node2 = new Node<>(null, 30, node4);
        Node<Integer> node1 = new Node<>(node3, 20, null);
        Node<Integer> root = new Node<>(node1, 10, node2);
        tree = new LinkedListTree<>(root);


        List<List<Integer>> lists = tree.levelOrderLevel(tree.root);
        System.out.print(lists);
        assertEquals(3, lists.size());
    }

    @Test
    void traverse_levelOrder3() {
        Node<Integer> node9 = new Node<>(null, 8, null);
        Node<Integer> node8 = new Node<>(null, 6, null);
        Node<Integer> node7 = new Node<>(null, 1, null);
        Node<Integer> node6 = new Node<>(null, 5, null);
        Node<Integer> node5 = new Node<>(null, -1, node9);
        Node<Integer> node4 = new Node<>(null, 3, node8);
        Node<Integer> node3 = new Node<>(node6, 1, node7);
        Node<Integer> node2 = new Node<>(node4, 4, node5);
        Node<Integer> node1 = new Node<>(node3, 2, null);
        Node<Integer> root = new Node<>(node1, 0, node2);
        tree = new LinkedListTree<>(root);


        List<List<Integer>> lists = tree.levelOrderLevel(tree.root);
        System.out.print(lists);
        assertEquals(4, lists.size());
    }

    @Test
    void insertNode() {
        tree.insertNode(60);
        int index = tree.getIndex(60);
        assertEquals(6, index);
    }

    @Test
    void deleteNode() {
        int index = tree.getIndex(50);
        assertEquals(5, index);

        tree.deleteNode(tree.root, 50);
        index = tree.getIndex(50);
        assertEquals(-1, index);
    }


    @Test
    void deleteNode2() {
        int index = tree.getIndex(40);
        assertEquals(4, index);

        tree.deleteNode(tree.root, 40);
        index = tree.getIndex(40);
        assertEquals(-1, index);
    }

    @Test
    void deleteNode3() {
        int index = tree.getIndex(10);
        assertEquals(1, index);

        tree.deleteNode(tree.root, 10);
        index = tree.getIndex(10);
        assertEquals(-1, index);
    }


    @Test
    void reverseNode() {
        Tree<Integer> integerTree = tree.mirrorTree();
        assertEquals(2,integerTree.getIndex(30));

    }

    @Test
    void deleteTree() {
        tree.deleteTree();
        assertEquals(null, tree.root);

    }
}