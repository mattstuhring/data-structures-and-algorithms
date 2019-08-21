package utilities;

public class Queue<T> {
    public Animal<T> front;
    public Animal<T> rear;

    public void enqueue(T value) {
        Animal<T> newRearAnimal = new Animal<>(value);

        if (this.front == null) {
            this.front = newRearAnimal;
            this.rear = newRearAnimal;
        } else {
            this.rear.next = newRearAnimal;
            this.rear = newRearAnimal;
        }
    }

    public T dequeue() {
        if (this.front == null) {
            return null;
        } else {

            if (this.front == this.rear) {
                this.rear = null;
            }

            T tempAnimalValue = this.front.value;

            this.front = this.front.next;

            return tempAnimalValue;
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
