package stacksandqueues;

public class Queue<T> {
    public Node<T> front;
    public Node<T> rear;

    public void enqueue(T value) {
        Node<T> newRearNode = new Node<>(value);

        if (this.front == null) {
            this.front = newRearNode;
            this.rear = newRearNode;
        } else {
            this.rear.next = newRearNode;
            this.rear = newRearNode;
        }
    }

    public T dequeue() {
        if (this.front == null) {
            return null;
        } else {

            if (this.front == this.rear) {
                this.rear = null;
            }

            T tempNodeValue = this.front.value;

            this.front = this.front.next;

            return tempNodeValue;
        }
    }

    public T peek() {
        if (this.front == null) {
            return null;
        } else {
            return this.front.value;
        }
    }
}
