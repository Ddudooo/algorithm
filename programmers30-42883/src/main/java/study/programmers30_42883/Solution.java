package study.programmers30_42883;

public class Solution {

	public String solution(String number, int k) {
		StringBuilder sb = new StringBuilder();
		int idx = 0;
		for (int i = 0; i < number.length() - k; i++) {
			int max = 0;
			for (int j = idx; j <= i + k; j++) {
				int charInt = number.charAt(j) - '0';
				if (max < charInt) {
					max = charInt;
					idx = j + 1;
				}
			}
			sb.append(max);
		}
		return sb.toString();
	}
}