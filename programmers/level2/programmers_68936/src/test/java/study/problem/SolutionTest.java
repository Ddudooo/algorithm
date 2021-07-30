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
		"[[1,1,0,0],[1,0,0,0],[1,0,0,1],[1,1,1,1]]\t[4,9]",
		"[[1,1,1,1,1,1,1,1],[0,1,1,1,1,1,1,1],[0,0,0,0,1,1,1,1],[0,1,0,0,1,1,1,1],[0,0,0,0,0,0,1,1],[0,0,0,0,0,0,0,1],[0,0,0,0,1,0,0,1],[0,0,0,0,1,1,1,1]]\t[10,15]"
	}, delimiter = '\t')
	void testCase(String aryStr, String resultStr) {
		int[] answer = this.solution.solution(strToIntDoubleAry(aryStr));

		assertArrayEquals(strToIntAry(resultStr), answer, "답이 같아야 한다.");
	}

	private int[] strToIntAry(String str) {
		String[] split = str.split(",");
		return Arrays.stream(split)
			.map(s -> s.replaceAll("\\D", ""))
			.map(String::trim)
			.mapToInt(Integer::valueOf)
			.toArray();
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