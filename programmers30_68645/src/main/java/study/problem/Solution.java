package study.problem;

public class Solution {

	static int[] dx = {0, 1, -1};
	static int[] dy = {1, 0, -1};

	public int[] solution(int n) {
		int maxValue = 0;
		for (int i = 1; i <= n; i++) {
			maxValue += i;
		}
		int[][] map = new int[n][n];
		int y = 0;
		int x = 0;
		int startValue = 1;
		int rotate = 0;
		while (startValue <= maxValue) {
			while ((y >= 0 && y < n) && (x >= 0 && x < n) && (map[y][x] == 0)) {
				map[y][x] = startValue++;
				y += dy[rotate % 3];
				x += dx[rotate % 3];
			}
			y -= dy[rotate % 3];
			x -= dx[rotate % 3];
			rotate++;
			y += dy[rotate % 3];
			x += dx[rotate % 3];
		}
		int[] answer = new int[maxValue];
		int idx = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] != 0) {
					answer[idx++] = map[i][j];
				}
			}
		}
		return answer;
	}


}