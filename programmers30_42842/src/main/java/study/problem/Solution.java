package study.problem;

public class Solution {

	public int[] solution(int brown, int yellow) {
		int[] answer = new int[2];
		int borderSize = (int) (brown + 4) / 2;
		for (int i = 3; i <= borderSize; i++) {
			int j = borderSize - i;
			if (j < i) {
				continue;
			}
			int isYellowCnt = (i - 2) * (j - 2);
			if (yellow == isYellowCnt) {
				answer[0] = j;
				answer[1] = i;
				break;
			}
		}
		return answer;
	}
}