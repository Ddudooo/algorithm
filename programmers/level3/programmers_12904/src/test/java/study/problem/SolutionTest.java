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
		"\"abcdcba\"\t7",
		"\"abacde\"\t3",
		"\"abcabcdcbae\"\t7",
		"\"aaaa\"\t4",
		"\"abcde\"\t1",
		"\"a\"\t1",
		"\"abcbaqwertrewqq\"\t9",
		"\"abcbaqwqabcba\"\t13",
		"\"abba\"\t4",
		"\"abaabaaaaaaa\"\t7"
	}, delimiter = '\t')
	void testCase(String s, int result) {
		s = s.replaceAll("\"", "");
		int answer = this.solution.solution(s);

		assertEquals(result, answer, "답이 같아야 한다.");
	}
}