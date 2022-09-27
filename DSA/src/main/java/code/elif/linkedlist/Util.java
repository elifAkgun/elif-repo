package code.elif.linkedlist;

import code.elif.linkedlist.node.SingleNode;

import java.util.HashSet;
import java.util.Set;

public class Util<T extends Comparable> {

    public SingleNode<T> reverseList(SingleNode<T> head) {

        SingleNode<T> cursor;
        SingleNode<T> tail = head;
        SingleNode<T> listSingleNode = head.nextSingleNode;
        tail.nextSingleNode = null;

        while(listSingleNode.nextSingleNode !=null ){
            cursor = listSingleNode;
            listSingleNode = listSingleNode.nextSingleNode;
            cursor.nextSingleNode = tail;
            tail = cursor;
        }

        listSingleNode.nextSingleNode = tail;

        return listSingleNode;

    }

    public SingleNode<T> mergeTwoLists(SingleNode<T> list1, SingleNode<T> list2) {
        SingleNode<T> mergedList = new SingleNode<T>();
        SingleNode<T> tail = mergedList;

        if (list1 == null && list2 == null) {
            return tail;
        }

        while (list1 != null || list2 != null) {
            if (list1 == null) {
                tail.nextSingleNode = list2;
                mergedList.nextSingleNode = mergedList;
                return tail;
            }
            if (list2 == null) {
                tail.nextSingleNode = list1;
                mergedList.nextSingleNode = mergedList;
                return tail;
            }

            if (list1.value == list2.value) {
                tail.nextSingleNode = new SingleNode<>(list1.value, new SingleNode<>(list2.value));
                list1 = list1.nextSingleNode;
                list2 = list2.nextSingleNode;
                tail = tail.nextSingleNode.nextSingleNode;
            } else if (list1.value.compareTo(list2.value)<0) {
                tail.nextSingleNode = new SingleNode<>(list1.value);
                tail = tail.nextSingleNode;
                list1 = list1.nextSingleNode;
            } else {
                tail.nextSingleNode = new SingleNode<>(list2.value);
                tail = tail.nextSingleNode;
                list2 = list2.nextSingleNode;
            }
        }
        return mergedList;
    }

    public SingleNode<T> detectCycle(SingleNode<T> head) {
        Set<T> set = new HashSet<>();
        while(!set.contains(head.value)){
            set.add(head.value);
            head = head.nextSingleNode;
        }
        return head;
    }

    public static void main(String[] args) {

    }
}