package stacksandqueues;

public class Stack<T> {
    public Node<T> top;

    public void push(T value) {
        Node<T> newTopNode = new Node<>(value);

        newTopNode.next = this.top;
        this.top = newTopNode;
    }

    public T pop() {
        if (this.top == null) {
            return null;
        } else {
            T tempValue = this.top.value;

            this.top = this.top.next;

            return tempValue;
        }
    }

    public T peek() {
        if (this.top == null) {
            return null;
        } else {
            return this.top.value;
        }
    }
}
