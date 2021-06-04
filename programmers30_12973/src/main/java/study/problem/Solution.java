package study.problem;

import java.util.Stack;

public class Solution {

	public int solution(String s) {
		Stack<Character> input = new Stack<>();

		for (char c : s.toCharArray()) {
			if (input.isEmpty()) {
				input.add(c);
			} else if (input.peek() == c) {
				input.pop();
			} else {
				input.add(c);
			}
		}

		return input.size() > 0 ? 0 : 1;
	}
}