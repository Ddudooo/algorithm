package study.problem;

import java.util.Stack;

public class Solution {

	public int solution(String s) {
		int answer = 0;
		for (int i = 0; i < s.length(); i++) {
			s = rotate(s);
			if (isBracketsClosed(s)) {
				answer++;
			}
		}
		return answer;
	}

	private String rotate(String input) {
		StringBuilder sb = new StringBuilder(input.substring(1));
		sb.append(input.charAt(0));
		return sb.toString();
	}

	private boolean isBracketsClosed(String input) {
		Stack<Character> stack = new Stack<>();
		for (char c : input.toCharArray()) {
			switch (c) {
				case ')':
					if (!stack.isEmpty() && stack.peek() == '(') {
						stack.pop();
						break;
					}

				case '}':
					if (!stack.isEmpty() && stack.peek() == '{') {
						stack.pop();
						break;
					}
				case ']':
					if (!stack.isEmpty() && stack.peek() == '[') {
						stack.pop();
						break;
					}
				default:
					stack.add(c);
			}
		}
		return stack.isEmpty();
	}
}