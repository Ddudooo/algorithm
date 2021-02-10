package study.baekjoon2108;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;

public class Application {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[] numbers = new int[4001];
    static int[] minNumbers = new int[4001];
    static int frequency = 4001;
    static int secondFrequency = 4001;
    static int maxCnt = 0;
    static List<Integer> sorted = new LinkedList<>();
    static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(bf.readLine());
            if (num < 0) {
                minNumbers[num * -1]++;
            } else {
                numbers[num]++;
            }
        }
        StringBuffer sb = new StringBuffer();
        sb.append(avg()).append(NEW_LINE);
        sb.append(mid()).append(NEW_LINE);
        sb.append(getMany()).append(NEW_LINE);
        sb.append(minusMinMax()).append(NEW_LINE);
        bw.write(sb.toString());
        bw.flush();
        bw.close();

        bf.close();
    }

    static long avg() {

        for (int i = 4000; i > 0; i--) {

            int minusNum = -1 * i;
            if (maxCnt < minNumbers[i]) {
                //System.out.println(minusNum + " cnt " + minNumbers[i]);
                frequency = minusNum;
                secondFrequency = 4001;
                maxCnt = minNumbers[i];
            } else if (maxCnt > 0 && maxCnt == minNumbers[i]) {
                //System.out.println(minusNum + " cnt " + minNumbers[i]);
                if (frequency > minusNum) {
                    secondFrequency = frequency;
                    frequency = minusNum;
                } else {
                    secondFrequency = Math.min(minusNum, secondFrequency);
                }
            }

            while (minNumbers[i] > 0) {
                sorted.add(minusNum);
                minNumbers[i]--;
            }
        }
        for (int i = 0; i <= 4000; i++) {

            if (maxCnt < numbers[i]) {
                //System.out.println(i + " cnt " + numbers[i]);
                frequency = i;
                secondFrequency = 4001;
                maxCnt = numbers[i];
            } else if (maxCnt > 0 && maxCnt == numbers[i]) {
                //System.out.println(i + " cnt " + numbers[i]);
                if (frequency > i) {
                    secondFrequency = frequency;
                    frequency = i;
                } else {
                    //System.out.println("=== " + i + " cnt " + numbers[i]);
                    secondFrequency = Math.min(i, secondFrequency);
                }
            }
            while (numbers[i] > 0) {
                sorted.add(i);
                numbers[i]--;
            }
        }
        return Math.round(sorted.stream().mapToDouble(Long::valueOf).sum() / n);
    }

    static long mid() {
        int mid = n / 2;

        return sorted.get(mid);
    }

    static int getMany() {
        return secondFrequency == 4001 ? frequency : secondFrequency;
    }

    static int minusMinMax() {
        return sorted.get(n - 1) - sorted.get(0);
    }
}