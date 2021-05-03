package code.elif;

import java.util.*;

public class Main {


    public static void main(String args[]) {
        String s = "123456";

        Map<Integer, ArrayList<String>> integerStringMap = new HashMap<>();

        for (int i = 1; i <= s.length()/2 ; i++) {
            int index =0;
            ArrayList<String> arrayList = new ArrayList<>();


            for (int k = 0; k < s.length() ; k++) {
                if(index+i<=s.length()){
                    arrayList.add(s.substring(index, index+i));
                }

                integerStringMap.put(i, arrayList);

                index = index + i;

            }

        }

        System.out.println(integerStringMap);

    }
}

java        100
java        100

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        double d = scan.nextDouble();
        String s = scan.next();

        // Write your code here.
s.length()
        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
    }
}
