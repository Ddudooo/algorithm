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
		"KAKAO\t[11, 1, 27, 15]",
		"TOBEORNOTTOBEORTOBEORNOT\t[20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34]",
		"ABABABABABABABAB\t[1, 2, 27, 29, 28, 31, 30]"
	}, delimiter = '\t')
	void testCase(String msg, String resultStr) {
		int[] answer = this.solution.solution(msg);

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