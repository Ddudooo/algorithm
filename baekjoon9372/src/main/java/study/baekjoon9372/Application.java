package study.baekjoon9372;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Application {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static final String NEW_LINE = "\n";

	public static void main(String[] args) throws IOException {
		int testCase = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		for (int test = 0; test < testCase; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); //국가 수
			int m = Integer.parseInt(st.nextToken()); //비행기 종류
			for (int i = 0; i < m; i++) {
				br.readLine();
			}
			sb.append(String.valueOf(n - 1)).append(NEW_LINE);
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}