package study.programmers30_42883;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SolutionTest {

	@ParameterizedTest
	@CsvSource({"1924,2,94", "1231234,3,3234", "4177252841,4,775841"})
	void solution(String number, int k, String expected) {
		Solution solution = new Solution();
		String answer = solution.solution(number, k);
		assertEquals(expected, answer);
	}
}