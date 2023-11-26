package code.elif.datastructure.string;

public class Subsequence {
    public static void main(String[] args) {
        isSubsequence("ab",
                "baab");
    }

    /**
     * Runtime: 5 ms, faster than 12.72% of Java online submissions for Is Subsequence.
     * Memory Usage: 42.4 MB, less than 23.03% of Java online submissions for Is Subsequence.
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubsequence1(String s, String t) {

        if (s.length() == 0)
            return true;

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int j = 0;
        for (int i = 0; i < t.length(); i++) {
            if (tChars[i] == sChars[j]) {
                j++;
            }
            if (j == s.length())
                return true;
        }
        return false;
    }

    public static boolean isSubsequence(String s, String t) {

        if (s.length() == 0)
            return true;
        int j = 0;
        for (int i = 0; i < t.length(); i++) {
            int index = t.indexOf(s.charAt(j),i);
            if (index > i - 1) {
                i = index;
                j++;
                if (j == s.length())
                    return true;
            }
        }
        return false;
    }
}
