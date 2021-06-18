package study.problem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SolutionTest {

	@ParameterizedTest
	@CsvSource({
		"100-200*300-500+20, 60420",
		"50*6-3*2, 300"
	})
	void testCase(String expression, long result) {
		Solution solution = new Solution();
		long answer = solution.solution(expression);

		assertEquals(result, answer, "답이 같아야 한다.");
	}
}