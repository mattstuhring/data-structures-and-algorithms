package code401challenges;

import hashtable.Hashtable;

import java.util.Arrays;

public class RepeatedWord {

    public static String repeatedWord(String str) {
        // https://stackoverflow.com/questions/18830813/how-can-i-remove-punctuation-from-input-text-in-java
        String[] words = str.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
        Hashtable ht = new Hashtable(words.length);

        for (int i = 0; i < words.length; i++) {
            if (ht.contains(words[i]) && ht.get(words[i]).equals(words[i])) {
                return words[i];
            }

            ht.add(words[i], words[i]);
        }

        return null;
    }
}
