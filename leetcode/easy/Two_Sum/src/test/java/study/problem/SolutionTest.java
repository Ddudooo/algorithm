package study.problem;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

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
	@CsvSource(value = {
		"[2,7,11,15]\t9\t[0,1]",
		"[3,2,4]\t6\t[1,2]",
		"[3,3]\t6\t[0,1]"
	}, delimiter = '\t')
	void testCase(String numStr, int target, String resultStr) {
		int[] answer = solution.twoSum(strToIntAry(numStr), target);

		assertArrayEquals(strToIntAry(resultStr), answer, "답이 같아야 한다.");
	}

	private int[] strToIntAry(String str) {
		String[] split = str.split(",");
		return Arrays.stream(split)
			.map(s -> s.replaceAll("\\D", ""))
			.map(String::trim)
			.mapToInt(Integer::valueOf)
			.toArray();
	}
}