package study.problem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SolutionTest {

	@ParameterizedTest
	@CsvSource({
		"()(), true",
		"(())(), true",
		")()(, false",
		"(()(, false"
	})
	void testCase(String input, boolean result) {
		Solution solution = new Solution();
		boolean answer = solution.solution(input);

		assertEquals(result, answer, "답이 같아야 한다.");
	}
}