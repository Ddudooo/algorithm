package study.programmers30_42860;

public class Solution {

	private static final int Z_ASCII = 'Z';
	private static final int M_ASCII = 'M';//MIDDLE
	private static final int A_ASCII = 'A';

	public int solution(String name) {
		int answer = 0;
		int nameLength = name.length();
		int mvCnt = nameLength - 1;
		for (int i = 0; i < nameLength; i++) {
			char c = name.charAt(i);
			answer += move(c);
			int next = i + 1;
			while (next < nameLength &&
				name.charAt(next) == A_ASCII) {
				++next;
			}
			mvCnt = Math.min(mvCnt, i + nameLength - next + Math.min(i, nameLength - next));
		}
		answer += mvCnt;
		return answer;
	}

	private int move(char goal) {
		if ((int) goal <= M_ASCII) {
			return (int) goal - A_ASCII;
		} else {
			return Z_ASCII - (int) goal + 1;
		}
	}
}