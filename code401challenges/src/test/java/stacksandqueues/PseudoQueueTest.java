package stacksandqueues;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class PseudoQueueTest {

    @Test
    public void enqueue_single() {
        PseudoQueue<Integer> pseudoQueue = new PseudoQueue<>();
        pseudoQueue.enqueue(1);

        assertEquals(1, (int)pseudoQueue.stack1.peek());
    }

    @Test
    public void enqueue_multiple() {
        PseudoQueue<Integer> pseudoQueue = new PseudoQueue<>();
        pseudoQueue.enqueue(1);
        pseudoQueue.enqueue(2);
        pseudoQueue.enqueue(3);

        assertEquals(3, (int)pseudoQueue.stack1.peek());
    }

    @Test
    public void dequeue_single() {
        PseudoQueue<Integer> pseudoQueue = new PseudoQueue<>();
        pseudoQueue.enqueue(1);

        assertEquals(1, (int)pseudoQueue.dequeue());
    }

    @Test
    public void dequeue_multiple() {
        PseudoQueue<Integer> pseudoQueue = new PseudoQueue<>();
        pseudoQueue.enqueue(1);
        pseudoQueue.enqueue(2);
        pseudoQueue.enqueue(3);
        pseudoQueue.dequeue();

        assertEquals(2, (int)pseudoQueue.dequeue());
    }

    @Test
    public void dequeue_empty() {
        PseudoQueue<Integer> pseudoQueue = new PseudoQueue<>();

        assertNull(pseudoQueue.dequeue());
    }
}