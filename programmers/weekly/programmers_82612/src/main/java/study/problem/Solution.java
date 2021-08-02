package study.problem;

public class Solution {

	public long solution(int price, int money, int count) {
		long sum = 0;
		long nextPrice = price;
		for (int i = 1; i <= count; i++) {
			sum += nextPrice;
			nextPrice = (long) price * (i + 1);
		}
		if (sum <= money) {
			return 0;
		}
		return Math.abs(money - sum);
	}
}