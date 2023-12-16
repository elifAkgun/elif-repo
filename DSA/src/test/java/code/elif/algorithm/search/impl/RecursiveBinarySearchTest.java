package code.elif.algorithm.search.impl;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecursiveBinarySearchTest {
    @Test
    public void givenListHasValidElement_whenFindCall_thenReturnIndexOfElement() {
        // given- precondition or setup
        List<Integer> integerList = List.of(1, 2, 3, 4, 7, 10, 24, 30, 50);

        // when - action or the behaviour that we are going test
        RecursiveBinarySearch<Integer> RecursiveBinarySearch = new RecursiveBinarySearch<>();
        boolean isFound = RecursiveBinarySearch.find(7, integerList);

        // then - verify the output
        assertEquals(true, isFound);
    }

    @Test
    public void givenListHasInValidElement_whenFindCall_thenReturnMinesOne() {
        // given- precondition or setup
        List<Integer> integerList = List.of(1, 2, 3, 4, 7, 10, 24, 30, 50);

        // when - action or the behaviour that we are going test
        RecursiveBinarySearch<Integer> RecursiveBinarySearch = new RecursiveBinarySearch<>();
        boolean isFound = RecursiveBinarySearch.find(8, integerList);

        // then - verify the output
        assertEquals(false, isFound);
    }

    @Test
    public void givenTargetFirstElement_whenFindCall_thenReturnIndexOfElement() {
        // given- precondition or setup
        List<Integer> integerList = List.of(1, 2, 3, 4, 7, 10, 24, 30, 50);

        // when - action or the behaviour that we are going test
        RecursiveBinarySearch<Integer> recursiveBinarySearch = new RecursiveBinarySearch<>();
        boolean isFound = recursiveBinarySearch.find(1, integerList);

        // then - verify the output
        assertEquals(true, isFound);
    }

    @Test
    public void givenTargetRandomElement_whenFindCall_thenReturnIndexOfElement2() {
        // given- precondition or setup
        List<Integer> integerList = List.of(1, 2, 3, 4, 7, 10, 24, 30, 50);

        // when - action or the behaviour that we are going test
        RecursiveBinarySearch<Integer> recursiveBinarySearch = new RecursiveBinarySearch<>();
        boolean isFound = recursiveBinarySearch.find(24, integerList);

        // then - verify the output
        assertEquals(true, isFound);
    }

    @Test
    public void givenTargetRandomElement_whenFindCall_thenReturnIndexOfElement() {
        // given- precondition or setup
        List<Integer> integerList = List.of(1, 2, 3, 4, 7, 10, 24, 30, 50, 70);

        // when - action or the behaviour that we are going test
        RecursiveBinarySearch<Integer> recursiveBinarySearch = new RecursiveBinarySearch<>();
        boolean isFound = recursiveBinarySearch.find(30, integerList);

        // then - verify the output
        assertEquals(true, isFound);
    }

    @Test
    public void givenTargetLastElement_whenFindCall_thenReturnIndexOfElement() {
        // given- precondition or setup
        List<Integer> integerList = List.of(1, 2, 3, 4, 7, 10, 24, 30, 50, 70);

        // when - action or the behaviour that we are going test
        RecursiveBinarySearch<Integer> recursiveBinarySearch = new RecursiveBinarySearch<>();
        boolean isFound = recursiveBinarySearch.find(70, integerList);

        // then - verify the output
        assertEquals(true, isFound);
    }

    @Test
    public void givenTargetLastElement_whenFindCall_thenReturnIndexOfElement2() {
        // given- precondition or setup
        List<Integer> integerList = List.of(1, 2, 3, 4, 7, 10, 24, 30, 50);

        // when - action or the behaviour that we are going test
        RecursiveBinarySearch<Integer> recursiveBinarySearch = new RecursiveBinarySearch<>();
        boolean isFound = recursiveBinarySearch.find(50, integerList);

        // then - verify the output
        assertEquals(true, isFound);
    }

    @Test
    public void givenListIsNotInitialized_whenFindCall_thenReturnMinesOne() {
        // given- precondition or setup
        List<Integer> integerList = null;

        // when - action or the behaviour that we are going test
        RecursiveBinarySearch<Integer> RecursiveBinarySearch = new RecursiveBinarySearch<>();
        boolean isFound = RecursiveBinarySearch.find(8, integerList);

        // then - verify the output
        assertEquals(false, isFound);
    }

}