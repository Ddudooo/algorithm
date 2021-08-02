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
	void testCase(int m, int n, String boardStr, int result) {
		int answer = this.solution.solution(m, n, strToStrAry(boardStr));

		assertEquals(result, answer, "답이 같아야 한다.");
	}

	private String[] strToStrAry(String str) {
		String[] split = str.split(",");
		return Arrays.stream(split)
			.map(s -> s.replaceAll("\\W", ""))
			.map(String::trim)
			.toArray(String[]::new);
	}
}