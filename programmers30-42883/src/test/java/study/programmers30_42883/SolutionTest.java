package study.programmers30_42883;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SolutionTest {

	@ParameterizedTest
	@CsvSource({
		"1924,2,94",
		"1231234,3,3234",
		"4177252841,4,775841",
		"99991,3,99",
		"111119,3,119",
		"7777777,2,77777",
		"10000,2,100",
		"87654321,3,87654",
		"01010,3,11"
	})
	void solution(String number, int k, String expected) {
		Solution solution = new Solution();
		String answer = solution.solution(number, k);
		assertEquals(expected, answer);
	}
}