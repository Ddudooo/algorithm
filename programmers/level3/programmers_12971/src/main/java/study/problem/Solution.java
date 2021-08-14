package study.problem;

import java.util.Arrays;

public class Solution {

	public int solution(int sticker[]) {
		int length = sticker.length;
		if (length <= 3) {
			return Arrays.stream(sticker).max().getAsInt();
		}
		int end = length - 1;
		int[][] sum = new int[2][length];
		sum[0][0] = sticker[0];
		sum[0][1] = sticker[0];
		sum[1][0] = 0;
		sum[1][1] = sticker[1];

		for (int i = 2; i < end; i++) {
			int currentSticker = sticker[i];
			sum[0][i] = Math.max(sum[0][i - 1], sum[0][i - 2] + currentSticker);
			sum[1][i] = Math.max(sum[1][i - 1], sum[1][i - 2] + currentSticker);
		}
		sum[0][end] = Math.max(sum[0][end - 2], sum[0][end - 1]);
		sum[1][end] = Math.max(sum[1][end - 2] + sticker[end], sum[1][end - 1]);
		return Math.max(sum[0][end], sum[1][end]);
	}

}