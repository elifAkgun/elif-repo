package code.elif.datastructure.string;

import java.util.HashMap;
import java.util.Map;

public class Isomorphic {
    public static void main(String[] args) {
        isIsomorphic("badc", "baba");
    }

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> dictionary = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            if (dictionary.containsKey(charS)) {
                if (!dictionary.get(charS).equals(charT))
                    return false;
            } else if (dictionary.containsValue(charT)) {
                return false;
            } else {
                dictionary.put(charS, charT);
            }
        }
        return true;

    }
}
