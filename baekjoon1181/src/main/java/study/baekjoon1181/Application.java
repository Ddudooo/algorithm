package study.baekjoon1181;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 알파벳 소문자로 이루어진 N개의 단어가 들어오면
 * <p>
 * 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.
 * <p>
 * 1. 길이가 짧은 것부터
 * <p>
 * 2. 길이가 같으면 사전 순으로
 */
public class Application {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static Set<Word> words = new HashSet<>();
    static int n;
    static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            words.add(new Word(input));
        }
        StringBuffer sb = new StringBuffer();
        words.stream().sorted().forEach(word ->
            sb.append(word.str).append(NEW_LINE)
        );
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

class Word implements Comparable<Word> {

    String str;

    public Word(String str) {
        this.str = str;
    }

    public int length() {
        return str.length();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Word word = (Word) o;
        return Objects.equals(str, word.str);
    }

    @Override
    public int hashCode() {
        return Objects.hash(str);
    }

    @Override
    public int compareTo(Word o) {
        if (this.length() < o.length()) {
            return -1;
        } else if (this.length() > o.length()) {
            return 1;
        } else {
            return this.str.compareTo(o.str);
        }
    }
}