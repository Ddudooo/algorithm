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
		"[\"DIA\", \"RUBY\", \"RUBY\", \"DIA\", \"DIA\", \"EMERALD\", \"SAPPHIRE\", \"DIA\"]\t[3, 7]",
		"[\"AA\", \"AB\", \"AC\", \"AA\", \"AC\"]\t[1, 3]",
		"[\"XYZ\", \"XYZ\", \"XYZ\"]\t[1, 1]",
		"[\"ZZZ\", \"YYY\", \"NNNN\", \"YYY\", \"BBB\"]\t[1, 5]"
	}, delimiter = '\t')
	void testCase(String gemStr, String resultStr) {
		int[] answer = this.solution.solution(strToStrAry(gemStr));
		assertArrayEquals(strToIntAry(resultStr), answer, "답이 같아야 한다");
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
		String[] split = str.split(",");
		return Arrays.stream(split).map(String::trim).mapToInt(Integer::parseInt).toArray();
	}
}