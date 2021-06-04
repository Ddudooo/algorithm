package study.problem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SolutionTest {

	@ParameterizedTest
	@CsvSource({
		"baabaa, 1",
		"cdcd, 0"
	})
	void testCase(String s, int result) {
		Solution solution = new Solution();
		int answer = solution.solution(s);

		assertEquals(result, answer, "리턴값이 같아야 한다.");
	}
}