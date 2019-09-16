package hashtable;

import org.junit.Test;

import static org.junit.Assert.*;

public class HashtableTest {

    /*

        Adding a key/value to your hashtable results in the value being in the data structure
        Retrieving based on a key returns the value stored
        Successfully returns null for a key that does not exist in the hashtable
        Successfully handle a collision within the hashtable
        Successfully retrieve a value from a bucket within the hashtable that has a collision
        Successfully hash a key to an in-range value

    */

    @Test
    public void testHash_hashtableLengthOfOne() {
        Hashtable ht = new Hashtable(1);

        assertEquals(0, ht.hash("m"));
        assertEquals(0, ht.hash("matt"));
        assertEquals(0, ht.hash("matthewthomasstuhring"));
    }

    @Test
    public void testHash_singleCharacter() {
        Hashtable ht = new Hashtable(10);

        assertEquals(1, ht.hash("m"));
    }

    @Test
    public void testHash_shortString() {
        Hashtable ht = new Hashtable(10);

        assertEquals(2, ht.hash("matt"));
    }

    @Test
    public void testHash_longString() {
        Hashtable ht = new Hashtable(10);

        assertEquals(2, ht.hash("matthewthomasstuhring"));
    }

    @Test
    public void testAdd_oneHashNode() {
        Hashtable ht = new Hashtable(10);
        ht.add("matt", "matt is user 1");

        assertTrue(ht.contains("matt"));
    }

    @Test
    public void testAdd_twoHashNodes() {
        Hashtable ht = new Hashtable(10);
        ht.add("matt", "matt is user 1");
        ht.add("kyso", "kyso is user 2");

        assertTrue(ht.contains("matt"));
        assertTrue(ht.contains("kyso"));
    }

    @Test
    public void testAdd_FourHashNodes() {
        Hashtable ht = new Hashtable(10);
        ht.add("matt", "matt is user 1");
        ht.add("kyso", "kyso is user 2");
        ht.add("ty", "ty is user 3");
        ht.add("chica", "chica is user 4");

        assertTrue(ht.contains("matt"));
        assertTrue(ht.contains("kyso"));
        assertTrue(ht.contains("ty"));
        assertTrue(ht.contains("chica"));
    }

    @Test
    public void testAdd_singleCollision() {
        Hashtable ht = new Hashtable(10);
        ht.add("matt", "matt is user 1");
        ht.add("kyso", "kyso is user 2");
        ht.add("ty", "ty is user 3");
        ht.add("chica", "chica is user 4");

        assertEquals("kyso is user 2", ht.get("kyso"));
    }

    @Test
    public void testAdd_multipleCollisions() {
        Hashtable ht = new Hashtable(1);
        ht.add("matt", "matt is user 1");
        ht.add("kyso", "kyso is user 2");
        ht.add("ty", "ty is user 3");
        ht.add("chica", "chica is user 4");

        assertTrue(ht.contains("matt"));
        assertTrue(ht.contains("kyso"));
        assertTrue(ht.contains("ty"));
        assertTrue(ht.contains("chica"));
    }

    @Test
    public void testContains_firstHashNodeTrue() {
        Hashtable ht = new Hashtable(10);
        ht.add("matt", "matt is user 1");
        ht.add("kyso", "kyso is user 2");
        ht.add("ty", "ty is user 3");
        ht.add("chica", "chica is user 4");

        assertTrue(ht.contains("matt"));
    }

    @Test
    public void testContains_middleHashNodeTrue() {
        Hashtable ht = new Hashtable(10);
        ht.add("matt", "matt is user 1");
        ht.add("kyso", "kyso is user 2");
        ht.add("ty", "ty is user 3");
        ht.add("chica", "chica is user 4");

        assertTrue(ht.contains("kyso"));
    }

    @Test
    public void testContains_lastHashNodeTrue() {
        Hashtable ht = new Hashtable(10);
        ht.add("matt", "matt is user 1");
        ht.add("kyso", "kyso is user 2");
        ht.add("ty", "ty is user 3");
        ht.add("chica", "chica is user 4");

        assertTrue(ht.contains("chica"));
    }

    @Test
    public void testContains_wrongHashNodeKeySpellingfalse() {
        Hashtable ht = new Hashtable(10);
        ht.add("matt", "matt is user 1");
        ht.add("kyso", "kyso is user 2");
        ht.add("ty", "ty is user 3");
        ht.add("chica", "chica is user 4");

        assertFalse(ht.contains("mattz"));
    }

    @Test
    public void testContains_firstCharacterfalse() {
        Hashtable ht = new Hashtable(10);
        ht.add("matt", "matt is user 1");
        ht.add("kyso", "kyso is user 2");
        ht.add("ty", "ty is user 3");
        ht.add("chica", "chica is user 4");

        assertFalse(ht.contains("m"));
    }

    @Test
    public void testContains_keyDoesNotExits() {
        Hashtable ht = new Hashtable(10);
        ht.add("matt", "matt is user 1");
        ht.add("kyso", "kyso is user 2");
        ht.add("ty", "ty is user 3");
        ht.add("chica", "chica is user 4");

        assertFalse(ht.contains("john"));
    }

    @Test
    public void testGet_hashtableKeyExists() {
        Hashtable ht = new Hashtable(10);
        ht.add("matt", "matt is user 1");
        ht.add("kyso", "kyso is user 2");
        ht.add("ty", "ty is user 3");
        ht.add("chica", "chica is user 4");

        assertEquals("matt is user 1", ht.get("matt"));
    }

    @Test
    public void testGet_hashtableKeyDoesNotExist() {
        Hashtable ht = new Hashtable(10);
        ht.add("matt", "matt is user 1");
        ht.add("kyso", "kyso is user 2");
        ht.add("ty", "ty is user 3");
        ht.add("chica", "chica is user 4");

        assertNull(ht.get("m"));
    }

}