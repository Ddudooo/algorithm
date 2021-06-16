package study.problem;

import java.util.Stack;

public class Solution {

	public boolean solution(String s) {
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (c == ')') {
				if (stack.isEmpty()) {
					return false;
				}
				stack.pop();
			} else {
				stack.add(c);
			}
		}
		return stack.isEmpty();
	}
}