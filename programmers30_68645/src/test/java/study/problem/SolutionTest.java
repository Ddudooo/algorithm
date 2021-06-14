package study.problem;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SolutionTest {

	@ParameterizedTest
	@CsvSource({
		"4, '1,2,9,3,10,8,4,5,6,7'",
		"5, '1,2,12,3,13,11,4,14,15,10,5,6,7,8,9'",
		"6, '1,2,15,3,16,14,4,17,21,13,5,18,19,20,12,6,7,8,9,10,11'"
	})
	void testCase(int input, String result) {
		Solution solution = new Solution();
		int[] answer = solution.solution(input);

		assertArrayEquals(resultToIntArray(result), answer, "답이 같아야 한다.");
	}

	private int[] resultToIntArray(String result) {
		String[] arrays = result.split(",");
		return Arrays.stream(arrays).map(String::trim).mapToInt(Integer::valueOf).toArray();
	}
}