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
		"\"3people unFollowed me\"\t\"3people Unfollowed Me\"",
		"\"for the last week\"\t\"For The Last Week\""
	}, delimiter = '\t')
	void testCase(String s, String result) {
		s = s.replaceAll("\"", "");
		result = result.replaceAll("\"", "");
		String answer = this.solution.solution(s);

		assertEquals(result, answer, "답이 같아야 한다.");
	}
}