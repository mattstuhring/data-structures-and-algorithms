package stacksandqueues;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class PseudoQueueTest {

    @Test
    public void enqueue_single() {
        PseudoQueue pseudoQueue = new PseudoQueue();
        pseudoQueue.enqueue(1);

        assertEquals(1, pseudoQueue.stack1.peek());
    }

    @Test
    public void enqueue_multiple() {
        PseudoQueue pseudoQueue = new PseudoQueue();
        pseudoQueue.enqueue(1);
        pseudoQueue.enqueue(2);
        pseudoQueue.enqueue(3);

        assertEquals(3, pseudoQueue.stack1.peek());
    }

    @Test
    public void dequeue_single() {
        PseudoQueue pseudoQueue = new PseudoQueue();
        pseudoQueue.enqueue(1);

        assertEquals(1, pseudoQueue.dequeue());
    }

    @Test
    public void dequeue_multiple() {
        PseudoQueue pseudoQueue = new PseudoQueue();
        pseudoQueue.enqueue(1);
        pseudoQueue.enqueue(2);
        pseudoQueue.enqueue(3);
        pseudoQueue.dequeue();

        assertEquals(2, pseudoQueue.dequeue());
    }

    @Test(expected = NullPointerException.class)
    public void dequeue_empty() {
        PseudoQueue pseudoQueue = new PseudoQueue();

        assertNull(pseudoQueue.dequeue());
    }
}