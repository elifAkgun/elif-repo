package code.elif;

public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);

        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length / 2; i++) {
            int k = chars.length - 1 - i;
            if (chars[i] != chars[k]) {
                return false;
            }
        }
        return true;
    }
}
