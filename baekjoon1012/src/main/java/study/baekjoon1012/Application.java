package study.baekjoon1012;

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

	static int m;
	static int n;

	static int result;

	static boolean[][] map;
	static boolean[][] visit;
	static Queue<Point> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		int testCase = Integer.parseInt(br.readLine());
		for (int test = 0; test < testCase; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			map = new boolean[m][n];
			visit = new boolean[m][n];
			queue = new LinkedList<>();
			result = 0;
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[x][y] = true;
			}

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (!visit[i][j] && map[i][j]) {
						solve(i, j);
						result++;
					}
				}
			}
			StringBuffer sb = new StringBuffer();
			sb.append(result).append("\n");
			bw.write(sb.toString());
			bw.flush();
		}
		bw.close();
		br.close();
	}

	public static void solve(int x, int y) {
		if (!visit[x][y] && map[x][y]) {
			visit[x][y] = true;
		}
		//left
		if (x > 0) {
			if (!visit[x - 1][y] && map[x - 1][y]) {
				queue.add(new Point(x - 1, y));
				visit[x - 1][y] = true;
			}
		}
		//right
		if (x < m - 1) {
			if (!visit[x + 1][y] && map[x + 1][y]) {
				queue.add(new Point(x + 1, y));
				visit[x + 1][y] = true;
			}
		}
		//under
		if (y < n - 1) {
			if (!visit[x][y + 1] && map[x][y + 1]) {
				queue.add(new Point(x, y + 1));
				visit[x][y + 1] = true;
			}
		}

		//upder
		if (y > 0) {
			if (!visit[x][y - 1] && map[x][y - 1]) {
				queue.add(new Point(x, y - 1));
				visit[x][y - 1] = true;
			}
		}

		while (!queue.isEmpty()) {
			Point poll = queue.poll();
			solve(poll.x, poll.y);
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