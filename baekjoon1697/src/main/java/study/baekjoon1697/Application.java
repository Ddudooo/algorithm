package study.baekjoon1697;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Application {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int n, m;
	static final int MAX = 100001;
	static int[] visit = new int[100001];

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int answer = solve(n);

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
		br.close();
	}

	public static int solve(int x) {
		Queue<Integer> queue = new LinkedList<>();
		int sec = 0;
		if (x == m) {
			return 0;
		} else {
			queue.add(x);
			visit[x] = sec++;
		}

		while (!queue.isEmpty()) {
			Integer next = queue.poll();
			if ((next - 1) >= 0 && visit[next - 1] == 0) {
				queue.add(next - 1);
				visit[next - 1] = visit[next] + 1;
				if ((next - 1) == m) {
					return visit[m];
				}
			}

			if ((next + 1) < MAX && visit[next + 1] == 0) {
				queue.add(next + 1);
				visit[next + 1] = visit[next] + 1;
				if ((next + 1) == m) {
					return visit[m];
				}
			}

			if ((next * 2) < MAX && visit[next * 2] == 0) {
				queue.add(next * 2);
				visit[next * 2] = visit[next] + 1;
				if ((next * 2) == m) {
					return visit[m];
				}
			}
		}
		return visit[m];
	}
}