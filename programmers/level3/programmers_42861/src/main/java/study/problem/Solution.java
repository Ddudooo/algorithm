package study.problem;

import java.util.Arrays;

public class Solution {

	public int solution(int n, int[][] costs) {
		int answer = 0;
		Arrays.sort(costs, (a, b) -> a[2] - b[2]);
		int[] nodes = new int[n];
		for (int i = 0; i < n; i++) {
			nodes[i] = i;
		}
		for (int[] value : costs) {
			int start = value[0];
			int end = value[1];

			int startRoot = findRoot(start, nodes);
			int endRoot = findRoot(end, nodes);

			if (startRoot == endRoot) {
				continue;
			}

			answer += value[2];
			nodes[endRoot] = startRoot;
		}
		return answer;
	}

	private int findRoot(int node, int[] nodes) {
		if (nodes[node] == node) {
			return node;
		}
		return nodes[node] = findRoot(nodes[node], nodes);
	}
}