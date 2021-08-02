package study.problem;

public class Solution {

	public String solution(int n, int t, int m, int p) {
		String correctStr = init(n, t, m);
		StringBuilder answer = new StringBuilder();
		int turn = 0;
		while (turn < t) {
			int index = (turn * m) + p - 1;
			answer.append(correctStr.charAt(index));
			turn++;
		}
		return answer.toString();
	}

	private String init(int n, int t, int m) {
		StringBuilder sb = new StringBuilder("0");
		int maxValue = t * m;
		for (int i = 1; i < maxValue; i++) {
			sb.append(numToNotationStr(i, n));
		}
		return sb.toString();
	}

	private String numToNotationStr(int number, int notation) {
		StringBuilder sb = new StringBuilder();
		while (number > 0) {
			if (number % notation < 10) {
				sb.append(number % notation);
			} else {
				sb.append((char) (number % notation - 10 + 'A'));
			}
			number /= notation;
		}
		return sb.reverse().toString();
	}
}