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
            this.rear.next = newRearNode;
            this.rear = newRearNode;
        }
    }

    public int dequeue() {
        if (this.front == null) {
            throw new NullPointerException();
        } else {

            if (this.front == this.rear) {
                this.rear = null;
            }

            int tempNodeValue = this.front.value;

            this.front = this.front.next;

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
