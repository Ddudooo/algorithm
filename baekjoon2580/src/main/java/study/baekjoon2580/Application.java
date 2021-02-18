package study.baekjoon2580;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Application {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[][] map = new int[9][9];

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 9; i++) {
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            int index = 0;
            while (st.hasMoreTokens()) {
                int val = Integer.parseInt(st.nextToken());
                map[i][index++] = val;
            }
        }
        solve(0, 0);


    }

    private static void solve(int x, int y) throws IOException {
        if (y == 9) {
            solve(x + 1, 0);
            return;
        }
        if (x == 9) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(map[i][j]).append(" ");
                }
                sb.append("\n");
            }
            bw.write(sb.toString());
            bw.flush();
            bw.close();
            br.close();
            System.exit(0);
        }

        if (map[x][y] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (check(x, y, i)) {
                    map[x][y] = i;
                    solve(x, y + 1);
                }
            }
            map[x][y] = 0;
            return;
        }
        solve(x, y + 1);
    }

    private static boolean check(int x, int y, int value) {
        for (int i = 0; i < 9; i++) {
            if (map[x][i] == value) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (map[i][y] == value) {
                return false;
            }
        }

        int sx = (x / 3) * 3;
        int sy = (y / 3) * 3;

        for (int i = sx; i < sx + 3; i++) {
            for (int j = sy; j < sy + 3; j++) {
                if (map[i][j] == value) {
                    return false;
                }
            }
        }

        return true;
    }
}