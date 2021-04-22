package study.programmers30_12899;

public class Solution {

	private final String[] numbers = {"4", "1", "2"};

	public String solution(int n) {
		StringBuffer sb = new StringBuffer("");
		while (n > 0) {
			int remainder = n % 3;
			sb.insert(0, numbers[remainder]);
			if (remainder == 0) {
				n = n / 3 - 1;
			} else {
				n = n / 3;
			}
		}
		return sb.toString();
	}
}