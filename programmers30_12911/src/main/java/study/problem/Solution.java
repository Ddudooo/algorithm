package study.problem;

import static java.lang.Integer.bitCount;

public class Solution {

	public int solution(int n) {
		int answer = n + 1;
		while (bitCount(answer) != bitCount(n)) {
			answer++;
		}
		return answer;
	}
}