package study.baekjoon1260;

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

    static int n, m, v;
    static boolean[][] nodes;
    static boolean[] visit;
    static StringBuffer dfsResult = new StringBuffer();
    static StringBuffer bfsResult = new StringBuffer();

    static final String EMPTY_SPACE = " ";

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        nodes = new boolean[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int startPoint = Integer.parseInt(st.nextToken());
            int endPoint = Integer.parseInt(st.nextToken());

            nodes[startPoint][endPoint] = true;
        }
        dfsResult.append(v).append(EMPTY_SPACE);
        visit = new boolean[n + 1];
        visit[v] = true;
        dfs(v);
        bw.write(dfsResult.toString());
        bw.write("\n");
        bfsResult.append(v).append(EMPTY_SPACE);
        visit = new boolean[n + 1];
        visit[v] = true;
        bfs(v, new LinkedList<>());
        bw.write(bfsResult.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int point) {

        for (int j = 1; j <= n; j++) {
            if (point != j && !visit[j] && nodes[point][j]) {
                dfsResult.append(j).append(EMPTY_SPACE);
                visit[j] = true;
                dfs(j);
            } else if (point != j && !visit[j] && nodes[j][point]) {
                dfsResult.append(j).append(EMPTY_SPACE);
                visit[j] = true;
                dfs(j);
            }
        }
    }

    public static void bfs(int point, Queue<Integer> queue) {
        for (int i = 1; i <= n; i++) {
            if (!visit[i] && nodes[point][i]) {
                queue.add(i);
                visit[i] = true;
            } else if (!visit[i] && nodes[i][point]) {
                queue.add(i);
                visit[i] = true;
            }
        }
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            bfsResult.append(poll).append(EMPTY_SPACE);
            bfs(poll, queue);
        }
    }

}