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
		"[4, 3, 3]\t4\t12",
		"[2, 1, 2]\t1\t6",
		"[1,1]\t3\t0"
	}, delimiter = '\t')
	void testCase(String workStr, int n, long result) {
		long answer = this.solution.solution(n, strToIntAry(workStr));

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