package study.problem;

import java.util.Arrays;

public class Solution {

	public long solution(int n, int[] times) {
		Arrays.sort(times);
		long min = (long) times[0];
		long max = (long) times[times.length - 1] * n;
		long answer = max;
		while (min <= max) {
			long cnt = 0;
			long mid = (min + max) / 2;
			for (int time : times) {
				cnt += mid / time;
			}
			if (cnt >= n) {
				answer = Math.min(answer, mid);
				max = mid - 1;
			} else {
				min = mid + 1;
			}
		}
		return answer;
	}
}