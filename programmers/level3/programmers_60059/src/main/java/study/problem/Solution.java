package study.problem;

public class Solution {

	private int[][] map;
	private int N;

	public boolean solution(int[][] key, int[][] lock) {
		N = lock.length;
		clone(lock);
		boolean answer = false;
		for (int i = 0; i < 2 * N; i++) {
			for (int j = 0; j < 2 * N; j++) {
				for (int r = 0; r < 4; r++) {
					try {
						int[][] matched = matched(i, j, map, key);
						print(matched, Point.of(i, j));
						if (isUnlocked(matched)) {
							return true;
						}
					} catch (Exception e) {
						// nothing
					} finally {
						key = rotate(key);
						clone(lock);
					}
				}
			}
		}
		return answer;
	}

	private int[][] matched(int x, int y, int[][] map, int[][] key) {
		int n = key.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (key[i][j] == 1) {
					if (map[i + x][j + y] == 1) {
						throw new IllegalArgumentException("not matched");
					}
					map[i + x][j + y] = key[i][j];
				}
			}
		}
		return map;
	}

	private int[][] rotate(int[][] key) {
		int n = key.length;
		int[][] rotate = new int[n][n];
		for (int[] row : key) {
			for (int v : row) {
				System.out.printf("%2d", v);
			}
			System.out.println();
		}
		System.out.println("rotate");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				rotate[i][j] = key[n - 1 - j][i];
			}
		}
		for (int[] row : rotate) {
			for (int v : row) {
				System.out.printf("%2d", v);
			}
			System.out.println();
		}
		System.out.println("========");
		return rotate;
	}

	private boolean isUnlocked(int[][] map) {
		for (int i = N + 1; i < 2 * N; i++) {
			for (int j = N + 1; j < 2 * N; j++) {
				if (map[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	private void clone(int[][] lock) {
		N = lock.length;
		map = new int[N * 3][N * 3];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i + N][j + N] = lock[i][j];
			}
		}
	}

	private void print(int[][] map, Point... points) {
		final String ANSI_RESET = "\u001B[0m";
		final String ANSI_RED = "\u001B[31m";
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				for (Point point : points) {
					if (point.isMatched(i, j)) {
						System.out.print(ANSI_RED);
						break;
					}
				}
				System.out.printf("%2d", map[i][j]);
				System.out.print(ANSI_RESET);
			}
			System.out.println();
		}
	}
}

class Point {

	private final int x;
	private final int y;

	private Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public static Point of(int x, int y) {
		return new Point(x, y);
	}

	public boolean isMatched(int x, int y) {
		return x == this.x && y == this.y;
	}
}