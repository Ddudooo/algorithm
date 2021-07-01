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
	@CsvSource(value = {"5;[[2, 5], [4, 3], [4, 2], [3, 2], [1, 2]];2"}, delimiter = ';')
	void testCase(int n, String nodeStr, int result) {
		int answer = this.solution.solution(n, convertIntAry(nodeStr));
		assertEquals(result, answer, "답이 같아야 한다.");
	}

	private int[][] convertIntAry(String source) {
		source = source.replaceAll("\\[", "");
		source = source.replaceAll("]", "");
		String[] split = Arrays.stream(source.split(",")).map(String::trim).toArray(String[]::new);
		int[][] nodeAry = new int[split.length / 2][2];
		int idx = 0;
		for (int i = 0; i < split.length; i = i + 2) {
			nodeAry[idx][0] = Integer.parseInt(split[i]);
			nodeAry[idx][1] = Integer.parseInt(split[i + 1]);
			idx++;
		}
		return nodeAry;
	}
}