package stacksandqueues;

public class Queue {
    public Node front;
    public Node rear;

    public void enqueue(int value) {
        Node newRearNode = new Node(value);

        if (this.front == null) {
            this.front = newRearNode;
            this.rear = newRearNode;
        } else {
            rear.next = newRearNode;
            rear = newRearNode;
        }
    }

    public int dequeue() {
        if (this.front == null) {
            throw new NullPointerException();
        } else {

            if (this.front == this.rear) {
                this.rear = null;
            }

            Node tempNode = front;
            int tempNodeValue = tempNode.value;

            front = front.next;
            tempNode.next = null;

            return tempNodeValue;
        }
    }

    public int peek() {
        if (this.front == null) {
            throw new NullPointerException();
        } else {
            return this.front.value;
        }
    }
}
