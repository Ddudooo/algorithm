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
		"[1,3]\t[2]\t2.00000",
		"[1,2]\t[3,4]\t2.50000",
		"[0,0]\t[0,0]\t0.00000",
		"[]\t[1]\t1.00000",
		"[2]\t[]\t2.00000"
	}, delimiter = '\t')
	void testCase(String num1Str, String num2Str, double result) {
		double answer = solution.findMedianSortedArrays(strToIntAry(num1Str),
			strToIntAry(num2Str));

		assertEquals(result, answer, "답이 같아야 한다.");
	}

	private int[] strToIntAry(String str) {
		String[] split = str.split(",");
		if (split[0].replaceAll("\\D", "").trim().isEmpty()) {
			return new int[]{};
		}
		return Arrays.stream(split)
			.map(s -> s.replaceAll("\\D", ""))
			.map(String::trim)
			.mapToInt(Integer::valueOf)
			.toArray();
	}
}