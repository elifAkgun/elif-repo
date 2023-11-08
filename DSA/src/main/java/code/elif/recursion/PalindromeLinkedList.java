package code.elif.recursion;


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
//Input: head = [1,2,2,1]
//        Output: true

public class PalindromeLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        System.out.println(isPalindrome(head));
    }

    public static boolean isPalindrome(ListNode head) {

        ListNode headNode = head;
        if (headNode.next == null)
            return true;

        ListNode temp1 = head.next;
        if (temp1 != null && temp1.next == null && temp1.val == head.val)
            return true;

        ListNode temp2 = head.next.next;
        if (temp2 != null && temp2.next == null && temp2.val == head.val)
            return true;

        int listSize = 0;
        while (headNode != null) {
            headNode = headNode.next;
            listSize++;
        }

        ListNode cursor = null;
        temp1 = head.next;
        temp2 = head.next.next;

        for (int i = 0; i < listSize; i++) {
            if (i < (listSize / 2) - 1) {
                temp1 = temp1.next;
                if (temp2 != null) {
                    temp2 = temp2.next;
                }
            } else {
                temp1.next = cursor;
                cursor = temp1;
                if (temp2 != null) {
                    temp1 = temp2;
                    temp2 = temp2.next;
                } else {
                    break;
                }
            }
        }

        for (int i = 0; i < listSize / 2; i++) {
            if (head.val == temp1.val) {
                head = head.next;
                temp1 = temp1.next;
            } else
                return false;
        }
        return true;
    }
}