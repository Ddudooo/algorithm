package study.baekjoon1517;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Application {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long cnt = 0;
    static long[] answer;

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        answer = new long[n];
        long[] arr = new long[n];
        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        mergeSort(arr, 0, n - 1);

        bw.write(String.valueOf(cnt));
        bw.close();
        bf.close();
    }

    static void mergeSort(long[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    static void merge(long[] arr, int low, int mid, int high) {
        int lowIndex = low;
        int middleIndex = mid + 1;
        int index = low;

        while (lowIndex <= mid && middleIndex <= high) {
            if (arr[lowIndex] <= arr[middleIndex]) {
                answer[index++] = arr[lowIndex++];
            } else {
                answer[index++] = arr[middleIndex++];
                cnt += (mid + 1 - lowIndex);
            }
        }

        while (lowIndex <= mid) {
            answer[index++] = arr[lowIndex++];
        }

        while (middleIndex <= high) {
            answer[index++] = arr[middleIndex++];
        }

        for (int i = low; i <= high; i++) {
            arr[i] = answer[i];
        }
    }
}