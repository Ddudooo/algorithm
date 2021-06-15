package study.problem;

public class Solution {

	public int solution(int[][] board) {
		int maxValue = 0;
		if (board[0].length <= 1 || board.length <= 1) {
			return 1;
		}
		for (int i = 1; i < board.length; i++) {
			for (int j = 1; j < board[i].length; j++) {
				if (board[i][j] == 1) {
					int minValue = minValue(board[i - 1][j], board[i][j - 1], board[i - 1][j - 1]);
					board[i][j] = minValue + 1;
					maxValue = Math.max(maxValue, board[i][j]);
				}
			}
		}
		return (int) Math.pow(maxValue, 2);
	}

	public int minValue(int... values) {
		int min = values[0];
		for (int value : values) {
			min = Math.min(value, min);
		}
		return min;
	}
}