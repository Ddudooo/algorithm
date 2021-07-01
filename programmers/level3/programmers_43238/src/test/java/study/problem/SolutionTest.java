package study.problem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
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
	@CsvSource(value = {"6;7,10;28"}, delimiter = ';')
	void testCase(int n, String timeStr, long result) {
		long answer = this.solution.solution(n, parseIntArray(timeStr));

		assertEquals(result, answer, "답이 같아야 한다.");
	}

	private int[] parseIntArray(String input) {
		String[] split = input.split(",");
		return Arrays.stream(split).mapToInt(Integer::parseInt).toArray();
	}
}