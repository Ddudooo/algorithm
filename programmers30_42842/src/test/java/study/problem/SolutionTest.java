package study.problem;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SolutionTest {

	@ParameterizedTest
	@CsvSource({
		"10, 2, '4, 3'",
		"8, 1, '3, 3'",
		"24, 24, '8, 6'"
	})
	void testCase(int brown, int yellow, String result) {
		Solution solution = new Solution();
		int[] answer = solution.solution(brown, yellow);

		assertArrayEquals(resultToIntArray(result), answer, "결과값이 같아야 한다.");
	}

	private int[] resultToIntArray(String result) {
		String[] expect = result.split(",");
		return Arrays.stream(expect).map(String::trim).mapToInt(Integer::valueOf).toArray();
	}
}