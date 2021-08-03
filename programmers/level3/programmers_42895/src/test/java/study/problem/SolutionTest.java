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
		"5\t12\t4",
		"2\t11\t3"
	}, delimiter = '\t')
	void testCase(int N, int number, int result) {
		int answer = this.solution.solution(N, number);

		assertEquals(result, answer, "답이 같아야 한다.");
	}
}