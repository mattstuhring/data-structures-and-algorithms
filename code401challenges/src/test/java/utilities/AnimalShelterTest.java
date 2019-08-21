package utilities;

import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalShelterTest {

    @Test
    public void testEnqueue_cats() {
        AnimalShelter shelter = new AnimalShelter();
        shelter.enqueue("cat");

        assertEquals("cat", shelter.cats.front.value);
        assertNull(shelter.dogs.front);
    }

    @Test
    public void testEnqueue_dogs() {
        AnimalShelter shelter = new AnimalShelter();
        shelter.enqueue("dog");

        assertEquals("dog", shelter.dogs.front.value);
        assertNull(shelter.cats.front);
    }

    @Test
    public void testEnqueue_lizard() {
        AnimalShelter shelter = new AnimalShelter();
        shelter.enqueue("lizard");

        assertNull(shelter.cats.front);
        assertNull(shelter.dogs.front);
    }

    @Test
    public void testDequeue_dog() {
        AnimalShelter shelter = new AnimalShelter();
        shelter.enqueue("dog");
        shelter.dequeue("dog");

        assertNull(shelter.dogs.front);
    }

    @Test
    public void testDequeue_multipleDog() {
        AnimalShelter shelter = new AnimalShelter();
        shelter.enqueue("dog");
        shelter.enqueue("dog");

        assertEquals("dog", shelter.dequeue("dog"));
    }

    @Test
    public void testDequeue_cat() {
        AnimalShelter shelter = new AnimalShelter();
        shelter.enqueue("cat");
        shelter.dequeue("cat");

        assertNull(shelter.cats.front);
    }

    @Test
    public void testDequeue_multipleCat() {
        AnimalShelter shelter = new AnimalShelter();
        shelter.enqueue("cat");
        shelter.enqueue("cat");

        assertEquals("cat", shelter.dequeue("cat"));
    }

    @Test
    public void testDequeue_lizard() {
        AnimalShelter shelter = new AnimalShelter();

        assertNull(shelter.dequeue("lizard"));
    }

    @Test
    public void testDequeue_emptyDogQueue() {
        AnimalShelter shelter = new AnimalShelter();

        assertNull(shelter.dequeue("dog"));
    }

    @Test
    public void testDequeue_emptyCatQueue() {
        AnimalShelter shelter = new AnimalShelter();

        assertNull(shelter.dequeue("cat"));
    }
}