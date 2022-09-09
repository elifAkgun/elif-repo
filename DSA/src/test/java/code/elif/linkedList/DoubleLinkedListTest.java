package code.elif.linkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DoubleLinkedListTest {
    private static DoubleLinkedList<Integer> doubleLinkedList;

    @BeforeEach
    public void init() {
        doubleLinkedList = new DoubleLinkedList<>(10);
    }

    @Test
    public void initializeDoubleLinkedList() {
        assertEquals(10, doubleLinkedList.getHead().value);
        assertEquals(10, doubleLinkedList.getTail().value);
    }

    @Test
    public void addNode_addNewNodeAsFirstNode() {
        doubleLinkedList.addNode(0, 11);
        assertEquals(11, doubleLinkedList.getHead().value);
        assertEquals(10, doubleLinkedList.getHead().nextNode.value);
        assertEquals(11, doubleLinkedList.getHead().nextNode.previousNode.value);
    }

    @Test
    public void addNode_addNewNodeAsLastNode() {
        doubleLinkedList.addNode(-1, 11);
        assertEquals(11, doubleLinkedList.getTail().value);
        assertEquals(10, doubleLinkedList.getTail().previousNode.value);
        assertEquals(11, doubleLinkedList.getTail().previousNode.nextNode.value);
    }
    @Test
    public void addNode_addNewNodeAsInternalNode() {
        doubleLinkedList.addNode(1, 11);
        doubleLinkedList.addNode(2, 12);
        assertEquals(10, doubleLinkedList.getHead().value);
        assertEquals(11, doubleLinkedList.getHead().nextNode.value);
        assertEquals(12, doubleLinkedList.getHead().nextNode.nextNode.value);
        assertEquals(12, doubleLinkedList.getTail().value);
        assertEquals(11, doubleLinkedList.getTail().previousNode.value);
        assertEquals(10, doubleLinkedList.getTail().previousNode.previousNode.value);
    }
}