package linkedList;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {

    @Test
    public void testInsert_containsValues() {
        LinkedList ll = new LinkedList();

        ll.insert(1);
        ll.insert(2);
        ll.insert(3);
        ll.insert(4);

        assertEquals("4, 3, 2, 1", ll.toString());
    }

    @Test
    public void testInsert_containsNoValues() {
        LinkedList ll = new LinkedList();

        assertNull("Linked list should be null", ll.head);
    }

    @Test
    public void testHeadValue() {
        LinkedList ll = new LinkedList();

        ll.insert(1);
        ll.insert(2);
        ll.insert(3);
        ll.insert(4);

        assertEquals(4, ll.head.value);
    }

    @Test
    public void testIncludes_existsAtHead() {
        LinkedList ll = new LinkedList();

        ll.insert(1);
        ll.insert(2);
        ll.insert(3);
        ll.insert(4);

        assertTrue("Value should exist at the head of the linked list", ll.includes(1));
    }

    @Test
    public void testIncludes_existsAtTail() {
        LinkedList ll = new LinkedList();

        ll.insert(1);
        ll.insert(2);
        ll.insert(3);
        ll.insert(4);

        assertTrue("Value should exist at the tail of linked list", ll.includes(4));
    }

    @Test
    public void testIncludes_doesNotExist() {
        LinkedList ll = new LinkedList();

        ll.insert(1);
        ll.insert(2);
        ll.insert(3);
        ll.insert(4);

        assertFalse("Value should NOT exist in linked list", ll.includes(5));
    }

    @Test
    public void testToString() {
        LinkedList ll = new LinkedList();

        ll.insert(1);
        ll.insert(2);
        ll.insert(3);
        ll.insert(4);

        assertEquals("4, 3, 2, 1", ll.toString());
    }
}