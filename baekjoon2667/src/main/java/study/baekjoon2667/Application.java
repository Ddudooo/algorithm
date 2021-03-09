package study.baekjoon2667;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Application {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static boolean[][] map;
    static boolean[][] visit;
    static int sizeValue = 0;
    static List<Integer> size = new ArrayList<>();

    static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        map = new boolean[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = input.charAt(j) == '1';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j] && map[i][j]) {
                    check(i, j);
                    size.add(sizeValue);
                    sizeValue = 0;
                }
            }
        }
        size.sort(Integer::compareTo);
        StringBuffer sb = new StringBuffer();
        sb.append(size.size()).append(NEW_LINE);
        for (int val : size) {
            sb.append(val).append(NEW_LINE);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void check(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        if (!visit[x][y]) {
            visit[x][y] = true;
            sizeValue++;
        }

        //left
        if (x > 0) {
            if (!visit[x - 1][y] && map[x - 1][y]) {
                queue.add(new Point(x - 1, y));
                visit[x - 1][y] = true;
                sizeValue++;
            }
        }
        //right
        if (x < n - 1) {
            if (!visit[x + 1][y] && map[x + 1][y]) {
                queue.add(new Point(x + 1, y));
                visit[x + 1][y] = true;
                sizeValue++;
            }
        }
        //under
        if (y < n - 1) {
            if (!visit[x][y + 1] && map[x][y + 1]) {
                queue.add(new Point(x, y + 1));
                visit[x][y + 1] = true;
                sizeValue++;
            }
        }

        //upder
        if (y > 0) {
            if (!visit[x][y - 1] && map[x][y - 1]) {
                queue.add(new Point(x, y - 1));
                visit[x][y - 1] = true;
                sizeValue++;
            }
        }

        while (!queue.isEmpty()) {
            Point poll = queue.poll();
            check(poll.x, poll.y);
        }

    }
}

class Point {

    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}