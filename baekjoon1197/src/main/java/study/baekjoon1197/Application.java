package study.baekjoon1197;

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

	static int v, e;
	static PriorityQueue<Node> queue = new PriorityQueue<>();
	static int[] parents;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());

		parents = new int[v + 1];
		for (int i = 0; i <= v; i++) {
			parents[i] = i;
		}

		for (int i = 1; i <= e; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			queue.add(new Node(start, end, weight));
		}

		int answer = solve();
		bw.write(String.valueOf(answer));
		bw.close();
		br.close();
	}

	public static int findParent(int node) {
		if (parents[node] == node) {
			return node;
		}
		parents[node] = findParent(parents[node]); //최상위 노드로
		return parents[node];
	}

	public static void union(int a, int b) {
		int aParent = findParent(a);
		int bParent = findParent(b);
		if (aParent != bParent) {
			parents[aParent] = b;
		} else {
			//do nothing
			return;
		}
	}

	public static int solve() {
		int result = 0;
		while (!queue.isEmpty()) {
			Node poll = queue.poll();
			int start = poll.start;
			int end = poll.end;
			int startParent = findParent(start);
			int endParent = findParent(end);

			if (startParent == endParent) {
				continue;
			}

			union(start, end);

			result += poll.weight;
		}
		return result;
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