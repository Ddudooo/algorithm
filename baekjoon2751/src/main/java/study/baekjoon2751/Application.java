package study.baekjoon2751;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;

/**
 * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
 */
public class Application {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static List<Long> data;
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(bf.readLine());
        data = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            data.add(Long.parseLong(bf.readLine()));
        }
        data.sort(Long::compareTo);
        StringJoiner sj = new StringJoiner("\n");
        data.stream().map(String::valueOf).forEach(sj::add);
        bw.write(sj.toString());
        bw.flush();
        bw.close();
        bf.close();
    }
}