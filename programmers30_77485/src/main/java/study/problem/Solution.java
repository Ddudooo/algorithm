package study.problem;

public class Solution {

	public int[] solution(int rows, int columns, int[][] queries) {
		int[] answer = new int[queries.length];
		int[][] map = initMap(rows, columns);
		for (int i = 0; i < queries.length; i++) {
			answer[i] = rotate(map, Query.of(queries[i]));
		}
		return answer;
	}

	private int rotate(int[][] map, Query query) {
		int startPoint = map[query.a.x][query.a.y];
		int min = startPoint;
		//상단 우측으로 | a.x -> b.x , a.y 그대로
		for (int x = query.a.x; x < query.b.x; x++) {
			map[x][query.a.y] = map[x + 1][query.a.y];
			min = Math.min(min, map[x][query.a.y]);
		}
		//우변 하단으로 | b.x 그대로, a.y -> b.y
		for (int y = query.a.y; y < query.b.y; y++) {
			map[query.b.x][y] = map[query.b.x][y + 1];
			min = Math.min(min, map[query.b.x][y]);
		}

		// 하단 좌측으로 | b.x -> a.x | b.y 그대로
		for (int x = query.b.x; x > query.a.x; x--) {
			map[x][query.b.y] = map[x - 1][query.b.y];
			min = Math.min(min, map[x][query.b.y]);
		}

		// 자변 위쪽으로 | a.x 그대로 | b.y -> a.y
		for (int y = query.b.y; y > query.a.y; y--) {
			map[query.a.x][y] = map[query.a.x][y - 1];
			min = Math.min(min, map[query.a.x][y]);
		}
		map[query.a.x][query.a.y + 1] = startPoint;
		return min;
	}

	private int[][] initMap(int rows, int columns) {
		// 풀이의 편의성을 위해 0,0 이 아닌 1,1 부터 값을 넣기 위해 각 0 rows, 0 column 비운 좌표 생성
		int[][] init = new int[rows + 1][columns + 1];
		int startNum = 1;
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= columns; j++) {
				init[i][j] = startNum++;
			}
		}
		return init;
	}
}

class Query {

	Point a;
	Point b;

	public Query(Point a, Point b) {
		this.a = a;
		this.b = b;
	}

	public static Query of(int[] query) {
		Point a = new Point(query[0], query[1]);
		Point b = new Point(query[2], query[3]);
		return new Query(a, b);
	}

	static class Point {

		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}