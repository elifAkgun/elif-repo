package code.elif.datastructure.impl;

import code.elif.datastructure.queue.Queue;
import code.elif.datastructure.queue.impl.LinkedListQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LinkedListQueueTest {

    Queue<Integer> queue;

    @BeforeEach
    void init() {
        queue = new LinkedListQueue<>();
    }

    @Test
    void enQueue() {
        assertTrue(queue.isEmpty());
        queue.enQueue(10);
        assertEquals(10, queue.peekInQueue());
    }

    @Test
    void deQueue() {
        assertTrue(queue.isEmpty());
        queue.enQueue(10);
        queue.enQueue(20);
        queue.enQueue(30);
        assertEquals(10, queue.deQueue());
        assertEquals(20, queue.deQueue());
        assertEquals(30, queue.deQueue());
        assertTrue(queue.isEmpty());
    }

    @Test
    void deleteQueue() {
        assertTrue(queue.isEmpty());
        queue.enQueue(10);
        queue.deleteQueue();
        assertTrue(queue.isEmpty());

    }

}