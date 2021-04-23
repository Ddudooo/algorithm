package study.programmers30_42746;

import java.util.Arrays;

public class Solution {

	public String solution(int[] numbers) {
		String[] strAry = new String[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			strAry[i] = String.valueOf(numbers[i]);
		}
		Arrays.sort(strAry, (a, b) -> (b + a).compareTo(a + b));
		if ("0".equals(strAry[0])) {
			return "0";
		}
		StringBuffer sb = new StringBuffer();
		Arrays.stream(strAry).forEach(sb::append);
		return sb.toString();
	}
}