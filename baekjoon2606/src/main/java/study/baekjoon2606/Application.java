package study.baekjoon2606;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Application {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static int m;
    static boolean[][] nodes;
    static boolean[] visit;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        visit = new boolean[n + 1];
        nodes = new boolean[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            nodes[s][e] = true;
            nodes[e][s] = true;
        }
        solve(1);
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void solve(int point) {
        for (int i = 2; i <= n; i++) {
            if (!visit[i] && nodes[point][i]) {
                visit[i] = true;
                answer++;
                solve(i);
            }
        }
    }
}