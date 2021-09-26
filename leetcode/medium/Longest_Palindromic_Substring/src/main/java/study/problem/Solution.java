package study.problem;

public class Solution {

	public String longestPalindrome(String s) {
		int length = s.length();
		if (length <= 1) {
			return s;
		}
		for (int len = length - 1; len >= 1; len--) {
			for (int start = 0; start + len < length; start++) {
				if (isPalindrome(s, start, start + len)) {
					return s.substring(start, start + len + 1);
				}
			}
		}
		return s.substring(0, 1);
	}

	private boolean isPalindrome(String s, int start, int end) {
		while (start < end) {
			if (s.charAt(start++) != s.charAt(end--)) {
				return false;
			}
		}
		return true;
	}
}