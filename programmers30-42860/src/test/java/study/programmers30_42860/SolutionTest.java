package study.programmers30_42860;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SolutionTest {

	@ParameterizedTest
	@CsvSource({"JEROEN,56", "JAN,23", "JAZ,11", "ABABAAAAAAABA,10", "AABAAAAAAABBB,11"})
	void solution(String name, int expected) {
		Solution solution = new Solution();
		int answer = solution.solution(name);
		Assertions.assertEquals(expected, answer);
	}
}