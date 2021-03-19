package study.baekjoon4386;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Application {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int n;
	static List<Node> nodes[];
	static int[] parent;


	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		nodes = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			nodes[i] = new ArrayList<>();
		}
		parent = new int[n + 1];

		Point[] points = new Point[n + 1];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			points[i + 1] = new Point(x, y);
		}

		PriorityQueue<Node> nodeQueue = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			Point cur = points[i + 1];
			for (int j = 0; j < n; j++) {
				if (i == j) {
					continue;
				} else {
					Point next = points[j + 1];
					double weight = cur.distance(next);
					nodeQueue.add(new Node(i + 1, j + 1, weight));
				}
			}
			parent[i + 1] = i + 1;
		}

		double answer = 0;
		while (!nodeQueue.isEmpty()) {
			Node poll = nodeQueue.poll();
			int start = poll.start;
			int end = poll.end;
			int startParent = find(start);
			int endParent = find(end);
			if (find(start) != find(end)) {
				answer += poll.weight;
				union(start, end);
			}
		}

		bw.write(String.format("%.2f", answer));
		bw.flush();
		bw.close();
		br.close();
	}

	private static int find(int node) {
		if (parent[node] == node) {
			return node;
		}
		return parent[node] = find(parent[node]);
	}

	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x != y) {
			parent[y] = x;
		}
	}
}

class Point {

	double x;
	double y;

	public Point(double x, double y) {
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

	public Node(int start, int end) {
		new Node(start, end, 0);
	}

	public Node(int start, int end, double weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public int compareTo(Node o) {
		return this.weight <= o.weight ? -1 : 1;
	}
}