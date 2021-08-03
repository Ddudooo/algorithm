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
		"[[1, 4], [3, 2], [4, 1]]\t[[3, 3], [3, 3]]\t[[15, 15], [15, 15], [15, 15]]",
		"[[2, 3, 2], [4, 2, 4], [3, 1, 4]]\t[[5, 4, 3], [2, 4, 1], [3, 1, 1]]\t[[22, 22, 11], [36, 28, 18], [29, 20, 14]]"
	}, delimiter = '\t')
	void testCase(String arr1Str, String arr2Str, String resultStr) {
		int[][] arr1 = strToIntDoubleAry(arr1Str);
		int[][] arr2 = strToIntDoubleAry(arr2Str);
		int[][] result = strToIntDoubleAry(resultStr);
		int[][] answer = this.solution.solution(arr1, arr2);

		assertArrayEquals(result, answer, "답이 같아야 한다.");
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