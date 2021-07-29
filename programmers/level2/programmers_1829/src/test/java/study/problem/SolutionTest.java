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
		"6\t4\t[[1, 1, 1, 0], [1, 2, 2, 0], [1, 0, 0, 1], [0, 0, 0, 1], [0, 0, 0, 3], [0, 0, 0, 3]]\t[4, 5]",
		"6\t4\t[[1, 1, 1, 0], [1, 1, 1, 0], [0, 0, 0, 1], [0, 0, 0, 1], [0, 0, 0, 1], [0, 0, 0, 1]]\t[2, 6]"
	}, delimiter = '\t')
	void testCase(int m, int n, String pictureStr, String answerStr) {
		int[] answer = this.solution.solution(m, n, strToIntDoubleAry(pictureStr));

		assertArrayEquals(strToIntAry(answerStr), answer, "답이 같아야 한다.");
	}

	private int[] strToIntAry(String str) {
		String[] split = str.split(",");
		return Arrays.stream(split)
			.map(s -> s.replaceAll("\\D", ""))
			.map(String::trim)
			.mapToInt(Integer::valueOf)
			.toArray();
	}

	private int[][] strToIntDoubleAry(String str) {
		String[] split = str.split("(],.?\\[)");
		split = Arrays.stream(split)
			.map(splitStr -> splitStr.replaceAll("[]\\[]", ""))
			.toArray(String[]::new);
		return Arrays.stream(split)
			.map(splitStr ->
				Arrays.stream(splitStr.split(","))
					.map(String::trim)
					.mapToInt(Integer::valueOf)
					.toArray()
			)
			.toArray(int[][]::new);
	}


}