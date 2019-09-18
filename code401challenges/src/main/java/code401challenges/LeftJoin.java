package code401challenges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class LeftJoin {

    public static ArrayList<ArrayList<String>> leftJoin(HashMap ht1, HashMap ht2) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        Set ht1KeySet  = ht1.keySet();
        for (Object key : ht1KeySet) {
            ArrayList<String> strings = new ArrayList<>();

            strings.add(String.valueOf(key));
            strings.add(String.valueOf(ht1.get(key)));

            if (ht2.containsKey(key)) {
                strings.add(String.valueOf(ht2.get(key)));
            } else {
                strings.add(null);
            }

            result.add(strings);
        }

        return result;
    }
}
