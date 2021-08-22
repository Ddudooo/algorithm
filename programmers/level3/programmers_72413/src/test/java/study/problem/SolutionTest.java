package study.problem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SolutionTest {

	private Solution solution;

	@BeforeEach
	void init() {
		solution = new Solution();
	}

	@ParameterizedTest
	@CsvSource(value = {
		"6\t4\t6\t2\t[[4, 1, 10], [3, 5, 24], [5, 6, 2], [3, 1, 41], [5, 1, 24], [4, 6, 50], [2, 4, 66], [2, 3, 22], [1, 6, 25]]\t82",
		"7\t3\t4\t1\t[[5, 7, 9], [4, 6, 4], [3, 6, 1], [3, 2, 3], [2, 1, 6]]\t14",
		"6\t4\t5\t6\t[[2,6,6], [6,3,7], [4,6,7], [6,5,11], [2,5,12], [5,3,20], [2,4,8], [4,3,9]]\t18"
	}, delimiter = '\t')
	void testCase(int n, int s, int a, int b, String fareStr, int result) {
		int answer = this.solution.solution(n, s, a, b, strToIntDoubleAry(fareStr));

		assertEquals(result, answer, "답이 같아야 한다.");
	}

	private int[][] strToIntDoubleAry(String str) {
		String[] split = str.split("(],.?\\[)");
		split = Arrays.stream(split)
			.map(splitStr -> splitStr.replaceAll("[]\\[]", ""))
			.toArray(String[]::new);
		return Arrays.stream(split)
			.map(splitStr ->
				Arrays.stream(splitStr.split(","))
					.map(String::trim)
					.mapToInt(Integer::valueOf)
					.toArray()
			)
			.toArray(int[][]::new);
	}
}