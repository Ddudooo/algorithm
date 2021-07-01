package study.problem;

import java.util.Arrays;

public class Solution {

	int INF;

	public int solution(int n, int[][] results) {
		INF = 9999;
		int[][] graph = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			Arrays.fill(graph[i], INF);
			graph[i][i] = 0;
		}

		for (int[] result : results) {
			int win = result[0];
			int lose = result[1];
			graph[win][lose] = 1;
		}

		printGraph(graph);

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (graph[i][j] > graph[i][k] + graph[k][j]) {
						System.out.printf("%d -> %d (%d)\n", i, j, graph[i][j]);
						graph[i][j] = graph[i][k] + graph[k][j];
						System.out
							.printf("%d -> %d (%d), %d -> %d (%d) \n",
								i, k, graph[i][k], k, j, graph[k][j]);
						System.out.printf("%d -> %d (%d)\n", i, j, graph[i][j]);
						printGraph(graph);
					}
				}
			}
		}
		printGraph(graph);
		int answer = 0;
		boolean[] flag = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j) {
					continue;
				}
				if (graph[i][j] == INF && graph[j][i] == INF) {
					flag[i] = true;
					break;
				}
			}
			if (!flag[i]) {
				answer++;
			}
		}
		return answer;
	}

	private void printGraph(int[][] graph) {
		System.out.println("==============================================================");
		for (int i = 0; i < graph.length; i++) {
			if (i == 0) {
				for (int j = 0; j < graph[i].length; j++) {
					if (j == 0) {
						System.out.print("     ");
						continue;
					}
					System.out.printf("%4d ", j);
				}
				System.out.println();
				continue;
			}
			for (int j = 0; j < graph[i].length; j++) {
				if (j == 0) {
					System.out.printf("%4d ", i);
					continue;
				}
				if (graph[i][j] == INF) {
					System.out.print(" INF ");
					continue;
				}
				System.out.printf("%4d ", graph[i][j]);
			}
			System.out.println();
		}
		System.out.println("==============================================================");
	}
}