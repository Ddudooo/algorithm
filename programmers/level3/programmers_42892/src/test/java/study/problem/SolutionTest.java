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
		"[[5,3],[11,5],[13,3],[3,5],[6,1],[1,3],[8,6],[7,2],[2,2]]\t[[7,4,6,9,1,8,5,2,3],[9,6,5,8,1,4,3,2,7]]"
	}, delimiter = '\t')
	void testCase(String inputStr, String resultStr) {
		int[][] answer = this.solution.solution(strToIntDoubleAry(inputStr));

		assertArrayEquals(strToIntDoubleAry(resultStr), answer, "답이 같아야 한다.");
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