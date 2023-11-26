package code.elif.datastructure.linkedlist;

import code.elif.datastructure.linkedlist.CircularDoubleLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CircularDoubleLinkedListTest {

    private static CircularDoubleLinkedList<Integer> circularDoubleLinkedList;


    @BeforeEach
    public void init() {
        circularDoubleLinkedList = new CircularDoubleLinkedList<>(10);
        circularDoubleLinkedList.addNode(1, 20);
        circularDoubleLinkedList.addNode(2, 30);
        circularDoubleLinkedList.addNode(3, 40);
    }

    @Test
    void addNode() {
        Assertions.assertEquals(40, circularDoubleLinkedList.head.previousNode.value);
        Assertions.assertEquals(10, circularDoubleLinkedList.head.value);
        Assertions.assertEquals(20, circularDoubleLinkedList.head.nextNode.value);
        Assertions.assertEquals(40, circularDoubleLinkedList.tail.value);
        Assertions.assertEquals(10, circularDoubleLinkedList.tail.nextNode.value);
    }

    @Test
    void addNode_AsAFirstNode() {
        circularDoubleLinkedList.addNode(0, 21);
        Assertions.assertEquals(40, circularDoubleLinkedList.head.previousNode.value);
        Assertions.assertEquals(21, circularDoubleLinkedList.head.value);
        Assertions.assertEquals(10, circularDoubleLinkedList.head.nextNode.value);
        Assertions.assertEquals(40, circularDoubleLinkedList.tail.value);
        Assertions.assertEquals(21, circularDoubleLinkedList.tail.nextNode.value);
    }

    @Test
    void deleteNode() {
        circularDoubleLinkedList.deleteNode(0);
        Assertions.assertEquals(-1, circularDoubleLinkedList.search(10));
        circularDoubleLinkedList.addNode(0, 10);
        Assertions.assertEquals(1, circularDoubleLinkedList.search(20));
        circularDoubleLinkedList.deleteNode(1);
        Assertions.assertEquals(-1, circularDoubleLinkedList.search(20));
        circularDoubleLinkedList.deleteNode(40);
        Assertions.assertEquals(-1, circularDoubleLinkedList.search(40));
        Assertions.assertEquals(30, circularDoubleLinkedList.tail.value);
    }

    @Test
    void traverse() {
        circularDoubleLinkedList.traverse();
    }

    @Test
    void search() {
    }

    @Test
    void deleteLinkedList() {
        circularDoubleLinkedList.deleteLinkedList();
        Assertions.assertEquals(-1, circularDoubleLinkedList.search(10));
    }
}