package code.elif.stack.impl;

import code.elif.stack.Stack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackLinkedListTest {

    Stack<Integer> stack;

    @BeforeEach
    public void init() {
        stack = new StackLinkedList<>();
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