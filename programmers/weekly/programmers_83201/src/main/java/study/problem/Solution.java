package study.problem;

import java.util.stream.IntStream;

public class Solution {

	public String solution(int[][] scores) {
		StringBuilder sb = new StringBuilder();
		int length = scores.length;

		for (int i = 0; i < length; i++) {
			int[] scoreAry = new int[length];
			for (int j = 0; j < length; j++) {
				scoreAry[j] = scores[j][i];
			}
			int self = scoreAry[i];
			double sum = IntStream.of(scoreAry).sum();
			if (isSelfScoreMaxMinAlone(scoreAry, self)) {
				sum -= self;
				sb.append(calculateScore(sum, length - 1));
			} else {
				sb.append(calculateScore(sum, length));
			}
		}
		return sb.toString();
	}

	private boolean isSelfScoreMaxMinAlone(int[] scores, int selfScore) {
		int max = IntStream.of(scores).max().getAsInt();
		int min = IntStream.of(scores).min().getAsInt();
		if (max == selfScore || min == selfScore) {
			long count = IntStream.of(scores).filter(v -> v == selfScore).count();
			return count == 1;
		}
		return false;
	}

	private char calculateScore(double score, int length) {
		score = score / length;
		if (score >= 90) {
			return 'A';
		}
		if (score >= 80) {
			return 'B';
		}
		if (score >= 70) {
			return 'C';
		}
		if (score >= 50) {
			return 'D';
		}
		return 'F';
	}
}