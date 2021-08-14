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
		"[14, 6, 5, 11, 3, 9, 2, 10]\t36",
		"[1, 3, 2, 5, 4]\t8"
	}, delimiter = '\t')
	void testCase(String stickerStr, int result) {
		int answer = this.solution.solution(strToIntAry(stickerStr));

		assertEquals(result, answer, "답이 같아야 한다.");
	}

	private int[] strToIntAry(String resultStr) {
		String[] split = resultStr.split(",");
		return Arrays.stream(split)
			.map(s -> s.replaceAll("\\D", ""))
			.map(String::trim)
			.mapToInt(Integer::valueOf)
			.toArray();
	}
}