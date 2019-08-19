package stacksandqueues;

import org.junit.Test;

import static org.junit.Assert.*;

public class QueueTest {

    @Test
    public void testEnqueue_singleValue() {
        Queue queue = new Queue();
        queue.enqueue(1);

        assertEquals(1, queue.front.value);
        assertEquals(1, queue.rear.value);
    }

    @Test
    public void testEnqueue_multipleValues() {
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(1, queue.front.value);
        assertEquals(3, queue.rear.value);
    }

    @Test
    public void testDequeue_singleNode() {
        Queue queue = new Queue();
        queue.enqueue(1);

        assertEquals(1, queue.dequeue());
    }

    @Test
    public void testDequeue_multipleNodes() {
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.dequeue();
        queue.dequeue();

        assertEquals(3, queue.dequeue());
    }

    @Test
    public void testPeek() {
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(1, queue.peek());
    }

    @Test
    public void testEmptyQueue() {
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        assertNull(queue.front);
    }
}