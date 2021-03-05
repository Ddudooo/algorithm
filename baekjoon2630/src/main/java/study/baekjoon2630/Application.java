package study.baekjoon2630;

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
    static boolean[][] map;
    static int blue = 0;
    static int white = 0;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        map = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = st.nextToken().equals("1");
            }
        }

        solve(n, 0, 0);
        StringBuffer sb = new StringBuffer();
        sb.append(white).append("\n").append(blue);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void solve(int length, int x, int y) {
        for (int i = x; i < x + length; i++) {
            for (int j = y; j < y + length; j++) {
                if (map[i][j] != map[x][y]) {
                    int nextLength = length / 2;
                    solve(nextLength, x, y);
                    solve(nextLength, x + nextLength, y);
                    solve(nextLength, x, y + nextLength);
                    solve(nextLength, x + nextLength, y + nextLength);

                    return;
                }
            }
        }
        if (map[x][y]) {
            blue++;
        } else {
            white++;
        }
    }
}