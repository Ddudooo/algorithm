package study.problem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SolutionTest {

	@ParameterizedTest
	@CsvSource({
		"8, 4, 7, 3",
		"8, 2, 3, 2",
		"8, 4, 7, 3"
	})
	void testCase(int N, int A, int B, int result) {
		Solution solution = new Solution();
		int answer = solution.solution(N, A, B);

		assertEquals(result, answer, "답이 일치하여야 한다.");
	}
}