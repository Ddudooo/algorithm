package study.problem;

import java.math.BigInteger;

public class Solution {

	public long solution(long w, long h) {
		long answer = (w * h);
		int temp = getGcd(w, h);
		answer -= w + h - temp;
		return answer;
	}

	private int getGcd(long a, long b) {
		BigInteger biA = BigInteger.valueOf(a);
		BigInteger biB = BigInteger.valueOf(b);
		BigInteger gcd = biA.gcd(biB);
		return gcd.intValue();
	}
}