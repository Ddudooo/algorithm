package study.problem;

public class Solution {

	public String convert(String s, int numRows) {
		if (numRows == 1) {
			return s;
		}
		int numPerRound = numRows * 2 - 2;
		int len = s.length();
		int round = len % numPerRound == 0 ? len / numPerRound : len / numPerRound + 1;

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < round; j++) {
				int first = i + j * numPerRound;
				// v자 형식으로 반복되어 맨 윗줄과 맨 밑을 제외하면, 두번나와야 한다.
				int second = i + j * numPerRound + 2 * (numRows - 1 - i);
				if (first < len) {
					sb.append(s.charAt(first));
				}
				if (i != 0 && i != numRows - 1 && second < len) {
					sb.append(s.charAt(second));
				}
			}
		}
		return sb.toString();
	}
}