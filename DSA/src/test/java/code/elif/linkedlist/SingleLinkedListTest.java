package code.elif.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class SingleLinkedListTest {

    private static SingleLinkedList<Integer> singleLinkedList;
    private static Node<Integer> thirdNode;
    private static Node<Integer> secondNode;
    private static Node<Integer> firstNode;

    @BeforeEach
    void init() {
        singleLinkedList = new SingleLinkedList<Integer>();

        thirdNode = new Node<>(30, null);
        secondNode = new Node<>(20, thirdNode);
        firstNode = new Node<>(10, secondNode);

        singleLinkedList.addNode(firstNode, 0);
        singleLinkedList.addNode(secondNode, 1);
        singleLinkedList.addNode(thirdNode, 2);
    }

    @Test
    void addNode() {
        Assertions.assertEquals(firstNode, singleLinkedList.getHead());
        Assertions.assertEquals(thirdNode, singleLinkedList.getTail());

    }

    @Test
    void addNode_asAFirstElement() {
        singleLinkedList.addNode(1,0);
        Assertions.assertEquals(1, singleLinkedList.getHead().value);
        Assertions.assertEquals(10, singleLinkedList.getHead().nextNode.value);
    }

    @Test
    void addNode_hasOneNodeListAddAsAFirstElement() {
        singleLinkedList.deleteNode(0);
        singleLinkedList.addNode(1,0);
        Assertions.assertEquals(1, singleLinkedList.getHead().value);
        Assertions.assertEquals(secondNode.value, singleLinkedList.getHead().nextNode.value);
    }

    @Test
    void addNode_whenMultipleNodeAddedInternally_HeadRemainsSame() {
        Assertions.assertEquals(firstNode, singleLinkedList.getHead());
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
        Assertions.assertEquals(secondNode.value, singleLinkedList.getTail().value);
    }

    @Test
    void delete_whenDeleteFirstNode_thenHeadChangedWithNewNode() {
        singleLinkedList.deleteNode(0);
        Assertions.assertEquals(secondNode.value, singleLinkedList.getHead().value);
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