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
		"2\t[ [1,2], [1,3], [2,3] ]"
	}, delimiter = '\t')
	void testCase(int n, String resultStr) {
		int[][] answer = this.solution.solution(n);

		assertArrayEquals(strToDoubleStrAry(resultStr), answer, "답이 같아야 한다.");
	}

	private String[][] strToDoubleStrAry(String str) {
		String[] split = str.split("],.?\\[");
		return Arrays.stream(split)
			.map(row -> {
				String[] ele = row.split(",");
				return Arrays.stream(ele)
					.map(s -> s.replaceAll("\\W", ""))
					.map(String::trim)
					.toArray(String[]::new);
			})
			.toArray(String[][]::new);
	}
}