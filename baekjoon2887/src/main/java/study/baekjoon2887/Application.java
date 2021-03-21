package study.baekjoon2887;

import static java.lang.Math.abs;
import static java.lang.Math.min;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Application {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int n;

	static Point[] points;
	static int[] parent;
	static PriorityQueue<Node> queue = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		points = new Point[n];
		parent = new int[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			points[i] = new Point(i, x, y, z);
			parent[i] = i;
		}

		/*for (int i = 1; i <= n; i++) {
			Point cur = points[i];
			for (int j = i + 1; j <= n; j++) {
				Point next = points[j];
				queue.add(new Node(i, j, cur.distance(next)));
			}
		}*/
		Arrays.sort(points, (a, b) -> a.x - b.x);
		for (int i = 0; i < n - 1; i++) {
			int weight = abs(points[i].x - points[i + 1].x);
			queue.add(new Node(points[i].index, points[i + 1].index, weight));
		}

		Arrays.sort(points, (a, b) -> a.y - b.y);
		for (int i = 0; i < n - 1; i++) {
			int weight = abs(points[i].y - points[i + 1].y);
			queue.add(new Node(points[i].index, points[i + 1].index, weight));
		}

		Arrays.sort(points, (a, b) -> a.z - b.z);
		for (int i = 0; i < n - 1; i++) {
			int weight = abs(points[i].z - points[i + 1].z);
			queue.add(new Node(points[i].index, points[i + 1].index, weight));
		}
		int answer = solve();
		bw.write(String.format("%d", answer));
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

	public static int solve() {
		int result = 0;
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

	int index;
	int x;
	int y;
	int z;

	public Point(int index, int x, int y, int z) {
		this.index = index;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public int distance(Point other) {
		int absX = abs(this.x - other.x);
		int absY = abs(this.y - other.y);
		int absZ = abs(this.z - other.z);
		return min(min(absX, absY), absZ);
	}
}

class Node implements Comparable<Node> {

	int start;
	int end;
	int weight;

	public Node(int start, int end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}


	@Override
	public int compareTo(Node o) {
		return this.weight <= o.weight ? -1 : 1;
	}
}