package study.baekjoon1780;

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
    static int[] value = new int[3];

    static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve(n, 0, 0);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 3; i++) {
            sb.append(value[i]).append(NEW_LINE);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void solve(int len, int x, int y) {
        for (int i = x; i < x + len; i++) {
            for (int j = y; j < y + len; j++) {
                if (map[i][j] != map[x][y]) {
                    int nextLen = len / 3;
                    solve(nextLen, x, y);
                    solve(nextLen, x + nextLen, y);
                    solve(nextLen, x + (nextLen * 2), y);

                    solve(nextLen, x, y + nextLen);
                    solve(nextLen, x, y + (nextLen * 2));
                    solve(nextLen, x + nextLen, y + nextLen);

                    solve(nextLen, x + nextLen, y + (nextLen * 2));
                    solve(nextLen, x + (nextLen * 2), y + nextLen);
                    solve(nextLen, x + (nextLen * 2), y + (nextLen * 2));
                    return;
                }
            }
        }

        switch (map[x][y]) {
            case -1:
                value[0]++;
                break;
            case 0:
                value[1]++;
                break;
            case 1:
                value[2]++;
                break;
        }
    }
}