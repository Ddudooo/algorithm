package study.problem;

public class Solution {

	public int solution(String s) {
		int length = s.length();
		char[] chars = s.toCharArray();
		for (int l = length; l > 1; l--) {

			for (int start = 0; start + l <= length; start++) {
				boolean isPanlindrome = true;
				for (int i = 0; i < l / 2; i++) {
					if (chars[start + i] != chars[start + l - i - 1]) {
						isPanlindrome = false;
						break;
					}
				}
				if (isPanlindrome) {
					return l;
				}
			}

		}
		return 1;
	}
}