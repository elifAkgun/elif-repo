package code.elif.linkedlist;

import code.elif.linkedlist.node.Node;

import java.util.HashSet;
import java.util.Set;

public class Util<T extends Comparable> {

    public Node<T> reverseList(Node<T> head) {

        Node<T> cursor;
        Node<T> tail = head;
        Node<T> listNode = head.nextNode;
        tail.nextNode = null;

        while(listNode.nextNode !=null ){
            cursor = listNode;
            listNode = listNode.nextNode;
            cursor.nextNode = tail;
            tail = cursor;
        }

        listNode.nextNode = tail;

        return listNode;

    }

    public Node<T> mergeTwoLists(Node<T> list1, Node<T> list2) {
        Node<T> mergedList = new Node<T>();
        Node<T> tail = mergedList;

        if (list1 == null && list2 == null) {
            return tail;
        }

        while (list1 != null || list2 != null) {
            if (list1 == null) {
                tail.nextNode = list2;
                mergedList.nextNode = mergedList;
                return tail;
            }
            if (list2 == null) {
                tail.nextNode = list1;
                mergedList.nextNode = mergedList;
                return tail;
            }

            if (list1.value == list2.value) {
                tail.nextNode = new Node<>(list1.value, new Node<>(list2.value));
                list1 = list1.nextNode;
                list2 = list2.nextNode;
                tail = tail.nextNode.nextNode;
            } else if (list1.value.compareTo(list2.value)<0) {
                tail.nextNode = new Node<>(list1.value);
                tail = tail.nextNode;
                list1 = list1.nextNode;
            } else {
                tail.nextNode = new Node<>(list2.value);
                tail = tail.nextNode;
                list2 = list2.nextNode;
            }
        }
        return mergedList;
    }

    public Node<T> detectCycle(Node<T> head) {
        Set<T> set = new HashSet<>();
        while(!set.contains(head.value)){
            set.add(head.value);
            head = head.nextNode;
        }
        return head;
    }

    public static void main(String[] args) {

    }
}