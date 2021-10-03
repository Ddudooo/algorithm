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
	@CsvSource(
		value = {
			"PAYPALISHIRING\t3\tPAHNAPLSIIGYIR",
			"PAYPALISHIRING\t4\tPINALSIGYAHRPI",
			"A\t1\tA"
		}, delimiter = '\t'
	)
	void testCase(String s, int numRows, String expect) {
		String answer = solution.convert(s, numRows);

		assertEquals(expect, answer, "답이 같아야 한다.");
	}
}