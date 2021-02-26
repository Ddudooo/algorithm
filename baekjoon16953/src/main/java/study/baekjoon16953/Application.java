package study.baekjoon16953;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Application {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static long a;
    static long b;
    static int answer = 1;

    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        int result = solve(b);
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }

    public static int solve(long num) {
        if (num == a) {
            return answer;
        } else if (num < a) {
            return -1;
        }
        if (num % 10 == 1) {
            answer++;
            System.out.println(num + " -> " + num / 10);
            return solve(num / 10);
        } else if (num % 2 == 0) {
            answer++;
            System.out.println(num + " -> " + num / 2);
            return solve(num / 2);
        }
        return -1;
    }
}