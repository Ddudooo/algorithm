package study.baekjoon13305;

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
    static long[] loads;
    static long[] cost;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        loads = new long[n - 1];
        cost = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            loads[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cost[i] = Long.parseLong(st.nextToken());
        }

        long total = solve();
        bw.write(String.valueOf(total));
        bw.flush();
        bw.close();
        br.close();
    }

    public static long solve() {
        long before = cost[0];
        for (int i = 1; i < n; i++) {
            if (before <= cost[i]) {
                cost[i] = before;
            } else {
                before = cost[i];
            }
        }

        long answer = 0;
        for (int i = 0; i < n - 1; i++) {
            answer += cost[i] * loads[i];
        }
        return answer;
    }
}