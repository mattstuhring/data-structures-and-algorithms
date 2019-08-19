package stacksandqueues;

public class Stack {
    public Node top;

    public void push(int value) {
        Node newTopNode = new Node(value);

        newTopNode.next = this.top;
        this.top = newTopNode;
    }

    public int pop() {
        if (this.top == null) {
            throw new NullPointerException();
        } else {
            Node temp = this.top;
            int tempValue = this.top.value;

            this.top = this.top.next;
            temp.next = null;

            return tempValue;
        }
    }

    public int peek() {
        if (this.top == null) {
            throw new NullPointerException();
        } else {
            return this.top.value;
        }
    }
}
