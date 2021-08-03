package study.problem;

public class Solution {

	public int[] solution(String s) {
		int[] answer = new int[2];
		while (!s.equals("1")) {
			answer[0]++;
			String replace = s.replaceAll("0", "");
			answer[1] += s.length() - replace.length();
			s = Integer.toBinaryString(replace.length());
		}
		return answer;
	}
}