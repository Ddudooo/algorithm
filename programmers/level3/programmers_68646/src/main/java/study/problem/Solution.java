package study.problem;

public class Solution {

	public int solution(int[] a) {
		if (a.length <= 2) {
			return a.length;
		}
		int answer = a.length;
		int[] left = leftSide(a);
		int[] right = rightSide(a);
		for (int i = 0; i < a.length; i++) {
			if (left[i] < a[i] && right[i] < a[i]) {
				answer--;
			}
		}
		return answer;
	}

	private int[] leftSide(int[] input) {
		int[] result = new int[input.length];
		result[0] = input[0];
		int pre = input[0];
		for (int i = 1; i < input.length; i++) {
			if (input[i] < pre) {
				pre = input[i];
			}
			result[i] = pre;
		}
		return result;
	}

	private int[] rightSide(int[] input) {
		int[] result = new int[input.length];
		result[input.length - 1] = input[input.length - 1];
		int pre = input[input.length - 1];
		for (int i = input.length - 2; i >= 0; i--) {
			if (input[i] < pre) {
				pre = input[i];
			}
			result[i] = pre;
		}
		return result;
	}
}