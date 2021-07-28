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
		"[\"classic\", \"pop\", \"classic\", \"classic\", \"pop\"]\t[500, 600, 150, 800, 2500]\t[4, 1, 3, 0]"
	}, delimiter = '\t')
	void testCase(String genreStr, String playStr, String returnStr) {
		int[] answer = this.solution.solution(strToAry(genreStr), strToIntAry(playStr));

		assertArrayEquals(strToIntAry(returnStr), answer, "답이 같아야 한다.");
	}

	private String[] strToAry(String str) {
		str = str.replaceAll("\"", "");
		str = str.replaceAll("[\\[\\]]", "");
		String[] split = str.split(",");

		return Arrays.stream(split).map(String::trim).toArray(String[]::new);
	}

	private int[] strToIntAry(String str) {
		return Arrays.stream(strToAry(str)).mapToInt(Integer::valueOf).toArray();
	}
}