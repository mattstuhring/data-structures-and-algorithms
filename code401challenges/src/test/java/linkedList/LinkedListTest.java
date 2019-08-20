package linkedList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {

    LinkedList<Integer> ll;
    @Before
    public void setupTestLinkedList() throws Exception {
        ll = new LinkedList<>();
        ll.insert(1);
        ll.insert(2);
        ll.insert(3);
        ll.insert(4);
    }

    @Test
    public void testInsert_containsNoValues() {
        LinkedList<Integer> emptyLinkedList = new LinkedList<>();

        assertNull("Linked list should be null", emptyLinkedList.head);
    }

    @Test
    public void testInsert_containsValues() {
        assertEquals("4, 3, 2, 1", ll.toString());
    }

    @Test
    public void testHeadValue() {
        assertEquals(4, (int)ll.head.value);
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

    @Test
    public void testKthFromEnd_middleKth() {
        assertEquals(3, (int)ll.kthFromEnd(2));
    }

    @Test
    public void testKthFromEnd_sameLength() {
        assertEquals(1, (int)ll.kthFromEnd(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testKthFromEnd_greaterThanLength() {
        assertNull(ll.kthFromEnd(6));
    }

    @Test(expected = NullPointerException.class)
    public void testKthFromEnd_negativeInteger() {
        assertNull(ll.kthFromEnd(-1));
    }

    @Test
    public void testKthFromEnd_size1LinkedList() {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.append(1);

        assertEquals(1, (int)ll.kthFromEnd(0));
    }

    @Test
    public void testMergeLinkedList1() {
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.append(1);
        list1.append(3);
        list1.append(2);

        LinkedList<Integer> list2 = new LinkedList<>();
        list2.append(5);
        list2.append(9);
        list2.append(4);

        assertEquals("1, 5, 3, 9, 2, 4", LinkedList.mergeLists(list1, list2).toString());
    }

    @Test
    public void testMergeLinkedList2() {
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.append(1);
        list1.append(3);

        LinkedList<Integer> list2 = new LinkedList<>();
        list2.append(5);
        list2.append(9);
        list2.append(4);

        assertEquals("1, 5, 3, 9, 4", LinkedList.mergeLists(list1, list2).toString());
    }
}