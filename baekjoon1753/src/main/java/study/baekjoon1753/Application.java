package study.baekjoon1753;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Application {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int v, e;
	static int start;
	static LinkedList<Node>[] nodes;
	static int[] nodeWeights;
	static boolean[] visit;

	static final String NEW_LINE = "\n";
	static final String INFINITE = "INF";

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		nodes = new LinkedList[v + 1];
		for (int i = 1; i <= v; i++) {
			nodes[i] = new LinkedList<>();
		}
		nodeWeights = new int[v + 1];
		visit = new boolean[v + 1];
		Arrays.fill(nodeWeights, -1);
		start = Integer.parseInt(br.readLine());
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			nodes[start].add(new Node(end, weight));
		}
		solve(start);
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i <= v; i++) {
			sb.append(nodeWeights[i] == -1 ? INFINITE : nodeWeights[i]).append(NEW_LINE);
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static void solve(int start) {
		//주어진 시작점에서 가중치 큐에 넣어가면서 방문하지 않은 가장 가까운 경로
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.offer(new Node(start, 0));
		nodeWeights[start] = 0; //주어진 노드에서 시작함으로 해당 노드의 가중치는 0

		while (!queue.isEmpty()) { //조회할 노드가 없을때 까지
			Node startNode = queue.poll(); //다음 노드 가져옴 (가중치 기준 가장 가중치 낮은 노드)

			if (!visit[startNode.v]) { //방문하지 않았을때
				visit[startNode.v] = true; //방문으로 수정
				for (Node next : nodes[startNode.v]) { //연결된 노드 순회
					if (nodeWeights[next.v] == -1 //가중치 추가 안 되있음
						|| nodeWeights[next.v]
						> nodeWeights[startNode.v] + next.weight) { // 연결된 노드 가중치가 현 가중치보다 높을때
						nodeWeights[next.v] =
							nodeWeights[startNode.v] + next.weight; //현재 가중치에 다음 도착할 지점 가중치 합산
						queue.offer(new Node(next.v, nodeWeights[next.v])); //다음 조회할 큐로 추가
					}
				}
			}
		}
	}
}

class Node implements Comparable<Node> {

	int v;
	int weight;

	public Node(int v, int weight) {
		this.v = v;
		this.weight = weight;
	}

	@Override//오름차순 1 2 3 4
	public int compareTo(Node o) {
		return weight - o.weight;
	}
}