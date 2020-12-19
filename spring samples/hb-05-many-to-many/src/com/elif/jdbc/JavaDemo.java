package com.elif.jdbc;

import java.util.Stack;

public class JavaDemo {

	public static void main(String[] args) {
		Double pow = Math.pow(2, 20) - 1;
		//System.out.println(solution((int)Math.ceil(pow) + " 1 +"));
		System.out.println(solution("5 -"));

	}

	public static int solution(String S) {

		String[] split = S.split(" ");

		Stack<Integer> stack = new Stack<Integer>();
		try {

			for (int i = 0; i < split.length; i++) {
				if ("DUP".equals(split[i])) {
					Integer temp = handlePop(stack);
					stack.push(temp);
					stack.push(temp);
				}

				else if ("POP".equals(split[i])) {
					handlePop(stack);
				}

				else if ("+".equals(split[i])) {
					int add = handlePop(stack) + handlePop(stack);

					if (add > Math.pow(2, 20) - 1) {
						return -1;
					}
					stack.push(add);
				}

				else if ("-".equals(split[i])) {
					int sub = handlePop(stack) - handlePop(stack);

					if (sub >= 0) {
						stack.push(sub);
					}

					else {
						return -1;
					}
				}

				else {
					Integer integer = new Integer(split[i]);
					stack.push(integer);

				}
			}
			if (split.length == 0) {
				return -1;
			}

			return handlePop(stack);

		} catch (Exception ex) {
			return -1;
		}
	}

	private static Integer handlePop(Stack<Integer> stack) throws Exception {

		if (stack.size() >= 0)
			return stack.pop();

		throw new Exception("Stack has no element to pop");
	}
}
