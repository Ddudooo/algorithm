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
	@CsvSource({"4 ,5"})
	void testCase(int n, int result) {
		int answer = this.solution.solution(n);

		assertEquals(result, answer, "답이 같아야 한다.");
	}
}