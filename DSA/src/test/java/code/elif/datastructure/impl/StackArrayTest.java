package code.elif.datastructure.impl;

import code.elif.datastructure.stack.Stack;
import code.elif.datastructure.stack.impl.StackArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackArrayTest {
    Stack<Integer> stack;

    @BeforeEach
    public void init() {
        stack = new StackArray<>(Integer.class, 10);
    }

    @Test
    void push() {
        assertTrue(stack.isEmpty());
        stack.push(10);
        assertEquals(10, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    void peek() {
        assertTrue(stack.isEmpty());
        stack.push(10);
        assertEquals(10, stack.peek());
        assertFalse(stack.isEmpty());
    }

    @Test
    void deleteStack() {
        stack.deleteStack();
        IllegalStateException illegalStateException = assertThrows(IllegalStateException.class, () -> stack.pop());
        assertEquals("There is no element in the stack",
                illegalStateException.getMessage());
    }
}