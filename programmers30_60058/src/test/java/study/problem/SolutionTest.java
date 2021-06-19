package study.problem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SolutionTest {

	@ParameterizedTest
	@CsvSource({
		"(()())(), (()())()",
		")(, ()",
		"()))(((), ()(())()"
	})
	void testCase(String p, String result) {
		Solution solution = new Solution();
		String answer = solution.solution(p);
		assertEquals(result, answer, "답이 같아야 한다.");
	}
}