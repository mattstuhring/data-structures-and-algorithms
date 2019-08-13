package linkedList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {

    LinkedList ll;
    @Before
    public void setupTestLinkedList() throws Exception {
        ll = new LinkedList();
        ll.insert(1);
        ll.insert(2);
        ll.insert(3);
        ll.insert(4);
    }

    @Test
    public void testInsert_containsNoValues() {
        LinkedList emptyLinkedList = new LinkedList();

        assertNull("Linked list should be null", emptyLinkedList.head);
    }

    @Test
    public void testInsert_containsValues() {
        assertEquals("4, 3, 2, 1", ll.toString());
    }

    @Test
    public void testHeadValue() {
        assertEquals(4, ll.head.value);
    }

    @Test
    public void testIncludes_existsAtHead() {
        assertTrue("Value should exist at the head of the linked list", ll.includes(1));
    }

    @Test
    public void testIncludes_existsAtTail() {
        assertTrue("Value should exist at the tail of linked list", ll.includes(4));
    }

    @Test
    public void testIncludes_doesNotExist() {
        assertFalse("Value should NOT exist in linked list", ll.includes(5));
    }

    @Test
    public void testToString() {
        assertEquals("4, 3, 2, 1", ll.toString());
    }

    @Test
    public void testAppend_nodeToTheEndOfLinkedList() {
        ll.append(5);

        assertEquals("4, 3, 2, 1, 5", ll.toString());
    }

    @Test
    public void testAppend_multipleAppend() {
        ll.append(5);
        ll.append(6);
        ll.append(7);

        assertEquals("4, 3, 2, 1, 5, 6, 7", ll.toString());
    }

    @Test
    public void testInsertBefore_middleInsert() {
        ll.insertBefore(2, 5);

        assertEquals("4, 3, 5, 2, 1", ll.toString());
    }

    @Test
    public void testInsertBefore_firstNode() {
        ll.insertBefore(4, 5);

        assertEquals("5, 4, 3, 2, 1", ll.toString());
    }

    @Test
    public void testInsertAfter_middleNode() {
        ll.insertAfter(3, 5);

        assertEquals("4, 3, 5, 2, 1", ll.toString());
    }

    @Test
    public void testInsertAfter_lastNode() {
        ll.insertAfter(1, 5);

        assertEquals("4, 3, 2, 1, 5", ll.toString());
    }
}