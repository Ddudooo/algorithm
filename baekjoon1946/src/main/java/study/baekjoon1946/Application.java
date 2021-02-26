package study.baekjoon1946;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Application {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int testCase;
    static int n;

    public static void main(String[] args) throws IOException {
        testCase = Integer.parseInt(br.readLine());
        for (int test = 0; test < testCase; test++) {
            n = Integer.parseInt(br.readLine());
            int answer = 1;
            int[] person = new int[n + 1];
            for (int k = 0; k < n; k++) {
                String input = br.readLine();
                StringTokenizer st = new StringTokenizer(input);
                int i = Integer.parseInt(st.nextToken());
                person[i] = Integer.parseInt(st.nextToken());
            }
            int cutLine = person[1];
            for (int i = 2; i <= n; i++) {
                if (cutLine > person[i]) {
                    cutLine = person[i];
                    answer++;
                }
            }
            bw.write(String.valueOf(answer));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}