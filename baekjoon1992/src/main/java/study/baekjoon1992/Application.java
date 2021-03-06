package study.baekjoon1992;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Application {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static boolean[][] map;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        map = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String st = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = st.charAt(j) == '1';
            }
        }
        bw.write(solve(n, 0, 0));
        bw.flush();
        br.close();
    }

    public static String solve(int length, int x, int y) {
        StringBuilder sb = new StringBuilder();
        String result = "";
        for (int i = x; i < x + length; i++) {
            for (int j = y; j < y + length; j++) {
                if (map[i][j] != map[x][y]) {
                    int nextLength = length / 2;
                    result += solve(nextLength, x, y);
                    result += solve(nextLength, x, y + nextLength);
                    result += solve(nextLength, x + nextLength, y);
                    result += solve(nextLength, x + nextLength, y + nextLength);
                    return "(" + result + ")";
                }
            }
        }
        return result.equals("") ? (map[x][y] ? "1" : "0") : result;
    }
}