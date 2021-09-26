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
		"babad\tbab",
		"cbbd\tbb",
		"a\ta",
		"ac\ta"
	}, delimiter = '\t')
	void testCase(String input, String result) {
		String answer = solution.longestPalindrome(input);

		assertEquals(result, answer, "답이 같아야 한다.");
	}
}