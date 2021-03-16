package study.baekjoon1504;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Application {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int n, e;
	static List<Node> nodes[];
	static int[] nodeWeights;
	static boolean[] visit;

	static final int MAX_VALUE = 200000000;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());

		nodes = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			nodes[i] = new ArrayList<>();
		}

		nodeWeights = new int[n + 1];
		visit = new boolean[n + 1];

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			nodes[start].add(new Node(end, weight));
			nodes[end].add(new Node(start, weight));
		}

		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());

		int answer = solve(v1, v2);
		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
		br.close();
	}

	private static int solve(int v1, int v2) {
		int v1Weight = 0;
		int v2Weight = 0;

		v1Weight += calcNodeWeight(1, v1);
		v1Weight += calcNodeWeight(v1, v2);
		v1Weight += calcNodeWeight(v2, n);

		v2Weight += calcNodeWeight(1, v2);
		v2Weight += calcNodeWeight(v2, v1);
		v2Weight += calcNodeWeight(v1, n);

		if (v1Weight >= MAX_VALUE && v2Weight >= MAX_VALUE) {
			return -1;
		} else {
			return Math.min(v1Weight, v2Weight);
		}
	}

	private static int calcNodeWeight(int start, int end) {
		Arrays.fill(nodeWeights, MAX_VALUE);
		Arrays.fill(visit, false);

		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.add(new Node(start, 0));
		nodeWeights[start] = 0;

		while (!queue.isEmpty()) {
			Node poll = queue.poll();
			int endNode = poll.endNode;
			int weight = poll.weight;

			if (visit[endNode]) {
				continue;
			}
			visit[endNode] = true;

			for (int i = 0; i < nodes[endNode].size(); i++) {
				int nextNode = nodes[endNode].get(i).endNode;
				int nextWeight = nodes[endNode].get(i).weight;
				// 미방문 && 기존의 계산된 거리보다 새로운 거리가 작을 경우
				if (!visit[nextNode] || nodeWeights[nextNode] > weight + nextWeight) {
					nodeWeights[nextNode] = weight + nextWeight;
					queue.add(new Node(nextNode, nodeWeights[nextNode]));
				}
			}
		}
		return nodeWeights[end];
	}
}

class Node implements Comparable<Node> {

	int endNode;
	int weight;

	public Node(int endNode, int weight) {
		this.endNode = endNode;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node o) {
		return this.weight - o.weight;
	}
}