package stacksandqueues;

import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {

    @Test
    public void testPush_singlePush() {
        Stack stack = new Stack();
        stack.push(1);

        assertEquals(1, stack.top.value);
    }

    @Test
    public void testPush_multiplePush() {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.top.value);
    }

    @Test
    public void testPop() {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();

        assertEquals(2, stack.top.value);
    }

    @Test
    public void testPop_emptyStack() {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();
        stack.pop();
        stack.pop();

        assertNull(stack.top);
    }

    @Test
    public void testPeek() {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.peek());
    }

    @Test
    public void testInitializeEmptyStack() {
        Stack stack = new Stack();

        assertNull(stack.top);
    }
}