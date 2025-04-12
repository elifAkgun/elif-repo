package code.elif.datastructure.array;

import code.elif.datastructure.array.CountingBits;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class CountingBitsTest {

    @Test
    void countBitsN2() {
        CountingBits countingBits = new CountingBits();
        int[] actual = countingBits.countBits(2);
        int[] expected = {0, 1, 1};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void countBitsN5() {
        CountingBits countingBits = new CountingBits();
        int[] actual = countingBits.countBits(5);
        int[] expected = {0, 1, 1, 2, 1, 2};
        Assertions.assertArrayEquals(expected, actual);
    }
}