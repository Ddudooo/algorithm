package study.problem;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	private static int[] dx = {0, 1, 0, -1};
	private static int[] dy = {1, 0, -1, 0};

	public int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;
		int[][] map = copy(picture);
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] != 0) {
					int cnt = bfs(i, j, map);
					numberOfArea++;
					maxSizeOfOneArea = Math.max(cnt, maxSizeOfOneArea);
				}
			}
		}
		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		return answer;
	}

	private int[][] copy(int[][] origin) {
		int rows = origin.length;
		int column = origin[0].length;
		int[][] copy = new int[rows][column];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < column; j++) {
				copy[i][j] = origin[i][j];
			}
		}
		return copy;
	}

	private int bfs(int x, int y, int[][] picture) {
		int cnt = 0;
		Queue<Entry> queue = new LinkedList<>();
		int area = picture[x][y];
		picture[x][y] = 0;
		queue.add(Entry.of(x, y));
		while (!queue.isEmpty()) {
			Entry cur = queue.poll();
			cnt++;
			int curX = cur.getX();
			int curY = cur.getY();
			for (int i = 0; i < 4; i++) {
				int nextX = curX + dx[i];
				int nextY = curY + dy[i];
				if (nextX < 0
					|| nextY < 0
					|| nextX >= picture.length
					|| nextY >= picture[0].length) {
					continue;
				}
				if (picture[nextX][nextY] != area) {
					continue;
				}
				picture[nextX][nextY] = 0;
				queue.add(Entry.of(nextX, nextY));
			}
		}
		return cnt;
	}
}

class Entry {

	private final int x;
	private final int y;

	private Entry(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public static Entry of(int x, int y) {
		return new Entry(x, y);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}