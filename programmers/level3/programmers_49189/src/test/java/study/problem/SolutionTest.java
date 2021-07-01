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
		"6;[[3,6],[4,3],[3,2],[1,3],[1,2],[2,4],[5,2]];3"
	}, delimiter = ';')
	void testCase(int n, String edgeStr, int result) {
		int answer = this.solution.solution(n, getEdge(edgeStr));
		assertEquals(result, answer, "답이 같아야 한다.");
	}

	private int[][] getEdge(String source) {
		source = source.replaceAll("\\[", "");
		source = source.replaceAll("]", "");
		String[] split = source.split(",");
		int[][] result = new int[split.length / 2][2];
		int idx = 0;
		for (int i = 0; i < split.length; i = i + 2) {
			result[idx][0] = Integer.parseInt(split[i]);
			result[idx][1] = Integer.parseInt(split[i + 1]);
			idx++;
		}
		return result;
	}
}