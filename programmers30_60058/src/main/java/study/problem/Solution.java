package study.problem;

import java.util.Stack;

public class Solution {

	public String solution(String origin) {
		if (isBracketUnClosable(origin)) {
			String[] split = getSplitBracket(origin);
			if (isBracketUnClosable(split[0])) {
				return makeBracket(split[0], split[1]);
			} else {
				return split[0] + solution(split[1]);
			}
		} else {
			return origin;
		}
	}

	private String[] getSplitBracket(String expression) {
		String[] result = new String[]{"", ""};
		int idx = 0;
		int left = 0;
		int right = 0;
		for (char c : expression.toCharArray()) {
			if (c == '(') {
				left++;
			} else if (c == ')') {
				right++;
			}
			result[idx] += c;
			if (idx == 0 && left == right && left > 0) {
				idx++;
			}
		}
		return result;
	}

	private String makeBracket(String u, String v) {
		StringBuilder sb = new StringBuilder();
		sb.append("(").append(solution(v)).append(")");
		String substring = u.substring(1, u.length() - 1);
		for (char c : substring.toCharArray()) {
			if (c == '(') {
				sb.append(')');
			}
			if (c == ')') {
				sb.append('(');
			}
		}
		return sb.toString();
	}

	private boolean isBracketUnClosable(String expression) {
		Stack<Character> stack = new Stack<>();
		for (char c : expression.toCharArray()) {
			if (!stack.isEmpty() && c == ')' && stack.peek() == '(') {
				stack.pop();
			} else {
				stack.add(c);
			}
		}
		return !stack.isEmpty();
	}
}