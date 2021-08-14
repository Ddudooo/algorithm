package study.problem;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

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
		"2\t[ [1,2], [1,3], [2,3] ]",
		"3\t[[1, 3], [1, 2], [3, 2], [1, 3], [2, 1], [2, 3], [1, 3]]"
	}, delimiter = '\t')
	void testCase(int n, String resultStr) {
		int[][] answer = this.solution.solution(n);

		int[][] expected = strToIntDoubleAry(resultStr);
		assertArrayEquals(expected, answer, "답이 같아야 한다.");
	}

	private int[][] strToIntDoubleAry(String str) {
		String[] split = str.split("],.?\\[");
		return Arrays.stream(split)
			.map(s -> s.split(","))
			.map(strs ->
				Arrays.stream(strs)
					.map(s -> s.replaceAll("\\D", ""))
					.map(String::trim)
					.mapToInt(Integer::valueOf)
					.toArray())
			.toArray(int[][]::new);
	}
}