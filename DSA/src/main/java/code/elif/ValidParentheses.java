package code.elif;

import java.util.*;

public class ValidParentheses {

    static HashMap<String, String> parentheses = new HashMap<>();

    static {
        parentheses.put("(", ")");
        parentheses.put("{", "}");
        parentheses.put("[", "]");
    }

    public static void main(String[] args) {
        String s = "([)]";
    }

    public boolean isValid(String s) {
        String[] splitedString = s.split("");
        LinkedList<String> list = new LinkedList<>(Arrays.asList(splitedString));
        Stack<String> cursorList = new Stack<>();

        if (list.isEmpty() && list.size() == 1) {
            return false;
        }

        String cursor = list.pop();
        cursorList.add(cursor);

        while (!list.isEmpty()) {
            if (!parentheses.containsKey(cursorList.peek())) {
                return false;
            } else if (!parentheses.get(cursorList.peek()).equals(list.peek())) {
                cursorList.add(list.pop());
            } else {
                cursorList.pop();
                list.pop();
            }

            if (cursorList.isEmpty() && list.isEmpty()) {
                return true;
            }

            if (cursorList.isEmpty()) {
                cursorList.add(list.pop());
            }
        }
        return false;
    }
}
