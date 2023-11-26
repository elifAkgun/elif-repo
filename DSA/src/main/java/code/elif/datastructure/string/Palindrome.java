package code.elif.datastructure.string;

import java.util.HashMap;
import java.util.Set;

public class Palindrome {

    public static void main(String[] args) {
        System.out.print(longestPalindrome("abccccdksdasdasdwwqwdadsajjkd"));
    }

    public static int longestPalindrome(String s) {

        if (s.length() <= 2) {
            return 1;
        }
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            int value = 0;
            if (hashMap.containsKey(key)) {
                value = hashMap.get(key);
            }
            hashMap.put(key, value + 1);

        }
        int palindrome = 0;
        Set<Character> characters = hashMap.keySet();
        boolean singleCharNotFound = true;

        for (Character c : characters) {
            Integer letterCount = hashMap.get(c);

            if (letterCount % 2 == 0) {
                palindrome += letterCount;
            } else if (letterCount > 2) {
                palindrome += letterCount - 1;
            }
            if (letterCount % 2 == 1 && singleCharNotFound) {
                palindrome = palindrome + 1;
                singleCharNotFound = false;
            }

        }
        return palindrome;

    }
}
