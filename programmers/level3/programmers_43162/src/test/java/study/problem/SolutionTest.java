package study.problem;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
		"3;[[1, 1, 0], [1, 1, 0], [0, 0, 1]];2",
		"3;[[1, 1, 0], [1, 1, 1], [0, 1, 1]];1"
	}
		, delimiter = ';')
	void testCase(int n, String computerStr, int result) {
		int[][] computers = strToIntAry(n, computerStr);
		int answer = this.solution.solution(n, computers);

		assertEquals(result, answer, "답이 일치하여야 한다.");
	}

	private int[][] strToIntAry(int n, String str) {
		str = str.replaceAll("\\[", "");
		str = str.replaceAll("]", "");
		String[] split = str.split(",");
		int[][] result = new int[split.length / n][n];
		int idx = 0;
		while (idx < split.length / n) {
			for (int j = 0; j < n; j++) {
				result[idx][j] = Integer.parseInt(split[idx * n + j].trim());
			}
			idx++;
		}
		return result;
	}
}