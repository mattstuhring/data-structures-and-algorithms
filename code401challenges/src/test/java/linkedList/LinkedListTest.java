package linkedList;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {

    @Test
    public void testInsert_containsValues() {
        LinkedList ll = new LinkedList();

        ll.insert(new Node(1));
        ll.insert(new Node(2));
        ll.insert(new Node(3));
        ll.insert(new Node(4));

        assertEquals("4, 3, 2, 1", ll.toString());
    }

    @Test
    public void testInsert_containsNoValues() {
        LinkedList ll = new LinkedList();
        System.out.println(ll.toString());

        assertNull("Linked list should be null", ll.head);
    }

    @Test
    public void testHeadValue() {
        LinkedList ll = new LinkedList();

        ll.insert(new Node(1));
        ll.insert(new Node(2));
        ll.insert(new Node(3));
        ll.insert(new Node(4));

        assertEquals(ll.head.value,4);
    }

    @Test
    public void testIncludes_existsAtHead() {
        LinkedList ll = new LinkedList();

        ll.insert(new Node(1));
        ll.insert(new Node(2));
        ll.insert(new Node(3));
        ll.insert(new Node(4));

        assertTrue("Value should exist at the head of the linked list", ll.includes(new Node(1)));
    }

    @Test
    public void testIncludes_existsAtTail() {
        LinkedList ll = new LinkedList();

        ll.insert(new Node(1));
        ll.insert(new Node(2));
        ll.insert(new Node(3));
        ll.insert(new Node(4));

        assertTrue("Value should exist at the tail of linked list", ll.includes(new Node(4)));
    }

    @Test
    public void testIncludes_doesNotExist() {
        LinkedList ll = new LinkedList();

        ll.insert(new Node(1));
        ll.insert(new Node(2));
        ll.insert(new Node(3));
        ll.insert(new Node(4));

        assertFalse("Value should NOT exist in linked list", ll.includes(new Node(5)));
    }

    @Test
    public void testToString() {
        LinkedList ll = new LinkedList();

        ll.insert(new Node(1));
        ll.insert(new Node(2));
        ll.insert(new Node(3));
        ll.insert(new Node(4));

        assertEquals("4, 3, 2, 1", ll.toString());
    }
}