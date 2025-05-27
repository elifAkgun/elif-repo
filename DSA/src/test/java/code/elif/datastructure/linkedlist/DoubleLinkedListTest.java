package code.elif.datastructure.linkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class DoubleLinkedListTest {
    private static DoubleLinkedList<Integer> doubleLinkedList;

    @BeforeEach
    public void init() {
        doubleLinkedList = new DoubleLinkedList<>(10);
        doubleLinkedList.addNode(1, 20);
        doubleLinkedList.addNode(2, 30);
        doubleLinkedList.addNode(3, 40);
    }

    @Test
    void initializeDoubleLinkedList() {
        assertEquals(10, doubleLinkedList.getHead().value);
        assertEquals(40, doubleLinkedList.getTail().value);
    }

    @Test
    void addNode_addNewNodeAsFirstNode() {
        doubleLinkedList.addNode(0, 11);
        assertEquals(11, doubleLinkedList.getHead().value);
        assertEquals(10, doubleLinkedList.getHead().nextNode.value);
        assertEquals(11, doubleLinkedList.getHead().nextNode.previousNode.value);
    }

    @Test
    void addNode_addNewNodeAsLastNode() {
        doubleLinkedList.addNode(-1, 11);
        assertEquals(11, doubleLinkedList.getTail().value);
        assertEquals(40, doubleLinkedList.getTail().previousNode.value);
        assertEquals(11, doubleLinkedList.getTail().previousNode.nextNode.value);
    }

    @Test
    void addNode_addNewNodeAsInternalNode() {
        doubleLinkedList.addNode(1, 11);
        doubleLinkedList.addNode(2, 12);
        assertEquals(10, doubleLinkedList.getHead().value);
        assertEquals(11, doubleLinkedList.getHead().nextNode.value);
        assertEquals(12, doubleLinkedList.getHead().nextNode.nextNode.value);
        assertEquals(40, doubleLinkedList.getTail().value);
        assertEquals(30, doubleLinkedList.getTail().previousNode.value);
        assertEquals(20, doubleLinkedList.getTail().previousNode.previousNode.value);
    }

    @Test
    void searchNode_nonExistValue() {
        doubleLinkedList.addNode(1, 11);
        assertEquals(-1, doubleLinkedList.search(1));
    }

    @Test
    void searchNode_ExistValue() {
        doubleLinkedList.addNode(1, 11);
        assertEquals(1, doubleLinkedList.search(11));
    }

    @Test
    void searchNode_AfterMultipleAddition() {
        doubleLinkedList.addNode(1, 11);
        doubleLinkedList.addNode(1, 8);
        doubleLinkedList.addNode(1, 9);
        assertEquals(3, doubleLinkedList.search(11));
    }

    @Test
    void deleteNode() {
        doubleLinkedList.addNode(1, 11);
        doubleLinkedList.deleteNode(1);
        assertEquals(-1, doubleLinkedList.search(1));
    }

    @Test
    void deleteNode_lastNode() {
        doubleLinkedList.deleteNode(4);
        assertEquals(-1, doubleLinkedList.search(40));
        assertEquals(30, doubleLinkedList.getTail().value);
    }

    @Test
    void deleteNode_firstNode() {
        doubleLinkedList.deleteNode(0);
        assertEquals(-1, doubleLinkedList.search(10));
        assertEquals(20, doubleLinkedList.getHead().value);
    }

    @Test
    void deleteNode_middleNode() {
        doubleLinkedList.deleteNode(1);
        assertEquals(-1, doubleLinkedList.search(20));
        assertEquals(10, doubleLinkedList.getHead().value);
        assertEquals(30, doubleLinkedList.getHead().nextNode.value);
        assertEquals(10, doubleLinkedList.getHead().nextNode.previousNode.value);
    }

    @Test
    void traverseFromLast() {
        doubleLinkedList.traverseFromLast();
    }

    @Test
    void deleteLinkedList() {
        doubleLinkedList.deleteLinkedList();
        assertNull(doubleLinkedList.getHead());
    }
}