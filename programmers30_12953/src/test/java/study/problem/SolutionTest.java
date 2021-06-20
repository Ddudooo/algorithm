package study.problem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SolutionTest {

	@ParameterizedTest
	@CsvSource({
		"'2,6,8,14', 168",
		"'1,2,3', 6"
	})
	void testCase(String input, int result) {
		Solution solution = new Solution();
		int answer = solution.solution(strToIntArray(input));

		assertEquals(result, answer, "답이 같아야한다.");
	}

	private int[] strToIntArray(String input) {
		String[] split = input.split(",");
		return Arrays.stream(split).map(String::trim).mapToInt(Integer::valueOf).toArray();
	}
}