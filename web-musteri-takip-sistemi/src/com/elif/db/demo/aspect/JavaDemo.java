package com.elif.db.demo.aspect;

public class JavaDemo {

	

	public static void main(String[] args) {

		int N = 15;
		System.out.println(solution(N));

	}

	// you can also use imports, for example:
	// import java.util.*;

	// you can write to stdout for debugging purposes, e.g.
	// System.out.println("this is a debug message");

	static public int solution(int N) {
		String s = Integer.toBinaryString(N);

		String[] split = s.split("1");
		int max =0;
		for (int i = 0; i < split.length-2; i++) {
			max = split[i+1].length();
			
			if(split[i].length()>max) {
				max= split[i].length();
			}
		}

		return max;

	}
}
