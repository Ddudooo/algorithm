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
		"[5,1,3,7]\t[2,2,6,8]\t3",
		"[2,2,2,2]\t[1,1,1,1]\t0"
	}, delimiter = '\t')
	void testCase(String aStr, String bStr, int result) {
		int answer = this.solution.solution(strToIntAry(aStr), strToIntAry(bStr));

		assertEquals(result, answer, "답이 같아야 한다.");
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