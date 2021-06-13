package study.problem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SolutionTest {

	@ParameterizedTest
	@CsvSource({
		"[](){}, 3",
		"}]()[{, 2",
		"[)(], 0",
		"}}}, 0"
	})
	void testCase(String input, int result) {
		Solution solution = new Solution();
		int answer = solution.solution(input);

		assertEquals(result, answer, "답이 같아야한다.");
	}
}