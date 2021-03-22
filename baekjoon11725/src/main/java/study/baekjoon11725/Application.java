package study.baekjoon11725;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Application {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int n;

	static List<Integer>[] list;
	static boolean[] visit;
	static int[] parents;

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		list = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		visit = new boolean[n + 1];
		parents = new int[n + 1];

		for (int i = 2; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list[start].add(end);
			list[end].add(start);
		}
		solve(1);

		StringBuffer sb = new StringBuffer();
		for (int i = 2; i <= n; i++) {
			sb.append(parents[i]).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static void solve(int startPoint) {
		if (visit[startPoint]) {
			return;
		}
		visit[startPoint] = true;
		for (int next : list[startPoint]) {
			if (!visit[next]) {
				parents[next] = startPoint;
				solve(next);
			}
		}
	}
}