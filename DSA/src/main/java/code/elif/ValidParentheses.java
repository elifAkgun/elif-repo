package code.elif;

import code.elif.datastructure.stack.Stack;
import code.elif.datastructure.stack.impl.StackLinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class ValidParentheses {

    static final HashMap<String, String> parentheses = new HashMap<>();

    static {
        parentheses.put("(", ")");
        parentheses.put("{", "}");
        parentheses.put("[", "]");
    }

    public static ArrayList<Integer> findEvenNumbers(int[] numbers) {
        ArrayList<Integer> evenNumbers = new ArrayList<>();
        for (int number : numbers) {
            if (number % 2 == 0) {
                evenNumbers.add(number);
            }
        }

        return evenNumbers;
    }

    public boolean isValid(String s) {

        if (s == null || s.isEmpty()) {
            return false;
        }

        String[] splitedString = s.split("");
        LinkedList<String> list = new LinkedList<>(Arrays.asList(splitedString));
        Stack<String> cursorList = new StackLinkedList<>();

        String cursor = list.pop();
        cursorList.push(cursor);

        while (!list.isEmpty()) {
            if (!parentheses.containsKey(cursorList.peek())) {
                return false;
            } else if (!parentheses.get(cursorList.peek()).equals(list.peek())) {
                cursorList.push(list.pop());
            } else {
                cursorList.pop();
                list.pop();
            }

            if (cursorList.isEmpty()) {
                if (list.isEmpty()) {
                    return true;
                }
                cursorList.push(list.pop());
            }
        }
        return false;
    }

}
