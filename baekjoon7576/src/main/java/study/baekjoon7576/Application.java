package study.baekjoon7576;

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

	static int m, n;
	static int[][] map;
	static boolean[][] visit;
	static int day = -1;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visit = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int input = Integer.parseInt(st.nextToken());
				map[i][j] = input;
				visit[i][j] = input == -1;
			}
		}
		solve();
		day = day == -1 ? day : day - 1;
		bw.write(String.valueOf(day));
		bw.flush();
		bw.close();
		br.close();
	}

	public static void solve() {
		//1 찾아서 큐에 넣기
		Queue<Point> queue = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1) {
					queue.add(new Point(i, j));
				}
			}
		}
		//다음날계산 ~ n
		//nextDay(queue);
		while (!queue.isEmpty()) {
			Point poll = queue.poll();
			int x = poll.x;
			int y = poll.y;
			if (!visit[x][y]) {
				//System.out.printf("Day[%d] | Point y = %d, x = %d \n", day + 1, x, y);
				visit[x][y] = true;
			}

			//상
			if (y > 0) {
				if (!visit[x][y - 1] && map[x][y - 1] == 0) {
					queue.add(new Point(x, y - 1));
					map[x][y - 1] = map[x][y] + 1;
				}
			}
			//하
			if (y < m - 1) {
				if (!visit[x][y + 1] && map[x][y + 1] == 0) {
					queue.add(new Point(x, y + 1));
					map[x][y + 1] = map[x][y] + 1;
				}
			}
			//좌
			if (x > 0) {
				if (!visit[x - 1][y] && map[x - 1][y] == 0) {
					queue.add(new Point(x - 1, y));
					map[x - 1][y] = map[x][y] + 1;
				}
			}
			//우
			if (x < n - 1) {
				if (!visit[x + 1][y] && map[x + 1][y] == 0) {
					queue.add(new Point(x + 1, y));
					map[x + 1][y] = map[x][y] + 1;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visit[i][j]) {
					day = -1;
					return;
				} else {
					day = Math.max(map[i][j], day);
				}
			}
		}
	}
}

class Point {

	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}