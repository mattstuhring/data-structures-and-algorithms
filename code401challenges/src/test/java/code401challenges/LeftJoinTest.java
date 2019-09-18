package code401challenges;

import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;

import static org.junit.Assert.*;

public class LeftJoinTest {

    @Test
    public void testLeftJoin_emptyHashMap() {
        HashMap<String, String> ht1 = new HashMap<>();
        HashMap<String, String> ht2 = new HashMap<>();

        assertEquals("[]", LeftJoin.leftJoin(ht1, ht2).toString());
    }

    @Test
    public void testLeftJoin_oneEmptyHashMap() {
        HashMap<String, String> ht1 = new HashMap<>();
        ht1.put("fond", "enamored");
        ht1.put("wrath", "anger");
        ht1.put("diligent", "employed");
        ht1.put("outfit", "garb");
        ht1.put("guide", "usher");

        HashMap<String, String> ht2 = new HashMap<>();

        assertEquals("[[diligent, employed, null], [outfit, garb, null], [wrath, anger, null], [guide, usher, null], [fond, enamored, null]]", LeftJoin.leftJoin(ht1, ht2).toString());
    }

    @Test
    public void testLeftJoin_allKeysAreTheSame() {
        HashMap<String, String> ht1 = new HashMap<>();
        ht1.put("fond", "enamored");
        ht1.put("wrath", "anger");
        ht1.put("diligent", "employed");
        ht1.put("outfit", "garb");
        ht1.put("guide", "usher");

        HashMap<String, String> ht2 = new HashMap<>();
        ht2.put("fond", "enamored");
        ht2.put("wrath", "anger");
        ht2.put("diligent", "employed");
        ht2.put("outfit", "garb");
        ht2.put("guide", "usher");

        assertEquals("[[diligent, employed, employed], [outfit, garb, garb], [wrath, anger, anger], [guide, usher, usher], [fond, enamored, enamored]]", LeftJoin.leftJoin(ht1, ht2).toString());
    }

    @Test
    public void testLeftJoin_oneKeyIsTheSame() {
        HashMap<String, String> ht1 = new HashMap<>();
        ht1.put("fond", "enamored");
        ht1.put("wrath", "anger");

        HashMap<String, String> ht2 = new HashMap<>();
        ht2.put("fond", "averse");
        ht2.put("something", "delight");

        assertEquals("[[wrath, anger, null], [fond, enamored, averse]]", LeftJoin.leftJoin(ht1, ht2).toString());
    }

    @Test
    public void testLeftJoin_differentHashMapLengths() {
        HashMap<String, String> ht1 = new HashMap<>();
        ht1.put("fond", "enamored");
        ht1.put("wrath", "anger");
        ht1.put("diligent", "employed");
        ht1.put("outfit", "garb");
        ht1.put("guide", "usher");

        HashMap<String, String> ht2 = new HashMap<>();
        ht2.put("fond", "averse");
        ht2.put("something", "delight");

        assertEquals("[[diligent, employed, null], [outfit, garb, null], [wrath, anger, null], [guide, usher, null], [fond, enamored, averse]]", LeftJoin.leftJoin(ht1, ht2).toString());
    }
}