package code.elif.datastructure.array;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class Anagram {

    private static final Logger logger = LoggerFactory.getLogger(Anagram.class);

    public static void main(String[] args) {
        String subject = "elif";
        String word = "file";
        boolean anagram = isAnagram(subject.toCharArray(), word.toCharArray());

        if (anagram) {
            logger.info("Anagram found");
            logger.info("{} and {} are anagrams.", subject, word);
        } else {
            logger.info("Not Anagram found");
        }
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
