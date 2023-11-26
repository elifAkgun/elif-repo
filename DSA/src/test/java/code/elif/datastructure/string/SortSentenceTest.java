package code.elif.datastructure.string;

import code.elif.datastructure.string.SortSentence;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortSentenceTest {

    // JUnit test for
    @DisplayName("")
    @Test
    public void given_when_then() {
        // given- precondition or setup
        String s = "is2 sentence4 This1 a3";

        // when - action or the behaviour that we are going test
        SortSentence sortSentence = new SortSentence();
        String sentence = sortSentence.sortSentence(s);

        // then - verify the output
        assertEquals("This is a sentence", sentence);

    }


}