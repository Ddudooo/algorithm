package study.programmers30_42839;

import java.util.HashSet;
import java.util.Set;

public class Solution {

	public int solution(String numbers) {
		Set<Integer> primeNums = new HashSet<>();
		permutation("", numbers, primeNums);
		System.out.println(primeNums);
		return primeNums.size();
	}

	public void permutation(String prefix, String str, Set<Integer> set) {
		int n = str.length();
		if (!prefix.equals("")) {
			Integer number = Integer.valueOf(prefix);
			if (isPrime(number)) {
				set.add(number);
			}
		}

		for (int i = 0; i < n; i++) {
			permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), set);
		}
	}

	public boolean isPrime(int number) {
		// 0 과 1 은 소수가 아니다
		if (number < 2) {
			return false;
		}

		// 2 는 소수다
		if (number == 2) {
			return true;
		}

		for (int i = 2; i < number; i++) {

			// 소수가 아닐경우
			if (number % i == 0) {

				return false;
			}
		}
		return true;
	}
}