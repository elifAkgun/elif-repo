package code.elif.datastructure.array;

import code.elif.datastructure.linkedlist.DoubleLinkedList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class DuplicateExample {

    private static final Logger logger = LoggerFactory.getLogger(DuplicateExample.class);

    public static void main(String[] args) {

        int[] array = {0, 10, 20, 30, 40, 20, 60, 70, 30};

        Arrays.sort(array);

        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] == array[i]) {
                logger.info(String.valueOf(array[i]));
            }
        }
    }
}
