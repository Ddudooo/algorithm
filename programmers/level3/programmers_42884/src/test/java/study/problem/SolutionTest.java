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
		"[[-20,15], [-14,-5], [-18,-13], [-5,-3]]\t2"
	}, delimiter = '\t')
	void testCase(String routeStr, int result) {
		int answer = this.solution.solution(strToIntDoubleAry(routeStr));

		assertEquals(result, answer, "답이 같아야 한다.");
	}

	private int[][] strToIntDoubleAry(String str) {
		String[] split = str.split("],.?\\[");
		return Arrays.stream(split)
			.map(s -> s.split(","))
			.map(strs ->
				Arrays.stream(strs)
					.map(s -> s.replaceAll("[\\[\\]]", ""))
					.map(String::trim)
					.mapToInt(Integer::valueOf)
					.toArray())
			.toArray(int[][]::new);
	}
}