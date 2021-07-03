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
	@CsvSource(value =
		{
			"[\"I 16\",\"D 1\"];[0,0]",
			"[\"I 7\",\"I 5\",\"I -5\",\"D -1\"];[7,5]"
		}
		, delimiter = ';')
	void testCase(String opStr, String resultStr) {
		int[] answer = this.solution.solution(strToStrAry(opStr));

		assertArrayEquals(strToIntAry(resultStr), answer, "답이 같아야 한다.");
	}

	private String[] strToStrAry(String str) {
		str = str.replaceAll("\\[", "");
		str = str.replaceAll("]", "");
		str = str.replaceAll("\"", "");
		String[] split = str.split(",");
		return Arrays.stream(split).map(String::trim).toArray(String[]::new);
	}

	private int[] strToIntAry(String str) {
		str = str.replaceAll("\\[", "");
		str = str.replaceAll("]", "");
		str = str.replaceAll("\"", "");
		String[] split = str.split(",");
		return Arrays.stream(split).map(String::trim).mapToInt(Integer::parseInt).toArray();
	}
}