package study.baekjoon1774;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Application {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int n, m;
	static int[] parent;
	static Point[] points;
	static PriorityQueue<Node> queue = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		points = new Point[n + 1];
		parent = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			points[i] = new Point(x, y);
			parent[i] = i;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			queue.add(new Node(start, end, 0));
		}

		for (int i = 1; i <= n; i++) {
			Point startPoint = points[i];
			for (int j = i + 1; j <= n; j++) {
				Point endPoint = points[j];
				double dis = startPoint.distance(endPoint);
				queue.add(new Node(i, j, dis));
			}
		}
		double answer = solve();
		bw.write(String.format("%.2f", answer));
		bw.flush();
		bw.close();
		br.close();
	}

	public static int find(int point) {
		if (parent[point] == point) {
			return point;
		}
		return parent[point] = find(parent[point]);
	}

	public static void union(int a, int b) {
		int findA = find(a);
		int findB = find(b);

		if (findA != findB) {
			parent[findB] = findA;
		}
	}

	public static double solve() {
		double result = 0;
		while (!queue.isEmpty()) {
			Node poll = queue.poll();
			int start = poll.start;
			int end = poll.end;
			if (find(start) != find(end)) {
				result += poll.weight;
				union(start, end);
			}
		}
		return result;
	}
}

class Point {

	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public double distance(Point other) {
		return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
	}
}

class Node implements Comparable<Node> {

	int start;
	int end;
	double weight;

	public Node(int start, int end, double weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node o) {
		return this.weight <= o.weight ? -1 : 1;
	}
}