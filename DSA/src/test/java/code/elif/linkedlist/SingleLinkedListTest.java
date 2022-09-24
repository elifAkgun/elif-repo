package code.elif.linkedlist;

import code.elif.linkedlist.node.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class SingleLinkedListTest {

    private static SingleLinkedList<Integer> singleLinkedList;

    @BeforeEach
    void init() {
        singleLinkedList = new SingleLinkedList<Integer>();

        singleLinkedList.addNode(0, 10);
        singleLinkedList.addNode(1, 20);
        singleLinkedList.addNode(2, 30);
    }

    @Test
    void addNode() {
        Assertions.assertEquals(10, singleLinkedList.getHead().value);
        Assertions.assertEquals(30, singleLinkedList.getTail().value);

    }

    @Test
    void addNode_asAFirstElement() {
        singleLinkedList.addNode(0,1);
        Assertions.assertEquals(1, singleLinkedList.getHead().value);
        Assertions.assertEquals(10, singleLinkedList.getHead().nextNode.value);
    }

    @Test
    void addNode_hasOneNodeListAddAsAFirstElement() {
        singleLinkedList.deleteNode(0);
        singleLinkedList.addNode(0,1);
        Assertions.assertEquals(1, singleLinkedList.getHead().value);
        Assertions.assertEquals(20, singleLinkedList.getHead().nextNode.value);
    }

    @Test
    void search_givenNode() {
        Assertions.assertEquals(1, singleLinkedList.search(20));
    }

    @Test
    void delete() {
        singleLinkedList.deleteNode(1);
        Assertions.assertEquals(-1, singleLinkedList.search(20));
    }

    @Test
    void delete_firstNode() {
        singleLinkedList.deleteNode(0);
        Assertions.assertEquals(-1, singleLinkedList.search(10));
    }

    @Test
    void delete_lastNode() {
        singleLinkedList.deleteNode(2);
        Assertions.assertEquals(-1, singleLinkedList.search(30));
    }

    @Test
    void delete_internalNode() {
        singleLinkedList.deleteNode(1);
        Assertions.assertEquals(-1, singleLinkedList.search(20));
    }

    @Test
    void delete_whenDeleteLastNode_thenTailChangedWithNewTail() {
        singleLinkedList.deleteNode(2);
        Assertions.assertEquals(20, singleLinkedList.getTail().value);
    }

    @Test
    void delete_whenDeleteFirstNode_thenHeadChangedWithNewNode() {
        singleLinkedList.deleteNode(0);
        Assertions.assertEquals(20, singleLinkedList.getHead().value);
    }

    @Test
    void deleteLinkedList_whenDeleteLinkedListThenHeadAndTailWillBeNull() {
        singleLinkedList.deleteLinkedList();
        Assertions.assertEquals(null, singleLinkedList.getHead());
        Assertions.assertEquals(null, singleLinkedList.getTail());
    }

    @Test
    void search_whenDeleteLinkedListThenNodesAreRemovedThrowException() {
        singleLinkedList.deleteLinkedList();
        IllegalStateException thrown = Assertions.assertThrows(IllegalStateException.class,
                () -> singleLinkedList.search(10));
        Assertions.assertEquals("LinkedList does not contain any node.",
                thrown.getMessage());
    }
}