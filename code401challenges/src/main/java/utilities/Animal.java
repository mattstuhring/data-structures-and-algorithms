package utilities;

public class Animal<T> {
    public T value;
    public Animal<T> next;

    public Animal(T value) {
        this.value = value;
    }
}
