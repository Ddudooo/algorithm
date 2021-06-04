package study.problem;

public class Solution {

	public int solution(String s) {
		int index = isContainPair(s);
		while (index != -1) {
			s = removePair(s, index);
			index = isContainPair(s);
		}
		return s.length() > 0 ? 0 : 1;
	}

	private int isContainPair(String s) {
		for (int i = 0; i < s.length() - 1; i++) {
			char cur = s.charAt(i);
			char next = s.charAt(i + 1);
			if (cur == next) {
				return i;
			}
		}
		return -1;
	}

	private String removePair(String s, int index) {
		StringBuilder sb = new StringBuilder();
		sb.append(s, 0, index);
		sb.append(s.substring(index + 2));
		return sb.toString();
	}
}