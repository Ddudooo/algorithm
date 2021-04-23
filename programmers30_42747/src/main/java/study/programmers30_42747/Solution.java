package study.programmers30_42747;

import java.util.Arrays;

public class Solution {

	public int solution(int[] citations) {
		Arrays.sort(citations);
		for (int i = 0; i < citations.length; i++) {
			int h = citations.length - i;
			if (citations[i] >= h) {
				return h;
			}
		}
		return 0;
	}
}