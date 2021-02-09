package study.baekjoon10989;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
 */
public class Application {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int MAX_VALUE = 10000;
    static final String NEW_LINE_CHAR = "\n";

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(bf.readLine());
        int[] count = new int[10001];
        for (int i = 0; i < n; i++) {
            count[Integer.parseInt(bf.readLine())]++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= MAX_VALUE; i++) {
            while (count[i] > 0) {
                sb.append(i).append(NEW_LINE_CHAR);
                count[i]--;
            }
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        bf.close();
    }
}