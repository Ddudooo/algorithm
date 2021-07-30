package study.problem;

import java.util.Arrays;

public class Solution {

	private final int MAX_COST = 500000;

	public int solution(int N, int[][] road, int K) {
		int[][] map = initMap(N);
		setRoad(map, road);
		floydWarshall(map, N);
		return (int) Arrays.stream(map[0])
			.filter(v -> v <= K)
			.count();
	}

	private int[][] initMap(int N) {
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j) {
					map[i][j] = 0;
				} else {
					map[i][j] = MAX_COST;
				}
			}
		}
		return map;
	}

	private void setRoad(int[][] map, int[][] road) {
		for (int[] rows : road) {
			int start = rows[0] - 1;
			int end = rows[1] - 1;
			int cost = rows[2];
			int preCost = map[start][end];
			int minCost = Math.min(cost, preCost);
			map[start][end] = minCost;
			map[end][start] = minCost;
		}
	}

	private void floydWarshall(int[][] map, int N) {
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i == k || j == k || i == j) {
						continue;
					}
					// i 번 마을에서 j마을로 가는데
					int directPass = map[i][j];
					// k 번 마을을 거치고 오는 값이 더 작을때
					int byPass = calculateByPassCost(map[i][k], map[k][j]);
					// 이때 각 값을 비교할때 단절된 통로는 제외한다.
					if (directPass == MAX_COST && byPass == MAX_COST) {
						// 둘 다 마을을 연결할 수 없을 때는 계산하지 않는다
						continue;
					}
					int min = Math.min(directPass, byPass);
					map[i][j] = min;
					map[j][i] = min;
				}
			}
		}
	}

	private void print(int[][] map) {
		for (int[] rows : map) {
			for (int v : rows) {
				if (v != MAX_COST) {
					System.out.printf("%3d ", v);
					continue;
				}
				System.out.print("INF ");
			}
			System.out.println();
		}
	}

	private int calculateByPassCost(int ItoK, int KtoJ) {
		if (ItoK == MAX_COST || KtoJ == MAX_COST) {
			// 둘중 하나라도 연결될 수 없을 때
			return MAX_COST;
		}
		return ItoK + KtoJ;
	}
}