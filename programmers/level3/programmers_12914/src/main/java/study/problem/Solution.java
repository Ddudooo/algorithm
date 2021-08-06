package study.problem;

public class Solution {

	public long solution(int n) {
		return fibonacci(n);
	}

	private long fibonacci(int n) {
		if (n <= 2) {
			return n;
		}
		long[] memorized = new long[n + 1];
		memorized[1] = 1;
		memorized[2] = 2;
		for (int i = 3; i <= n; i++) {
			memorized[i] = (memorized[i - 1] + memorized[i - 2]) % 1234567;
		}
		return memorized[n];
	}
}