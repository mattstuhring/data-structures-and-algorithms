package utilities;

public class AnimalShelter {
    public Queue<String> cats;
    public Queue<String> dogs;

    public AnimalShelter() {
        this.cats = new Queue<>();
        this.dogs = new Queue<>();
    }

    // enqueue(animal): adds animal to the shelter. animal can be either a dog or a cat object.
    public void enqueue(String animal) {
        if (animal.equals("cat")) {
            this.cats.enqueue(animal);
        } else if (animal.equals("dog")) {
            this.dogs.enqueue(animal);
        } else {
            System.out.println("We do not have " + animal + "s at this shelter, only dogs and cats.");
        }
    }

    // dequeue(animal): returns either a dog or a cat. If pref is not "dog" or "cat" then return null.
    public String dequeue(String animal) {
        if (animal.equals("cat") && cats.peek() != null) {
            return this.cats.dequeue();
        } else if (animal.equals("dog") && dogs.peek() != null) {
            return this.dogs.dequeue();
        } else {
            return null;
        }
    }
}
