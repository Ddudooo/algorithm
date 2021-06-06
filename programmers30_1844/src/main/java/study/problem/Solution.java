package study.problem;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	private final int[] dx = {0, 1, 0, -1};
	private final int[] dy = {1, 0, -1, 0};

	public int solution(int[][] maps) {
		int answer = bfs(0, 0, maps);
		return answer;
	}

	private int bfs(int x, int y, int[][] maps) {
		int n = maps.length;
		int m = maps[0].length;
		boolean[][] visited = new boolean[n][m];
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(x, y, 0));

		while (!queue.isEmpty()) {
			Node poll = queue.poll();
			if (poll.getX() == n - 1 && poll.getY() == m - 1) {
				return poll.getCost() + 1;
			}
			for (int i = 0; i < 4; i++) {
				int nextX = poll.getX() + dx[i];
				int nextY = poll.getY() + dy[i];
				if (nextX >= 0 && nextY >= 0 &&
					nextX < n && nextY < m
				) {
					if (maps[nextX][nextY] == 1 && !visited[nextX][nextY]) {
						visited[nextX][nextY] = true;
						queue.add(new Node(nextX, nextY, poll.getCost() + 1));
					}
				}
			}
		}
		return -1;
	}
}

class Node {

	private int x;
	private int y;
	private int cost = 0;

	public Node(int x, int y, int cost) {
		this.x = x;
		this.y = y;
		this.cost = cost;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getCost() {
		return cost;
	}
}