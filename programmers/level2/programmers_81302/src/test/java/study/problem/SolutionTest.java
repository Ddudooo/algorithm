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
		"[[\"POOOP\", \"OXXOX\", \"OPXPX\", \"OOXOX\", \"POXXP\"], [\"POOPX\", \"OXPXP\", \"PXXXO\", \"OXXXO\", \"OOOPP\"], [\"PXOPX\", \"OXOXP\", \"OXPOX\", \"OXXOP\", \"PXPOX\"], [\"OOOXX\", \"XOOOX\", \"OOOXX\", \"OXOOX\", \"OOOOO\"], [\"PXPXP\", \"XPXPX\", \"PXPXP\", \"XPXPX\", \"PXPXP\"]]\t[1, 0, 1, 1, 1]"
	}, delimiter = '\t')
	void testCase(String placeStr, String resultStr) {
		String[][] places = strToDoubleStrAry(placeStr);
		int[] result = strToIntAry(resultStr);
		int[] answer = this.solution.solution(places);

		assertArrayEquals(result, answer, "답이 같아야 한다.");
	}

	private int[] strToIntAry(String resultStr) {
		String[] split = resultStr.split(",");
		return Arrays.stream(split)
			.map(s -> s.replaceAll("\\D", ""))
			.map(String::trim)
			.mapToInt(Integer::valueOf)
			.toArray();
	}

	private String[][] strToDoubleStrAry(String str) {
		String[] split = str.split("],.?\\[");
		return Arrays.stream(split)
			.map(row -> {
				String[] ele = row.split(",");
				return Arrays.stream(ele)
					.map(s -> s.replaceAll("\\W", ""))
					.map(String::trim)
					.toArray(String[]::new);
			})
			.toArray(String[][]::new);
	}
}