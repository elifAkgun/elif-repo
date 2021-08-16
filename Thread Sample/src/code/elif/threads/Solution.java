package code.elif.threads;

import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    static boolean isAnagram(String a, String b) {


        if (a.length() != b.length()) {
            return false;
        } else {
            a=a.toUpperCase();
            b= b.toUpperCase();

            char[] chA = a.toCharArray();
            char[] chB = b.toCharArray();


            for (int i = 0; i < chA.length; i++) {
                int positionOfChar = b.indexOf(chA[i]);
                if (positionOfChar > -1) {
                    chB[positionOfChar] = '.';
                    b = new String(chB);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println((ret) ? "Anagrams" : "Not Anagrams");
    }
}