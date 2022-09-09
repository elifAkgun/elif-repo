package code.elif.array;

import java.util.Arrays;

public class Anagram {

    public static void main(String[] args) {
        String subject = "elif";
        String word = "file";
        boolean anagram = isAnagram(subject.toCharArray(), word.toCharArray());

        System.out.println(anagram ?
                subject + " and " + word + " are anagrams."
                : "Two words are not anagrams.");
    }

    private static boolean isAnagram(char[] subject, char[] word) {
        if (subject == null || word == null) {
            return false;
        }
        Arrays.sort(subject);
        Arrays.sort(word);
        return equals(subject, word);
    }

    private static boolean equals(char[] subjectArray, char[] wordArray) {
        for (int i = 0; i < subjectArray.length; i++) {
            if (subjectArray[i] != wordArray[i]) {
                return false;
            }
        }
        return true;
    }
}
