package code.elif.datastructure.string;

public class SortSentence {

    public String sortSentence(String s) {

        if (s.length() == 2) {
            char[] chars = s.toCharArray();
            return String.valueOf(chars[0]);
        }

        String[] words = s.split(" ");

        char[][] arr = new char[words.length][];

        for (int i = 0; i < words.length; i++) {
            char[] chars = words[i].toCharArray();
            int index = Character.getNumericValue(chars[chars.length - 1]) - 1;
            arr[index] = chars;
        }
        StringBuilder sentence = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sentence.append(arr[i], 0, arr[i].length - 1);
            sentence.append(" ");
        }

        return sentence.toString().trim();
    }
}
