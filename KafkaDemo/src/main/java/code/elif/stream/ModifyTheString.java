import java.io.*;

import static java.util.stream.Collectors.joining;


class Result {

    /*
     * Complete the 'getString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING input_str as parameter.
     */

    public static String getString(String input_str) {
        int[] count = new int[26];
        StringBuilder result = new StringBuilder();


        for (char c : input_str.toCharArray()) {
            count[c - 'a']++;
        }
        //xtwyrmjpkievgqflsuznbodhca
        //zyxwvutsrqponmlkjihgfedcba
        for (char c : input_str.toCharArray()) {
            count[c - 'a']--;

            if (result.indexOf(String.valueOf(c)) == -1) {
                while (result.length() > 0
                        && c > result.charAt(result.length() - 1)
                        && count[result.charAt(result.length() - 1) - 'a'] > 0) {
                    result.deleteCharAt(result.length() - 1);
                }
                result.append(c);
                System.out.println(result);
            }
        }
        System.out.println(result);
        return result.toString();
    }
}

public class ModifyTheString {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String input_str = bufferedReader.readLine();
        System.out.println("input_str " + input_str);

        String result = Result.getString(input_str);
        System.out.println(result);
        bufferedReader.close();
    }
}


