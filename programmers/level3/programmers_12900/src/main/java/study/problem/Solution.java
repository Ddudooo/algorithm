package study.problem;

public class Solution {

	public int solution(int n) {
		int[] ary = new int[n];
		ary[0] = 1;
		ary[1] = 2;
		for (int i = 2; i < n; i++) {
			int num = ary[i - 1] + ary[i - 2];
			ary[i] = num % 1000000007;
		}
		return ary[n - 1];
	}
}