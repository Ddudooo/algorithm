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
		"\"ULURRDLLU\"\t7",
		"\"LULLLLLLU\"\t7"
	}, delimiter = '\t')
	void testCase(String dirStr, int result) {
		String dirs = dirStr.replaceAll("\\W", "");
		int answer = this.solution.solution(dirs);

		assertEquals(result, answer, "답이 같아야 한다.");
	}
}