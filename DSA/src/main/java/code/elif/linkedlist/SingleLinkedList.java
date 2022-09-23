package code.elif.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class SingleLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;

    public SingleLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addNode(Node<T> node, Integer position) {
        addNode(node.value, position);
    }

    public void addNode(T value, Integer position) {
        if (position.equals(0)) {
            Node<T> newNode = new Node<>(value, head);
            this.head = newNode;
        } else if (position.equals(-1)) { // last position
            Node<T> newNode = new Node<>(value, null);
            tail.nextNode = newNode;
            tail = newNode;
        } else {
            int location = 0;
            Node<T> tempNode = head;
            while (location < position && tempNode.nextNode != null) {
                tempNode = tempNode.nextNode;
                location++;
            }
            Node<T> newNode = new Node<>(value, tempNode.nextNode);
            tempNode.nextNode = newNode;

            if (newNode.nextNode == null) {
                tail = newNode;
            }
        }
    }

    public boolean deleteNode(int position) {
        if (position == 0) {
            head = head.nextNode;
        } else if (position == -1) {
            Node<T> tempNode = head;
            while (tempNode.nextNode.nextNode != null) {
                tempNode = tempNode.nextNode;
            }
            tempNode.nextNode = null;
            tail = tempNode;
        } else {
            int location = 0;
            Node<T> tempNode = head;
            while (location < position - 1 && tempNode.nextNode != null) {
                tempNode = tempNode.nextNode;
                location++;
            }
            tempNode.nextNode = tempNode.nextNode.nextNode;
            if (tempNode.nextNode == null) {
                tail = tempNode;
            }
        }
        return true;
    }

    public int search(T value) {
        if (head == null) {
            throw new IllegalStateException("LinkedList does not contain any node.");
        }
        Node<T> tempNode = head;
        int index = 0;
        while (tempNode.nextNode != null) {
            tempNode = tempNode.nextNode;
            index++;
            if (tempNode.value.equals(value)) {
                return index;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("SingleLinkedList{")
                .append("head=" + head)
                .append(", tail=" + tail)
                .append(", next = {");
        Node<T> tempNode = head;
        while (tempNode.nextNode != null) {
            s.append(tempNode.nextNode);
            tempNode = tempNode.nextNode;
        }
        s.append('}');
        return s.toString();
    }

    public void deleteLinkedList() {
        head = null;
        tail = null;
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }
}



class Solution {

    //Definition for singly-linked list.
    static class ListNode {
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


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);

        mergeTwoLists(listNode1, listNode2);

        reverseList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))));

    }


    public static ListNode reverseList(ListNode head) {

            ListNode cursor;
            ListNode tail = head;
            ListNode listNode = head.next;
            tail.next = null;

            while(listNode.next !=null ){
                cursor = listNode;
                listNode = listNode.next;
                cursor.next = tail;
                tail = cursor;
            }

            listNode.next = tail;

            return listNode;

        }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergedList = new ListNode();
        ListNode tail = mergedList;

        if (list1 == null && list2 == null) {
            return tail;
        }

        while (list1 != null || list2 != null) {
            if (list1 == null) {
                tail.next = list2;
                mergedList.next = mergedList;
                return tail;
            }
            if (list2 == null) {
                tail.next = list1;
                mergedList.next = mergedList;
                return tail;
            }

            if (list1.val == list2.val) {
                tail.next = new ListNode(list1.val, new ListNode(list2.val));
                list1 = list1.next;
                list2 = list2.next;
                tail = tail.next.next;
            } else if (list1.val < list2.val) {
                tail.next = new ListNode(list1.val);
                tail = tail.next;
                list1 = list1.next;
            } else {
                tail.next = new ListNode(list2.val);
                tail = tail.next;
                list2 = list2.next;
            }
        }
        return mergedList;
    }

    public static ListNode detectCycle(ListNode head) {
        Set<Integer> set = new HashSet<>();
        while(!set.contains(head.val)){
            set.add(head.val);
            head = head.next;
        }
        return head;
    }
}