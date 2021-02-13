package study.baekjoon10814;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

/**
 * 온라인 저지에 가입한 사람들의 나이와 이름이 가입한 순서대로 주어진다.
 * <p>
 * 이때, 회원들을 나이가 증가하는 순으로,
 * <p>
 * 나이가 같으면 먼저 가입한 사람이 앞에 오는 순서로
 * <p>
 * 정렬하는 프로그램을 작성하시오.
 */
public class Application {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static List<Person> personList = new ArrayList<>();
    static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String inputStr = br.readLine();
            StringTokenizer st = new StringTokenizer(inputStr);
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            personList.add(new Person(age, name, i));
        }
        StringBuffer sb = new StringBuffer();
        personList.stream().sorted().forEach(person ->
            sb.append(person).append(NEW_LINE)
        );
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

class Person implements Comparable<Person> {

    int age;
    String name;
    int joinOrd;

    public Person(int age, String name, int joinOrd) {
        this.age = age;
        this.name = name;
        this.joinOrd = joinOrd;
    }

    @Override
    public String toString() {
        return age + " " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return age == person.age && name == person.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }

    @Override
    public int compareTo(Person o) {
        if (this.age == o.age) {
            return Integer.compare(this.joinOrd, o.joinOrd);
        }
        return Integer.compare(this.age, o.age);
    }
}