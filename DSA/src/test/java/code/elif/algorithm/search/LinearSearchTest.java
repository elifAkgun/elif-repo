package code.elif.algorithm.search;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LinearSearchTest {

    @Test
    public void givenListHasValidElement_whenExecuteCall_thenReturnIndexOfElement() {
        // given- precondition or setup
        List<Integer> integerList = List.of(1, 23, 3, 4, 8, 7, 24);

        // when - action or the behaviour that we are going test
        LinearSearch<Integer> integerLinearSearch = new LinearSearch<>(integerList);
        int actualIndex = integerLinearSearch.find(8);

        // then - verify the output
        assertEquals(4, actualIndex);
    }

    @Test
    public void givenListHasInValidElement_whenExecuteCall_thenReturnMinesOne() {
        // given- precondition or setup
        List<Integer> integerList = List.of(1, 23, 3, 4, 18, 7, 24);

        // when - action or the behaviour that we are going test
        LinearSearch<Integer> integerLinearSearch = new LinearSearch<>(integerList);
        int actualIndex = integerLinearSearch.find(8);

        // then - verify the output
        assertEquals(-1, actualIndex);
    }

}