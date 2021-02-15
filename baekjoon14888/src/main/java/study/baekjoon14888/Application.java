package study.baekjoon14888;

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
    static int[] num;
    static int[] ops = new int[4];
    static int[] used = new int[4];
    static long max = -1000000000;
    static long min = 1000000000;
    static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        num = new int[n];
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        s = br.readLine();
        st = new StringTokenizer(s);
        for (int i = 0; i < 4; i++) {
            ops[i] = Integer.parseInt(st.nextToken());
        }
        solve(num[0], 1);
        StringBuffer sb = new StringBuffer();
        sb.append(max).append(NEW_LINE);
        sb.append(min).append(NEW_LINE);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }


    public static void solve(int sum, int depth) {
        if (depth == n) {
            if (max <= sum) {
                max = sum;
            }
            if (min >= sum) {
                min = sum;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (ops[i] > 0) {
                ops[i]--;
                switch (i) {
                    case 0:
                        solve(sum + num[depth], depth + 1);
                        break;
                    case 1:
                        solve(sum - num[depth], depth + 1);
                        break;
                    case 2:
                        solve(sum * num[depth], depth + 1);
                        break;
                    case 3:
                        solve(sum / num[depth], depth + 1);
                        break;
                }

                ops[i]++;
            }
        }
    }
}