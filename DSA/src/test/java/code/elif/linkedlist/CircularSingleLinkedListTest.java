package code.elif.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class CircularSingleLinkedListTest {

    private static CircularSingleLinkedList<Integer> circularSingleLinkedList;


    @BeforeEach
    void init() {
        circularSingleLinkedList = new CircularSingleLinkedList<>(10);
        circularSingleLinkedList.addNode(1,20);
        circularSingleLinkedList.addNode(2,30);
    }

    @Test
    void addNode() {
        Assertions.assertEquals(10, circularSingleLinkedList.getHead().value);
        Assertions.assertEquals(30, circularSingleLinkedList.getTail().value);
    }

    @Test
    void addNode_asAFirstElement() {
        circularSingleLinkedList.addNode(0,1);
        Assertions.assertEquals(1, circularSingleLinkedList.getHead().value);
        Assertions.assertEquals(10, circularSingleLinkedList.getHead().nextSingleNode.value);
        Assertions.assertEquals(1, circularSingleLinkedList.getTail().nextSingleNode.value);
    }

    @Test
    void deleteNode_hasOneNodeListAddAsAFirstElement() {
        circularSingleLinkedList.deleteNode(0);
        Assertions.assertEquals(20, circularSingleLinkedList.getHead().value);
        Assertions.assertEquals(30, circularSingleLinkedList.getHead().nextSingleNode.value);
    }
    @Test
    void deleteNode_whichHasOnlyOneNodeInList() {
        circularSingleLinkedList.deleteNode(2);
        circularSingleLinkedList.deleteNode(1);
        circularSingleLinkedList.deleteNode(0);
        Assertions.assertNull(circularSingleLinkedList.getHead());
    }

    @Test
    void delete_AllNodes_thenAddNewNode() {
        circularSingleLinkedList.deleteNode(2);
        circularSingleLinkedList.deleteNode(1);
        circularSingleLinkedList.deleteNode(0);
        circularSingleLinkedList.addNode(0,10);
        Assertions.assertEquals(10, circularSingleLinkedList.getHead().value);
    }

    @Test
    void delete_tailNode_thenTailUpdatedWithNewValue() {
        circularSingleLinkedList.deleteNode(2);
        Assertions.assertEquals(20, circularSingleLinkedList.getTail().value);
        Assertions.assertEquals(10, circularSingleLinkedList.getTail().nextSingleNode.value);
    }

    @Test
    void delete_HeadNode_thenTailUpdatedWithNewValue() {
        circularSingleLinkedList.deleteNode(0);
        Assertions.assertEquals(30, circularSingleLinkedList.getTail().value);
        Assertions.assertEquals(20, circularSingleLinkedList.getTail().nextSingleNode.value);
    }

    @Test
    void search() {
        circularSingleLinkedList.addNode(2,40);

        int index = circularSingleLinkedList.search(10);
        Assertions.assertEquals(0,index);

        index = circularSingleLinkedList.search(20);
        Assertions.assertEquals(1,index);

        index = circularSingleLinkedList.search(40);
        Assertions.assertEquals(2,index);
    }
    @Test
    void search_whenDeleteLinkedListThenNodesAreRemovedThrowException() {
        circularSingleLinkedList.deleteLinkedList();
        IllegalStateException thrown = Assertions.assertThrows(IllegalStateException.class,
                () -> circularSingleLinkedList.search(10));
        Assertions.assertEquals("LinkedList does not contain any node.",
                thrown.getMessage());
    }

    @Test
    void deleteLinkedList_whenDeleteLinkedListThenHeadAndTailWillBeNull() {
        circularSingleLinkedList.deleteLinkedList();
        Assertions.assertNull(circularSingleLinkedList.getHead());
        Assertions.assertNull(circularSingleLinkedList.getTail());
    }

}