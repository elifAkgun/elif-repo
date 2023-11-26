package code.elif.datastructure.linkedlist;


public class LinkedListDemo {

    public static void main(String[] args) {
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<>();
        singleLinkedList.addNode(10, 0);
        singleLinkedList.addNode(20, 1);
        singleLinkedList.addNode(30, 2);
        singleLinkedList.addNode(40, 3);
        singleLinkedList.addNode(50, 4);
        singleLinkedList.addNode(31, -1);

        System.out.println(singleLinkedList.search(31));

        singleLinkedList.deleteNode(2);

        System.out.println(singleLinkedList);

    }
}
