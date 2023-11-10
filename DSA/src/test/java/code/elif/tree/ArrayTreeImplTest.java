package code.elif.tree;

import code.elif.tree.exception.TreeNodeNotFoundException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayTreeImplTest {
    @Test
    public void givenValidTreeNodes_whenInsertCalled_thenReturnTrue() {
        // given- precondition or setup
        ArrayTree<Integer> integerTree = new ArrayTreeImpl<>(3);

        // when - action or the behaviour that we are going test
        integerTree.insertNode(10);
        integerTree.insertNode(1);
        integerTree.insertNode(2);
        integerTree.insertNode(3);
        integerTree.insertNode(32);

        // then - verify the output
        assertEquals(10, integerTree.getValue(1));
        assertEquals(1, integerTree.getValue(2));
        assertEquals(2, integerTree.getValue(3));
        assertEquals(3, integerTree.getValue(4));
        assertEquals(32, integerTree.getValue(5));
    }

    @Test
    public void givenValidTreeNodes_whenSearchCalled_thenValidateSearchBehaviour() {
        // given- precondition or setup
        ArrayTree<Integer> integerTree = new ArrayTreeImpl<>(3);

        // when - action or the behaviour that we are going test
        integerTree.insertNode(10);
        integerTree.insertNode(1);
        integerTree.insertNode(2);
        integerTree.insertNode(3);
        integerTree.insertNode(32);

        // then - verify the output
        assertEquals(5, integerTree.search(32));
        assertThrowsExactly(TreeNodeNotFoundException.class, () -> integerTree.search(5));
    }

    @Test
    public void givenValidTreeNodes_whenTraverseCalledWithPreOrder_thenReturnPreOrderedArray() {
        // given- precondition or setup
        ArrayTree<Integer> integerTree = new ArrayTreeImpl<>(3);

        // when - action or the behaviour that we are going test
        integerTree.insertNode(10);
        integerTree.insertNode(20);
        integerTree.insertNode(30);
        integerTree.insertNode(40);
        integerTree.insertNode(50);
        integerTree.insertNode(60);
        integerTree.insertNode(70);

        List<Integer> integerArrayTree = integerTree.traverseAllNodes(Tree.Order.PRE_ORDER);

        // then - verify the output
        assertEquals(10, integerArrayTree.get(0));
        assertEquals(20, integerArrayTree.get(1));
        assertEquals(40, integerArrayTree.get(2));
        assertEquals(50, integerArrayTree.get(3));
        assertEquals(30, integerArrayTree.get(4));
        assertEquals(60, integerArrayTree.get(5));
        assertEquals(70, integerArrayTree.get(6));
    }

    @Test
    public void givenValidTreeNodes_whenTraverseCalledWithPostOrder_thenReturnPostOrderedArray() {
        // given- precondition or setup
        ArrayTree<Integer> integerTree = new ArrayTreeImpl<>(3);

        // when - action or the behaviour that we are going test
        integerTree.insertNode(10);
        integerTree.insertNode(20);
        integerTree.insertNode(30);
        integerTree.insertNode(40);
        integerTree.insertNode(50);
        integerTree.insertNode(60);
        integerTree.insertNode(70);

        List<Integer> integerArrayTree = integerTree.traverseAllNodes(Tree.Order.POST_ORDER);

        // then - verify the output
        assertEquals(40, integerArrayTree.get(0));
        assertEquals(50, integerArrayTree.get(1));
        assertEquals(20, integerArrayTree.get(2));
        assertEquals(60, integerArrayTree.get(3));
        assertEquals(70, integerArrayTree.get(4));
        assertEquals(30, integerArrayTree.get(5));
        assertEquals(10, integerArrayTree.get(6));
    }

    @Test
    public void givenValidTreeNodes_whenTraverseCalledWithInOrder_thenReturnPostOrderedArray() {
        // given- precondition or setup
        ArrayTree<Integer> integerTree = new ArrayTreeImpl<>(3);

        // when - action or the behaviour that we are going test
        integerTree.insertNode(10);
        integerTree.insertNode(20);
        integerTree.insertNode(30);
        integerTree.insertNode(40);
        integerTree.insertNode(50);
        integerTree.insertNode(60);
        integerTree.insertNode(70);

        List<Integer> list = integerTree.traverseAllNodes(Tree.Order.IN_ORDER);

        // then - verify the output
        assertEquals(40, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(50, list.get(2));
        assertEquals(10, list.get(3));
        assertEquals(60, list.get(4));
        assertEquals(30, list.get(5));
        assertEquals(70, list.get(6));
    }

    @Test
    public void givenValidTreeNodes_whenTraverseCalledWithLevelOrder_thenReturnLevelOrderedArray() {
        // given- precondition or setup
        ArrayTree<Integer> integerTree = new ArrayTreeImpl<>(3);

        // when - action or the behaviour that we are going test
        integerTree.insertNode(10);
        integerTree.insertNode(20);
        integerTree.insertNode(30);
        integerTree.insertNode(40);
        integerTree.insertNode(50);
        integerTree.insertNode(60);
        integerTree.insertNode(70);

        List<Integer> list = integerTree.traverseAllNodes(Tree.Order.IN_ORDER);

        // then - verify the output
        assertEquals(40, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(50, list.get(2));
        assertEquals(10, list.get(3));
        assertEquals(60, list.get(4));
        assertEquals(30, list.get(5));
        assertEquals(70, list.get(6));
    }

}