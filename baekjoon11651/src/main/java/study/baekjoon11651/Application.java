package study.baekjoon11651;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 2차원 평면 위의 점 N개가 주어진다.
 * <p>
 * 좌표를 y좌표가 증가하는 순으로,
 * <p>
 * y좌표가 같으면 x좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.
 */
public class Application {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static final String NEW_LINE = "\n";
    static List<Point> points = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String inputStr = br.readLine();
            StringTokenizer st = new StringTokenizer(inputStr);
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points.add(new Point(x, y));
        }
        Collections.sort(points);
        StringBuffer sb = new StringBuffer();
        for (Point point : points) {
            sb.append(point).append(NEW_LINE);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}

class Point implements Comparable<Point> {

    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }

    @Override
    public int compareTo(Point o) {
        if (this.y < o.y) {
            return -1;
        } else if (this.y > o.y) {
            return 1;
        } else {
            if (this.x < o.x) {
                return -1;
            } else if (this.x > o.x) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}