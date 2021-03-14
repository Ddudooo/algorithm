package study.baekjoon7562;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

public class Application {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int n;
	static int[][] map;

	static int[] dirX = new int[]{-1, 1, -1, 1, -2, -2, 2, 2};
	static int[] dirY = new int[]{-2, -2, 2, 2, -1, 1, -1, 1};

	static final String NEW_LINE = "\n";

	public static void main(String[] args) throws IOException {
		int testCase = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		for (int test = 0; test < testCase; test++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			Point start = Point.of(x, y);

			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			Point end = Point.of(x, y);
			int answer = solve(start, end);
			sb.append(answer).append(NEW_LINE);
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static int solve(Point start, Point end) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(start);
		if (start.equals(end)) {
			return 0;
		}
		while (!queue.isEmpty()) {
			Point poll = queue.poll();
			for (int p = 0; p < 8; p++) {
				Point nextPoint = Point.of(poll.x + dirX[p], poll.y + dirY[p]);
				if (nextPoint.x >= n || nextPoint.x < 0 ||
					nextPoint.y >= n || nextPoint.y < 0
				) {
					continue;
				}
				if (map[nextPoint.x][nextPoint.y] > 0) {
					continue;
				}

				map[nextPoint.x][nextPoint.y] = map[poll.x][poll.y] + 1;
				
				if (nextPoint.equals(end)) {
					return map[end.x][end.y];
				} else {
					queue.add(nextPoint);
				}
			}
		}
		return map[end.x][end.y];
	}
}

class Point {

	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public static Point of(int x, int y) {
		return new Point(x, y);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Point point = (Point) o;
		return x == point.x && y == point.y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}
}