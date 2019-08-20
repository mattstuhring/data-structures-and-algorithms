package stacksandqueues;

public class PseudoQueue<T> {
    public Stack<T> stack1;
    public Stack<T> stack2;

    public PseudoQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

//    enQueue(x)
//  1) Push x to stack1 (assuming size of stacks is unlimited).
//
//    deQueue()
//  1) If both stacks are empty then error.
//  2) If stack2 is empty
//    While stack1 is not empty, push everything from stack1 to stack2.
//  3) Pop the element from stack2 and return it.

    public void enqueue(T value) {
        this.stack1.push(value);
    }

    public T dequeue() {
        if (this.stack1.top == null && this.stack2.top == null) {
            return null;
        } else {
            if (this.stack2.top == null) {
                while(this.stack1.top != null) {
                    this.stack2.push(this.stack1.pop());
                }
            }

            return this.stack2.pop();
        }
    }
}
