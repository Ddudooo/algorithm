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
	@CsvSource(value = {
		"[9,-1,-5]\t3",
		"[-16,27,65,-2,58,-92,-71,-68,-61,-33]\t6"
	}, delimiter = '\t')
	void testCase(String inputStr, int result) {
		int answer = this.solution.solution(strToIntAry(inputStr));

		assertEquals(result, answer, "답이 같아야 한다.");
	}

	private int[] strToIntAry(String resultStr) {
		String[] split = resultStr.split(",");
		return Arrays.stream(split)
			.map(s -> s.replaceAll("[\\[\\]]", ""))
			.map(String::trim)
			.mapToInt(Integer::valueOf)
			.toArray();
	}
}