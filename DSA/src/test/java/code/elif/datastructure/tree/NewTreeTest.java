package code.elif.datastructure.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NewTreeTest {

    @Test
    public void givenValidTreeNodes_whenInsertCalled_thenReturnTrue() {
        // given- precondition or setup
        Node<Integer> root = new Node<>(null, 5, null);
        Tree<Integer> integerTree = new NewTree<>(root);

        // when - action or the behaviour that we are going test

        integerTree.insertNode(10);
        integerTree.insertNode(1);
        integerTree.insertNode(2);
        integerTree.insertNode(3);

        // then - verify the output
        assertEquals(1, root.leftNode.value);
        assertEquals(5, root.value);
        assertEquals(2, root.leftNode.rightNode.value);
        assertEquals(3, root.leftNode.rightNode.rightNode.value);
        assertEquals(10, root.rightNode.value);


    }
}