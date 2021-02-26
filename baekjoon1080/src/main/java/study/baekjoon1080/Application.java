package study.baekjoon1080;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Application {

    //호랭선생님과 함께하는 알고리즘 풀이 ㅎㅎ
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static int m;

    static boolean[][] mapA;
    static boolean[][] mapB;

    public static void main(String[] args) throws IOException {
        //이거 하면 할수록 메인문만 빨리쳐짐
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        mapA = new boolean[n][m];
        mapB = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                mapA[i][j] = input.charAt(j) == '1';
            }
        }

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                mapB[i][j] = input.charAt(j) == '1';
            }
        }

        if (isEquals()) {
            bw.write("0");
        } else if (n < 3 && m < 3) {
            bw.write("-1");
        } else {
            bw.write(String.valueOf(solve()));
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static int solve() {
        int answer = 0;
        for (int startX = 0; startX <= n - 3; startX++) {
            for (int startY = 0; startY <= m - 3; startY++) {
                if (mapA[startX][startY] != mapB[startX][startY]) {
                    //부분 행렬
                    for (int i = startX; i < startX + 3; i++) {
                        for (int j = startY; j < startY + 3; j++) {
                            mapA[i][j] = !mapA[i][j];
                        }
                    }
                    answer++;
                }
                //검사
                if (isEquals()) {
                    return answer;
                }
            }
        }
        return -1;
    }

    public static boolean isEquals() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mapA[i][j] != mapB[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}