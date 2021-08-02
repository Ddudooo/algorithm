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
		"2\t4\t2\t1\t\"0111\"",
		"16\t16\t2\t1\t\"02468ACE11111111\"",
		"16\t16\t2\t2\t\"13579BDF01234567\""
	}, delimiter = '\t')
	void testCase(int n, int t, int m, int p, String result) {
		String answer = this.solution.solution(n, t, m, p);

		assertEquals(result.replaceAll("\\W", ""), answer, "답이 같아야 한다.");
	}
}