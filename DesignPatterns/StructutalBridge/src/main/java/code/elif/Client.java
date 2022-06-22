package code.elif;

import code.elif.linkedList.ArrayLinkedList;

public class Client {

    public static void main(String[] args) {

        FifoCollection<Integer> fifoCollection =
				new Queue<Integer>(new ArrayLinkedList<Integer>());

        fifoCollection.offer(1);
        fifoCollection.offer(12);
        fifoCollection.offer(123);

        System.out.println(fifoCollection.poll());
        System.out.println(fifoCollection.poll());
        System.out.println(fifoCollection.poll());
        System.out.println(fifoCollection.poll());

    }

}
