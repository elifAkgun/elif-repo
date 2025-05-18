package code.elif.datastructure.linkedlist;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LinkedListDemo {


    private static final Logger logger = LoggerFactory.getLogger(LinkedListDemo.class);

    public static void main(String[] args) {
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<>();
        singleLinkedList.addNode(10, 0);
        singleLinkedList.addNode(20, 1);
        singleLinkedList.addNode(30, 2);
        singleLinkedList.addNode(40, 3);
        singleLinkedList.addNode(50, 4);
        singleLinkedList.addNode(31, -1);

        logger.info(String.valueOf(singleLinkedList.search(31)));

        singleLinkedList.deleteNode(2);

        logger.info(String.valueOf(singleLinkedList));

    }
}
