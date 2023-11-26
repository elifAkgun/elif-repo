package code.elif.datastructure.linkedlist;

import code.elif.datastructure.linkedlist.SingleLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class SingleLinkedListTest {

    private static SingleLinkedList<Integer> singleLinkedList;

    @BeforeEach
    void init() {
        singleLinkedList = new SingleLinkedList<>();
    }

    @Test
    void addNode() {
        singleLinkedList.addNode(0, 10);
        singleLinkedList.addNode(1, 20);
        singleLinkedList.addNode(2, 30);
        Assertions.assertEquals(10, singleLinkedList.getHead().value);
        Assertions.assertEquals(30, singleLinkedList.getTail().value);
    }

    @Test
    void addNode_asAFirstElement() {
        singleLinkedList.addNode(0, 10);
        singleLinkedList.addNode(1, 20);
        singleLinkedList.addNode(2, 30);
        singleLinkedList.addNode(0,1);
        Assertions.assertEquals(1, singleLinkedList.getHead().value);
        Assertions.assertEquals(10, singleLinkedList.getHead().nextSingleNode.value);
    }

    @Test
    void addNode_hasOneNodeListAddAsAFirstElement() {
        singleLinkedList.addNode(0, 10);
        singleLinkedList.addNode(1, 20);
        singleLinkedList.addNode(2, 30);
        singleLinkedList.deleteNode(0);
        singleLinkedList.addNode(0,1);
        Assertions.assertEquals(1, singleLinkedList.getHead().value);
        Assertions.assertEquals(20, singleLinkedList.getHead().nextSingleNode.value);
    }

    @Test
    void search_givenNode() {
        singleLinkedList.addNode(0, 10);
        singleLinkedList.addNode(1, 20);
        singleLinkedList.addNode(2, 30);
        Assertions.assertEquals(1, singleLinkedList.search(20));
    }

    @Test
    void delete() {
        singleLinkedList.addNode(0, 10);
        singleLinkedList.addNode(1, 20);
        singleLinkedList.addNode(2, 30);
        singleLinkedList.deleteNode(1);
        Assertions.assertEquals(-1, singleLinkedList.search(20));
    }

    @Test
    void delete_firstNode() {
        singleLinkedList.addNode(0, 10);
        singleLinkedList.addNode(1, 20);
        singleLinkedList.addNode(2, 30);
        singleLinkedList.deleteNode(0);
        Assertions.assertEquals(-1, singleLinkedList.search(10));
    }

    @Test
    void delete_lastNode() {
        singleLinkedList.addNode(0, 10);
        singleLinkedList.addNode(1, 20);
        singleLinkedList.addNode(2, 30);
        singleLinkedList.deleteNode(2);
        Assertions.assertEquals(-1, singleLinkedList.search(30));
    }
    @Test
    void delete_firstNodeHasOnlySingleNode() {
        singleLinkedList.addNode(0, 10);
        singleLinkedList.deleteNode(0);
        Assertions.assertNull(singleLinkedList.getHead());
        Assertions.assertNull(singleLinkedList.getTail());
    }

    @Test
    void delete_lastNodeHasOnlySingleNode() {
        singleLinkedList.addNode(0, 10);
        singleLinkedList.deleteNode(-1);
        Assertions.assertNull(singleLinkedList.getHead());
        Assertions.assertNull(singleLinkedList.getTail());
    }

    @Test
    void delete_internalNode() {
        singleLinkedList.addNode(0, 10);
        singleLinkedList.addNode(1, 20);
        singleLinkedList.addNode(2, 30);
        singleLinkedList.deleteNode(1);
        Assertions.assertEquals(-1, singleLinkedList.search(20));
    }

    @Test
    void delete_whenDeleteLastNode_thenTailChangedWithNewTail() {
        singleLinkedList.addNode(0, 10);
        singleLinkedList.addNode(1, 20);
        singleLinkedList.addNode(2, 30);
        singleLinkedList.deleteNode(2);
        Assertions.assertEquals(20, singleLinkedList.getTail().value);
    }

    @Test
    void delete_whenDeleteFirstNode_thenHeadChangedWithNewNode() {
        singleLinkedList.addNode(0, 10);
        singleLinkedList.addNode(1, 20);
        singleLinkedList.addNode(2, 30);
        singleLinkedList.deleteNode(0);
        Assertions.assertEquals(20, singleLinkedList.getHead().value);
    }

    @Test
    void deleteLinkedList_whenDeleteLinkedListThenHeadAndTailWillBeNull() {
        singleLinkedList.addNode(0, 10);
        singleLinkedList.addNode(1, 20);
        singleLinkedList.addNode(2, 30);
        singleLinkedList.deleteLinkedList();
        Assertions.assertEquals(null, singleLinkedList.getHead());
        Assertions.assertEquals(null, singleLinkedList.getTail());
    }

    @Test
    void search_whenDeleteLinkedListThenNodesAreRemovedThrowException() {
        singleLinkedList.addNode(0, 10);
        singleLinkedList.addNode(1, 20);
        singleLinkedList.addNode(2, 30);
        singleLinkedList.deleteLinkedList();
        IllegalStateException thrown = Assertions.assertThrows(IllegalStateException.class,
                () -> singleLinkedList.search(10));
        Assertions.assertEquals("LinkedList does not contain any node.",
                thrown.getMessage());
    }
}