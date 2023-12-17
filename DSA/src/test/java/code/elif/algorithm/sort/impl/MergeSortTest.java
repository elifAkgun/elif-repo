package code.elif.algorithm.sort.impl;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    @Test
    void givenRandomArray_whenMergeSortCalled_thenReturnSortedArray() {
        List<Integer> unSortedList = new ArrayList<>();
        unSortedList.add(1);
        unSortedList.add(10);
        unSortedList.add(2);
        unSortedList.add(25);
        unSortedList.add(4);
        unSortedList.add(23);
        unSortedList.add(15);
        unSortedList.add(6);
        unSortedList.add(16);

        List<Integer> expected = Arrays.asList(1, 2, 4, 6, 10, 15, 16, 23, 25);

        MergeSort<Integer> mergeSort = new MergeSort<>();
        List<Integer> actual = mergeSort.sort(unSortedList);

        assertEquals(expected, actual);
    }
}