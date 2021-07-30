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
		"5\t[[1,2,1],[2,3,3],[5,2,2],[1,4,2],[5,3,1],[5,4,2]]\t3\t4",
		"6\t[[1,2,1],[1,3,2],[2,3,2],[3,4,3],[3,5,2],[3,5,3],[5,6,1]]\t4\t4"
	}, delimiter = '\t')
	void testCase(int n, String roadStr, int k, int result) {
		int answer = this.solution.solution(n, strToIntDoubleAry(roadStr), k);

		assertEquals(result, answer, "답이 같아야 한다.");
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