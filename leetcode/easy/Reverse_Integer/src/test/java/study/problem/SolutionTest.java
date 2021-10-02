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
		"123\t321",
		"-123\t-321",
		"123\t321",
		"0\t0"
	}, delimiter = '\t')
	void testCase(int input, int expect) {
		int answer = solution.reverse(input);

		assertEquals(expect, answer, "답이 같아야 한다.");
	}
}