package study.problem;

public class Solution {

	public int solution(int[] arr) {
		int answer = arr[0];
		for (int i = 1; i < arr.length; i++) {
			answer = lcm(answer, arr[i]);
		}
		return answer;
	}

	private int gcd(int a, int b) {
		if (a < b) {
			int temp = a;
			a = b;
			b = temp;
		}
		if (b == 0) {
			return a;
		} else {
			return gcd(b, a % b);
		}
	}

	private int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}
}