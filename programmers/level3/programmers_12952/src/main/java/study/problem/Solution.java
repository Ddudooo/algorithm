package study.problem;

public class Solution {

	private int answer = 0;

	public int solution(int n) {
		int[] map = new int[n];
		for (int i = 0; i < n; i++) {
			map[0] = i;
			dfs(1, map);
		}
		return answer;
	}

	private void dfs(int row, int[] map) {
		if (row == map.length) {
			answer++;
			return;
		}
		for (int i = 0; i < map.length; i++) {
			map[row] = i;
			if (isQueenAble(row, map)) {
				dfs(row + 1, map);
			}
		}
	}

	private boolean isQueenAble(int row, int[] map) {
		// 현재 줄에 값을 넣기 위해
		// 퀸자리를 넣은 이전 줄까지만 검사 
		for (int i = 0; i < row; i++) {
			if (map[i] == map[row]) {
				// 같은 행에 존재할 경우
				return false;
			}
			if (Math.abs(row - i) == Math.abs(map[row] - map[i])) {
				// 대각선 상에 놓인 경우
				return false;
			}
		}
		return true;
	}
}