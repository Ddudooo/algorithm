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
		"[[0, 3], [1, 9], [2, 6]];9",
		"[[24, 10], [28, 39], [43, 20], [37, 5], [47, 22], [20, 47], [15, 34], [15, 2], [35, 43], [26, 1]];72"
	}, delimiter = ';')
	void testCase(String jobStr, int result) {
		int answer = this.solution.solution(strToIntAry(jobStr));

		assertEquals(result, answer, "답이 같아야 한다.");
	}

	private int[][] strToIntAry(String resource) {
		resource = resource.replaceAll("\\[", "");
		resource = resource.replaceAll("]", "");
		String[] split = resource.split(",");
		int[][] result = new int[split.length / 2][2];
		int idx = 0;
		for (int i = 0; i < split.length; i = i + 2) {
			result[idx][0] = Integer.parseInt(split[i].trim());
			result[idx][1] = Integer.parseInt(split[i + 1].trim());
			idx++;
		}
		return result;
	}

}