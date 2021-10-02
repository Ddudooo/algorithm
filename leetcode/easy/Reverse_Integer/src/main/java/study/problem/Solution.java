package study.problem;

public class Solution {

	public int reverse(int x) {
		int result = 0;
		while (x != 0) {
			int remain = x % 10;
			int tmp = result * 10 + remain;

			if ((tmp - remain) / 10 != result) {
				return 0;
			}
			result = tmp;
			x /= 10;
		}
		return result;
	}
}