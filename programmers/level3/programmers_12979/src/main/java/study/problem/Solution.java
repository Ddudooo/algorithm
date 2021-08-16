package study.problem;

public class Solution {

	public int solution(int n, int[] stations, int w) {
		int answer = 0;
		int preEnd = 1;
		int coverage = 2 * w + 1;
		for (int station : stations) {
			int start = Math.max(1, station - w);
			int end = Math.min(n, station + w);
			int interval = start - preEnd;
			preEnd = end + 1;
			if (interval <= 0) {
				continue;
			}
			answer += calculateStation(interval, coverage);
		}
		if (preEnd <= n) {
			int interval = n + 1 - preEnd;
			answer += calculateStation(interval, coverage);
		}

		return answer;
	}

	private int calculateStation(int interval, int coverage) {

		int station = interval / coverage;
		if (interval % coverage > 0) {
			station++;
		}
		return station;
	}
}