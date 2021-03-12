package study.baekjoon7569;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Application {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int m, n, h;

	static int[][][] map;
	static boolean[][][] visit;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		map = new int[h][n][m];
		visit = new boolean[h][n][m];

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < m; k++) {
					int input = Integer.parseInt(st.nextToken());
					map[i][j][k] = input;
					if (input == -1) {
						visit[i][j][k] = true;
					}
				}
			}
		}
		int solve = solve();
		bw.write(String.valueOf(solve == -1 ? -1 : solve - 1));
		bw.flush();
		bw.close();
		br.close();
	}

	public static int solve() {
		Queue<Point> queue = new LinkedList<>();
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (!visit[i][j][k] && map[i][j][k] == 1) {
						queue.add(new Point(i, j, k));
					}
				}
			}
		}

		while (!queue.isEmpty()) {
			Point poll = queue.poll();
			int height = poll.height;
			int x = poll.x;
			int y = poll.y;
			if (!visit[height][x][y]) {
				visit[height][x][y] = true;
			}
			//상
			if (x > 0) {
				if (!visit[height][x - 1][y] && map[height][x - 1][y] == 0) {
					queue.add(new Point(height, x - 1, y));
					map[height][x - 1][y] = map[height][x][y] + 1;
				}
			}
			//하
			if (x < n - 1) {
				if (!visit[height][x + 1][y] && map[height][x + 1][y] == 0) {
					queue.add(new Point(height, x + 1, y));
					map[height][x + 1][y] = map[height][x][y] + 1;
				}
			}
			//좌
			if (y > 0) {
				if (!visit[height][x][y - 1] && map[height][x][y - 1] == 0) {
					queue.add(new Point(height, x, y - 1));
					map[height][x][y - 1] = map[height][x][y] + 1;
				}
			}
			//우
			if (y < m - 1) {
				if (!visit[height][x][y + 1] && map[height][x][y + 1] == 0) {
					queue.add(new Point(height, x, y + 1));
					map[height][x][y + 1] = map[height][x][y] + 1;
				}
			}
			//위
			if (height > 0) {
				if (!visit[height - 1][x][y] && map[height - 1][x][y] == 0) {
					queue.add(new Point(height - 1, x, y));
					map[height - 1][x][y] = map[height][x][y] + 1;
				}
			}
			//아래
			if (height < h - 1) {
				if (!visit[height + 1][x][y] && map[height + 1][x][y] == 0) {
					queue.add(new Point(height + 1, x, y));
					map[height + 1][x][y] = map[height][x][y] + 1;
				}
			}
		}
		int day = 0;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (!visit[i][j][k]) {
						return -1;
					} else {
						day = Math.max(day, map[i][j][k]);
					}
				}
			}
		}
		return day;
	}
}

class Point {

	int height;
	int x;
	int y;

	public Point(int height, int x, int y) {
		this.height = height;
		this.x = x;
		this.y = y;
	}
}