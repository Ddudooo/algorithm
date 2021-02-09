package study.baekjoon15649;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringJoiner;
import java.util.StringTokenizer;

/**
 * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 * <p>
 * 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열.
 */
public class Application {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int[] arr;
    public static boolean[] visit;

    public static int n;
    public static int m;
    public static final String NEW_LINE_CHAR = "\n";

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        visit = new boolean[n];
        dfs(0);
        bw.flush();
        bw.close();
        bf.close();
    }

    public static void dfs(int depth) throws IOException {
        if (depth == m) {
            StringJoiner sj = new StringJoiner(" ");
            Arrays.stream(arr).mapToObj(Integer::toString).forEach(sj::add);
            sj.add(NEW_LINE_CHAR);
            bw.write(sj.toString());
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i + 1;
                dfs(depth + 1);
                visit[i] = false;
            }
        }
    }
}