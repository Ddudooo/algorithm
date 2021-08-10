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
	@CsvSource(value = {}, delimiter = '\t')
	void testCase(String scoreStr, String result) {
		int[][] score = strToIntDoubleAry(scoreStr);
		String answer = this.solution.solution(score);

		assertEquals(result, answer, "답이 같아야 한다.");
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