package code.elif.datastructure.array;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairLetters {

    private static final Logger logger = LoggerFactory.getLogger(PairLetters.class);

    public static void main(String[] args) {

        List<String> words = List.of("ANT", "TIGER", "RABBIT", "TEA");
        boolean cycled = isCycled(words);

        logger.info(String.valueOf(cycled));
    }

    private static boolean isCycled(List<String> words) {

        Map<String, Integer> firstLetterMap = new HashMap<>();
        Map<String, Integer> lastLetterMap = new HashMap<>();

        for (String word : words) {
            String firstLetter = word.substring(0, 1);
            firstLetterMap.put(firstLetter, firstLetterMap.get(firstLetter) == null ? 1 : firstLetterMap.get(firstLetter) + 1);

            String lastLetter = word.substring(word.length() - 1, word.length());
            lastLetterMap.put(lastLetter, lastLetterMap.get(lastLetter) == null ? 1 : lastLetterMap.get(lastLetter) + 1);
        }

        if (firstLetterMap.size() != lastLetterMap.size()) {
            return false;
        } else {
            for (Map.Entry<String, Integer> firstLetter : firstLetterMap.entrySet()) {
                if (!firstLetter.getValue().equals(lastLetterMap.get(firstLetter.getKey())))
                    return false;
            }
            return true;
        }
    }
}
