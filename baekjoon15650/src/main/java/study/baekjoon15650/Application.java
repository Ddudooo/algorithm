package study.baekjoon15650;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Application {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static int m;
    static int[] arr;
    static final String NEW_LINE = "\n";
    static final String EMPTY_SPACE = " ";

    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        dfs(1, 0);
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int start, int depth) throws IOException {
        if (depth == m) {
            StringBuffer sb = new StringBuffer();
            Arrays.stream(arr)
                .forEach(e -> {
                    sb.append(e).append(EMPTY_SPACE);
                });
            sb.append(NEW_LINE);
            bw.write(sb.toString());
            return;
        }

        for (int i = start; i <= n; i++) {
            arr[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }

}