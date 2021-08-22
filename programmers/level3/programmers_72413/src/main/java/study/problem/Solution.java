package study.problem;

import java.util.Arrays;

public class Solution {

	public int solution(int n, int s, int a, int b, int[][] fares) {
		int answer = Integer.MAX_VALUE;
		int[][] nodes = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			Arrays.fill(nodes[i], Integer.MAX_VALUE);
			nodes[i][i] = 0;
		}
		for (int[] fare : fares) {
			nodes[fare[0]][fare[1]] = fare[2];
			nodes[fare[1]][fare[0]] = fare[2];
		}
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					int direct = nodes[i][j];
					if (nodes[i][k] == Integer.MAX_VALUE || nodes[k][j] == Integer.MAX_VALUE) {
						// 돌아갈 수 없음.
						continue;
					}
					int byPass = nodes[i][k] + nodes[k][j];
					if (byPass < direct) {
						nodes[i][j] = byPass;
						nodes[j][i] = byPass;
					}
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			answer = Math.min(answer, nodes[s][i] + nodes[i][a] + nodes[i][b]);
		}
		return answer;
	}
}