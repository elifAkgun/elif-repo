package code.elif;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidParenthesesTest {

    @Test
    void isValidWithDoubleParentheses() {
        ValidParentheses validParentheses = new ValidParentheses();
        boolean valid = validParentheses.isValid("()");
        assertEquals(true, valid);
    }

    @Test
    void isValidWithSingleParentheses() {
        ValidParentheses validParentheses = new ValidParentheses();
        boolean valid = validParentheses.isValid("(");
        assertEquals(false, valid);
    }

    @Test
    void isNotValidWithDoubleParentheses() {
        ValidParentheses validParentheses = new ValidParentheses();
        boolean valid = validParentheses.isValid("((");
        assertEquals(false, valid);
    }

    @Test
    void isValidWithDoubleParentheses2() {
        ValidParentheses validParentheses = new ValidParentheses();
        boolean valid = validParentheses.isValid("(){}");
        assertEquals(true, valid);
    }

    @Test
    void isValidWithDoubleParentheses3() {
        ValidParentheses validParentheses = new ValidParentheses();
        boolean valid = validParentheses.isValid("({})");
        assertEquals(true, valid);
    }

    @Test
    void isValidWithDoubleParentheses4() {
        ValidParentheses validParentheses = new ValidParentheses();
        boolean valid = validParentheses.isValid("([)]");
        assertEquals(false, valid);
    }

    @Test
    void isValidWithDoubleParentheses5() {
        ValidParentheses validParentheses = new ValidParentheses();
        boolean valid = validParentheses.isValid("){");
        assertEquals(false, valid);
    }
}