package study.problem;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	boolean[][] nodes;
	boolean[] visit;

	public int solution(int n, int[][] edge) {
		nodes = new boolean[n + 1][n + 1];
		visit = new boolean[n + 1];
		for (int[] value : edge) {
			int start = value[0];
			int end = value[1];
			nodes[start][end] = true;
			nodes[end][start] = true;
		}
		int answer = bfs(n);
		return answer;
	}

	public int bfs(int n) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		visit[1] = true;
		int answer = 0;
		while (!queue.isEmpty()) {
			int cnt = queue.size();
			for (int q = 0; q < cnt; q++) {
				Integer poll = queue.poll();
				for (int i = 1; i <= n; i++) {
					if (!visit[i] && nodes[poll][i]) {
						visit[i] = true;
						queue.add(i);
					}
				}
			}
			if (!queue.isEmpty()) {
				answer = queue.size();
			}
		}
		return answer;
	}
}