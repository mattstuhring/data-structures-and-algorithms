package linkedList;

public class LinkedList {
    public Node head;

    public LinkedList() {
        this.head = null;
    }

    // insert method
    // adds a new node with that value to the head of the list
    public void insert(Node newNode) {
        if (this.head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            this.head = newNode;
        }
    }

    // includes method
    // returns a boolean result depending on whether that value exists as a Node’s value somewhere within the list.
    public boolean includes(Node node) {
        Node current = head;

        while(current != null) {
            if (current.value == node.value) {
                return true;
            }

            current = current.next;
        }

        return false;
    }

    // toString method
    // returns a string representing all the values in the Linked List
    public String toString() {
        StringBuilder sb = new StringBuilder();

        Node current = head;

        while(current != null) {
            if (current.next != null) {
                sb.append(current.value).append(", ");
            } else {
                sb.append(current.value);
            }

            current = current.next;
        }

        return sb.toString();
    }
}
