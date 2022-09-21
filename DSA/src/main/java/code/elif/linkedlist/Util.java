package code.elif.linkedlist;

public class Util<T extends Comparable> {

    public Node<T> mergeTwoLists(Node<T> list1, Node<T> list2) {
        Node<T> cursorNode = new Node<T>();
        Node<T> mergedNode = new Node<T>();

        if (list1 == null && list2 == null) {
            return cursorNode;
        }

        if (list1 == null) {
            mergedNode = list2;
            return mergedNode;
        }

        if (list2 == null) {
            mergedNode = list1;
            return mergedNode;
        }
        while (list1.nextNode != null || list2.nextNode != null) {
            if (list1.value.compareTo(list2.value) < 1) {
                cursorNode = list1;
                mergedNode.nextNode = new Node<T>(cursorNode.value);
                list1 = list1.nextNode;
            }

            else if (list2.value.compareTo(list1.value) < 1) {
                cursorNode = list2;
                mergedNode.nextNode = new Node<T>(cursorNode.value);
                list2 = list2.nextNode;
            }
        }
        return mergedNode;
    }

    public static void main(String[] args) {

    }
}