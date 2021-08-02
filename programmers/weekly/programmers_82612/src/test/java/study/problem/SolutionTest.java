package study.problem;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
		"3\t20\t4\t10"
	}, delimiter = '\t')
	void testCase(int price, int money, int count, long result) {
		long answer = this.solution.solution(price, money, count);

		assertEquals(result, answer, "답이 같아야 한다.");
	}
}