package study.problem;

public class Solution {

	public int[] solution(int n, int s) {
		int[] answer = new int[n];
		int idx = 0;
		while (n > 0) {
			int div = s / n;
			if (div <= 0) {
				return new int[]{-1};
			}
			answer[idx++] = div;
			s -= div;
			n--;
		}
		return answer;
	}
}