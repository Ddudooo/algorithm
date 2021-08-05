package study.problem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

	private Map<Integer, Long> factorialMemorized = new HashMap<>();

	public int[] solution(int n, long k) {
		init();
		int[] answer = new int[n];
		List<Integer> ableNums = IntStream.range(1, n + 1).boxed().collect(Collectors.toList());
		k--;
		for (int i = 0; i < n; i++) {
			long factorial = factorial(n - i - 1);
			int numberByIndex = (int) (k / factorial);
			k = (int) (k % factorial);
			answer[i] = ableNums.get(numberByIndex);
			ableNums.remove(numberByIndex);
		}
		return answer;
	}

	private void init() {
		factorialMemorized = new HashMap<>();
		factorialMemorized.put(0, 1L);
		factorialMemorized.put(1, 1L);
		factorialMemorized.put(2, 2L);
	}

	private long factorial(int number) {
		if (factorialMemorized.containsKey(number)) {
			return factorialMemorized.get(number);
		}
		long result = number * factorial(number - 1);
		factorialMemorized.put(number, result);
		return result;
	}
}