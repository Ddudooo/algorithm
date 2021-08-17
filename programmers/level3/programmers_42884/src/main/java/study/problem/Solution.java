package study.problem;

import java.util.Arrays;

public class Solution {

	public int solution(int[][] routes) {
		int answer = 0;
		Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
		int preEnd = Integer.MIN_VALUE;
		for (int[] route : routes) {
			if (answer == 0) {
				preEnd = route[1];
				answer++;
				continue;
			}
			int start = route[0];
			int end = route[1];
			if (start > preEnd) {
				preEnd = end;
				answer++;
			}
		}
		return answer;
	}
}