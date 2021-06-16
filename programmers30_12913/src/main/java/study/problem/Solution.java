package study.problem;

public class Solution {

	public int solution(int[][] land) {
		int[][] temp = new int[land.length][4];
		for (int i = 0; i < 4; i++) {
			temp[0][i] = land[0][i];
		}
		int answer = maxValue(temp[0]);
		if (land.length <= 1) {
			return answer;
		}
		for (int i = 1; i < land.length; i++) {
			for (int j = 0; j < land[i].length; j++) {
				temp[i][j] = Math.max(maxValue(temp[i - 1], j) + land[i][j], temp[i][j]);
			}
		}
		return maxValue(temp[land.length - 1]);
	}

	private int maxValue(int[] rows) {
		int max = rows[0];
		for (int value : rows) {
			max = Math.max(max, value);
		}
		return max;
	}

	private int maxValue(int[] rows, int idx) {
		int max = 0;
		for (int i = 0; i < rows.length; i++) {
			if (idx != i) {
				max = Math.max(max, rows[i]);
			}
		}
		return max;
	}
}