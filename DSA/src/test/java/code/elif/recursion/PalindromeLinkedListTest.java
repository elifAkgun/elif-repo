package code.elif.recursion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PalindromeLinkedListTest {

    @Test
    void isPalindromeTest() {
        ListNode nodes = createNodes(new int[]{1, 2, 2, 1});
        Assertions.assertEquals(true, PalindromeLinkedList.isPalindrome(nodes));
    }

    @Test
    void isPalindromeTest2() {
        ListNode nodes = createNodes(new int[]{1, 2});
        Assertions.assertEquals(false, PalindromeLinkedList.isPalindrome(nodes));
    }

    @Test
    void isPalindromeTest3() {
        ListNode nodes = createNodes(new int[]{1, 0, 3, 4, 0, 1});
        Assertions.assertEquals(false, PalindromeLinkedList.isPalindrome(nodes));
    }

    private ListNode createNodes(int[] nodeValues) {
        ListNode node = new ListNode(nodeValues[0]);
        ListNode head = node;
        for (int i = 1; i < nodeValues.length; i++) {
            node.next = new ListNode(nodeValues[i]);
            node = node.next;
        }
        return head;
    }
}