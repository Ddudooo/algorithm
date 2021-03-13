package study.baekjoon2206;

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
	static int n, m;
	static boolean[][] map;
	static int[][][] visit;

	static int[] dirX = new int[]{0, 0, -1, 1};
	static int[] dirY = new int[]{-1, 1, 0, 0};

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int[][][] map = new int[2][n][m];
		int[][][] check = new int[2][n][m];
		int[] dirX = new int[]{0, 0, -1, 1};
		int[] dirY = new int[]{-1, 1, 0, 0};
		for (int i = 0; i < n; i++) {
			String data = br.readLine();
			for (int j = 0; j < m; j++) {
				map[0][i][j] = (Character.getNumericValue(data.charAt(j)));
				map[1][i][j] = map[0][i][j];
				check[0][i][j] = 0;
				check[1][i][j] = 0;
			}
		}
		//입력끝

		Queue<Point> search = new LinkedList<>();
		check[0][0][0] = 1;
		check[1][0][0] = 1;

		search.add(new Point(0, 0));
		int nX = 0;
		int nY = 0;
		while (!search.isEmpty()) {
			Point base = search.poll();
			for (int i = 0; i < 4; i++) {
				int x = base.x + dirX[i];
				int y = base.y + dirY[i];
				int wall = base.wall;
				if (x < 0 || y < 0 || x >= n || y >= m) {//범위 벗어나면 넘어감
					continue;
				}
				if (check[wall][x][y] > 0/*|| map[x][y]==1*/) { //방문했으면 넘어감
					continue;
				}
				if (map[wall][x][y] == 1) {
					//다음 예정지가 벽이면
					if (wall == 0) {
						//부순벽이없을경우
						// 부수고 지나감
						wall++;
					} else {
						//한번이라도 부순벽이 있을 경우 넘어감
						continue;
					}
				}
				search.add(new Point(x, y, wall));//다음 조회지 좌표 + 부순 횟수

				//map[wall][x][y] = (map[base.wall][base.x][base.y] + 1);
				check[wall][x][y] = check[base.wall][base.x][base.y] + 1;
			}
		}
		int unBroken = check[0][n - 1][m - 1];
		int broken = check[1][n - 1][m - 1];

		if (unBroken == broken && broken == 0) {
			bw.write("-1");
		} else {
			unBroken = unBroken == 0 ? Integer.MAX_VALUE : unBroken;
			broken = broken == 0 ? Integer.MAX_VALUE : broken;
			bw.write(String.valueOf(Math.min(unBroken, broken)));
		}
		bw.flush();
		br.close();
		bw.close();
	}
}

class Point {

	int wall;
	int x;
	int y;

	public Point(int x, int y) {
		new Point(x, y, 0);
	}

	public Point(int x, int y, int wall) {
		this.x = x;
		this.y = y;
		this.wall = wall;
	}
}