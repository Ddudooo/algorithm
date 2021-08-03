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
		"\"110010101001\"\t[3,8]",
		"\"01110\"\t[3,3]",
		"\"1111111\"\t[4,1]"
	}, delimiter = '\t')
	void testCase(String s, String resultStr) {
		s = s.replaceAll("\"", "");
		int[] answer = this.solution.solution(s);

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