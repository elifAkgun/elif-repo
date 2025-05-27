package code.elif.algorithm.search.impl;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTest {

    @Test
    public void givenListHasValidElement_whenFindCall_thenReturnIndexOfElement() {
        // given- precondition or setup
        List<Integer> integerList = List.of(1, 2, 3, 4, 7, 10, 24, 30, 50);

        // when - action or the behaviour that we are going test
        BinarySearch<Integer> binarySearch = new BinarySearch<>();
        int actualIndex = binarySearch.find(7, integerList);

        // then - verify the output
        assertEquals(4, actualIndex);
    }

    @Test
    public void givenListHasInValidElement_whenFindCall_thenReturnMinesOne() {
        // given- precondition or setup
        List<Integer> integerList = List.of(1, 2, 3, 4, 7, 10, 24, 30, 50);

        // when - action or the behaviour that we are going test
        BinarySearch<Integer> binarySearch = new BinarySearch<>();
        int actualIndex = binarySearch.find(8, integerList);

        // then - verify the output
        assertEquals(-1, actualIndex);
    }

    @Test
    public void givenTargetFirstElement_whenFindCall_thenReturnIndexOfElement() {
        // given- precondition or setup
        List<Integer> integerList = List.of(1, 2, 3, 4, 7, 10, 24, 30, 50);

        // when - action or the behaviour that we are going test
        LinearSearch<Integer> integerLinearSearch = new LinearSearch<>();
        int actualIndex = integerLinearSearch.find(1, integerList);

        // then - verify the output
        assertEquals(0, actualIndex);
    }

    @Test
    public void givenTargetRandomElement_whenFindCall_thenReturnIndexOfElement2() {
        // given- precondition or setup
        List<Integer> integerList = List.of(1, 2, 3, 4, 7, 10, 24, 30, 50);

        // when - action or the behaviour that we are going test
        LinearSearch<Integer> integerLinearSearch = new LinearSearch<>();
        int actualIndex = integerLinearSearch.find(24, integerList);

        // then - verify the output
        assertEquals(6, actualIndex);
    }

    @Test
    public void givenTargetRandomElement_whenFindCall_thenReturnIndexOfElement() {
        // given- precondition or setup
        List<Integer> integerList = List.of(1, 2, 3, 4, 7, 10, 24, 30, 50, 70);

        // when - action or the behaviour that we are going test
        LinearSearch<Integer> integerLinearSearch = new LinearSearch<>();
        int actualIndex = integerLinearSearch.find(30, integerList);

        // then - verify the output
        assertEquals(7, actualIndex);
    }

    @Test
    public void givenTargetLastElement_whenFindCall_thenReturnIndexOfElement() {
        // given- precondition or setup
        List<Integer> integerList = List.of(1, 2, 3, 4, 7, 10, 24, 30, 50, 70);

        // when - action or the behaviour that we are going test
        LinearSearch<Integer> integerLinearSearch = new LinearSearch<>();
        int actualIndex = integerLinearSearch.find(70, integerList);

        // then - verify the output
        assertEquals(9, actualIndex);
    }

    @Test
    public void givenTargetLastElement_whenFindCall_thenReturnIndexOfElement2() {
        // given- precondition or setup
        List<Integer> integerList = List.of(1, 2, 3, 4, 7, 10, 24, 30, 50);

        // when - action or the behaviour that we are going test
        LinearSearch<Integer> integerLinearSearch = new LinearSearch<>();
        int actualIndex = integerLinearSearch.find(50, integerList);

        // then - verify the output
        assertEquals(8, actualIndex);
    }

    @Test
    public void givenListIsNotInitialized_whenFindCall_thenReturnMinesOne() {
        // given- precondition or setup
        List<Integer> integerList = null;

        // when - action or the behaviour that we are going test
        BinarySearch<Integer> binarySearch = new BinarySearch<>();
        int actualIndex = binarySearch.find(8, integerList);

        // then - verify the output
        assertEquals(-1, actualIndex);
    }

}