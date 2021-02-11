package study.baekjoon1427;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String numberOfStr = br.readLine();
        solve(numberOfStr);
        bw.flush();
        bw.close();
        br.close();
    }

    public static void solve(String numberStr) throws IOException {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < numberStr.length(); i++) {
            numbers.add((int) numberStr.charAt(i));
        }

        numbers.sort(Collections.reverseOrder());
        for (Integer n : numbers) {
            bw.write(n);
        }
    }
}