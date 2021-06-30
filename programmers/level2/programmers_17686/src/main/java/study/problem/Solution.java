package study.problem;

import java.util.Arrays;

public class Solution {

	public String[] solution(String[] files) {
		Arrays.sort(files, (alpha, beta) -> {
			String alphaH = alpha.split("[0-9]")[0];
			String betaH = beta.split("[0-9]")[0];
			int compareHead = alphaH.toUpperCase().compareTo(betaH.toUpperCase());
			if (compareHead == 0) {
				alpha = alpha.substring(alphaH.length());
				beta = beta.substring(betaH.length());
				String alphaN = "";
				for (char c : alpha.toCharArray()) {
					if (Character.isDigit(c) && alphaN.length() <= 5) {
						alphaN += c;
					} else {
						break;
					}
				}
				String betaN = "";
				for (char c : beta.toCharArray()) {
					if (Character.isDigit(c) && betaN.length() <= 5) {
						betaN += c;
					} else {
						break;
					}
				}
				return Integer.parseInt(alphaN) - Integer.parseInt(betaN);
			} else {
				return compareHead;
			}
		});
		return files;
	}
}