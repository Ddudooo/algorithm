package study.problem;

import java.util.Arrays;

public class Solution {

	public int solution(int n, int[] money) {
		Arrays.sort(money);
		int[] result = new int[n + 1];
		result[0] = 1;
		for (int value : money) {
			for (int i = value; i <= n; i++) {
				result[i] += result[i - value];
			}
		}
		return result[n];
	}
}