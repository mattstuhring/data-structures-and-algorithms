package stacksandqueues;

import org.junit.Test;

import static org.junit.Assert.*;

public class QueueTest {

    @Test
    public void testEnqueue_singleValue() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);

        assertEquals(1, (int)queue.front.value);
        assertEquals(1, (int)queue.rear.value);
    }

    @Test
    public void testEnqueue_multipleValues() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(1, (int)queue.front.value);
        assertEquals(3, (int)queue.rear.value);
    }

    @Test
    public void testDequeue_singleNode() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);

        assertEquals(1, (int)queue.dequeue());
    }

    @Test
    public void testDequeue_multipleNodes() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.dequeue();
        queue.dequeue();

        assertEquals(3, (int)queue.dequeue());
    }

    @Test
    public void testPeek() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(1, (int)queue.peek());
    }

    @Test
    public void testEmptyQueue() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        assertNull(queue.front);
    }

    @Test
    public void testInstantiateEmptyQueue() {
        Queue<Integer> queue = new Queue<>();
        assertNull(queue.front);
    }
}