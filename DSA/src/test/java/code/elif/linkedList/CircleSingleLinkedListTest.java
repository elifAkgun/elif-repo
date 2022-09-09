package code.elif.linkedList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class CircleSingleLinkedListTest {

    private static CircleSingleLinkedList<Integer> circleSingleLinkedList;


    @BeforeEach
    void init() {
        circleSingleLinkedList = new CircleSingleLinkedList<>(10);
        circleSingleLinkedList.addNode(20,1);
        circleSingleLinkedList.addNode(30,2);
    }

    @Test
    void addNode() {
        Assertions.assertEquals(10, circleSingleLinkedList.getHead().value);
        Assertions.assertEquals(30, circleSingleLinkedList.getTail().value);
    }

    @Test
    void addNode_asAFirstElement() {
        circleSingleLinkedList.addNode(1,0);
        Assertions.assertEquals(1, circleSingleLinkedList.getHead().value);
        Assertions.assertEquals(10, circleSingleLinkedList.getHead().nextNode.value);
        Assertions.assertEquals(1, circleSingleLinkedList.getTail().nextNode.value);
    }

    @Test
    void deleteNode_hasOneNodeListAddAsAFirstElement() {
        circleSingleLinkedList.deleteNode(0);
        Assertions.assertEquals(20, circleSingleLinkedList.getHead().value);
        Assertions.assertEquals(30, circleSingleLinkedList.getHead().nextNode.value);
    }
    @Test
    void deleteNode_whichHasOnlyOneNodeInList() {
        circleSingleLinkedList.deleteNode(2);
        circleSingleLinkedList.deleteNode(1);
        circleSingleLinkedList.deleteNode(0);
        Assertions.assertEquals(null, circleSingleLinkedList.getHead());
    }

    @Test
    void delete_AllNodes_thenAddNewNode() {
        circleSingleLinkedList.deleteNode(2);
        circleSingleLinkedList.deleteNode(1);
        circleSingleLinkedList.deleteNode(0);
        circleSingleLinkedList.addNode(10,0);
        Assertions.assertEquals(10, circleSingleLinkedList.getHead().value);
    }

    @Test
    void delete_tailNode_thenTailUpdatedWithNewValue() {
        circleSingleLinkedList.deleteNode(2);
        Assertions.assertEquals(20, circleSingleLinkedList.getTail().value);
        Assertions.assertEquals(10, circleSingleLinkedList.getTail().nextNode.value);
    }

    @Test
    void delete_HeadNode_thenTailUpdatedWithNewValue() {
        circleSingleLinkedList.deleteNode(0);
        Assertions.assertEquals(30, circleSingleLinkedList.getTail().value);
        Assertions.assertEquals(20, circleSingleLinkedList.getTail().nextNode.value);
    }

    @Test
    void search() {
        circleSingleLinkedList.addNode(40,2);

        int index = circleSingleLinkedList.search(10);
        Assertions.assertEquals(0,index);

        index = circleSingleLinkedList.search(20);
        Assertions.assertEquals(1,index);

        index = circleSingleLinkedList.search(40);
        Assertions.assertEquals(2,index);
    }
    @Test
    void search_whenDeleteLinkedListThenNodesAreRemovedThrowException() {
        circleSingleLinkedList.deleteLinkedList();
        IllegalStateException thrown = Assertions.assertThrows(IllegalStateException.class,
                () -> circleSingleLinkedList.search(10));
        Assertions.assertEquals("LinkedList does not contain any node.",
                thrown.getMessage());
    }
    /*
    @Test
    void addNode_whenMultipleNodeAddedInternally_HeadRemainsSame() {
        Assertions.assertEquals(firstNode, circleSingleLinkedList.getHead());
    }

    @Test
    void search_givenNode() {
        Assertions.assertEquals(1, circleSingleLinkedList.search(20));
    }

    @Test
    void delete() {
        circleSingleLinkedList.deleteNode(1);
        Assertions.assertEquals(-1, circleSingleLinkedList.search(20));
    }

    @Test
    void delete_firstNode() {
        circleSingleLinkedList.deleteNode(0);
        Assertions.assertEquals(-1, circleSingleLinkedList.search(10));
    }

    @Test
    void delete_lastNode() {
        circleSingleLinkedList.deleteNode(2);
        Assertions.assertEquals(-1, circleSingleLinkedList.search(30));
    }

    @Test
    void delete_internalNode() {
        circleSingleLinkedList.deleteNode(1);
        Assertions.assertEquals(-1, circleSingleLinkedList.search(20));
    }

    @Test
    void delete_whenDeleteLastNode_thenTailChangedWithNewTail() {
        circleSingleLinkedList.deleteNode(2);
        Assertions.assertEquals(secondNode.value, circleSingleLinkedList.getTail().value);
    }

    @Test
    void delete_whenDeleteFirstNode_thenHeadChangedWithNewNode() {
        circleSingleLinkedList.deleteNode(0);
        Assertions.assertEquals(secondNode.value, circleSingleLinkedList.getHead().value);
    }

    @Test
    void deleteLinkedList_whenDeleteLinkedListThenHeadAndTailWillBeNull() {
        circleSingleLinkedList.deleteLinkedList();
        Assertions.assertEquals(null, circleSingleLinkedList.getHead());
        Assertions.assertEquals(null, circleSingleLinkedList.getTail());
    }


    */

}