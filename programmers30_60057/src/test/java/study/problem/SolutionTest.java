package study.problem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SolutionTest {

	@ParameterizedTest
	@CsvSource({
		"aabbaccc, 7",
		"ababcdcdababcdcd, 9",
		"abcabcdede, 8",
		"abcabcabcabcdededededede, 14",
		"xababcdcdababcdcd, 17"
	})
	void testCase(String s, int result) {
		Solution solution = new Solution();
		int answer = solution.solution(s);

		assertEquals(result, answer, "예상 답과 일치하여야 한다.");
	}
}