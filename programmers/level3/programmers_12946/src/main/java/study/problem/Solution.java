package study.problem;

public class Solution {

	private int[][] answer;
	private int idx;

	public int[][] solution(int n) {
		int max = (int) (Math.pow(2, n) - 1);
		answer = new int[max][2];
		idx = 0;
		hanoi(n, 1, 3, 2);
		return answer;
	}

	private void hanoi(int n, int from, int to, int waypoint) {
		int[] move = {from, to};

		if (n == 1) {
			answer[idx++] = move;
		} else {
			hanoi(n - 1, from, waypoint, to);
			answer[idx++] = move;
			hanoi(n - 1, waypoint, to, from);
		}
	}
}