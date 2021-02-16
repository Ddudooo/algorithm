package study.baekjoon14889;

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
    static int[][] map;
    static boolean[] visit;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        chose(0, 0);
        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void chose(int index, int depth) {
        if (depth == n / 2) {
            diff();
            return;
        }

        for (int i = index; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                chose(i + 1, depth + 1);
                visit[i] = false;
            }
        }
    }

    public static void diff() {
        int a = 0, b = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visit[i] && visit[j]) {
                    a += map[i][j];
                }
                if (!visit[i] && !visit[j]) {
                    b += map[i][j];
                }
            }
        }
        int result = Math.abs(a - b);
        if (result <= min) {
            min = result;
        }
    }
}