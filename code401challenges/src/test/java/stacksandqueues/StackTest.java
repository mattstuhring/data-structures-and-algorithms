package stacksandqueues;

import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {

    @Test
    public void testPush_singlePush() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);

        assertEquals(1, (int)stack.top.value);
    }

    @Test
    public void testPush_multiplePush() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, (int)stack.top.value);
    }

    @Test
    public void testPop() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();

        assertEquals(2, (int)stack.top.value);
    }

    @Test
    public void testPop_emptyStack() {
        Stack<Integer> stack = new Stack<>();
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
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, (int)stack.peek());
    }

    @Test
    public void testInitializeEmptyStack() {
        Stack<Integer> stack = new Stack<>();

        assertNull(stack.top);
    }
}