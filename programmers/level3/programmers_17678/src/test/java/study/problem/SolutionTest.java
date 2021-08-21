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
		"1\t1\t5\t[\"08:00\", \"08:01\", \"08:02\", \"08:03\"]\t\"09:00\"",
		"2\t10\t2\t[\"09:10\", \"09:09\", \"08:00\"]\t\"09:09\"",
		"2\t1\t2\t[\"09:00\", \"09:00\", \"09:00\", \"09:00\"]\t\"08:59\"",
		"1\t1\t5\t[\"00:01\", \"00:01\", \"00:01\", \"00:01\", \"00:01\"]\t\"00:00\"",
		"1\t1\t1\t[\"23:59\"]\t\"09:00\"",
		"10\t60\t45\t[\"23:59\",\"23:59\", \"23:59\", \"23:59\", \"23:59\", \"23:59\", \"23:59\", \"23:59\", \"23:59\", \"23:59\", \"23:59\", \"23:59\", \"23:59\", \"23:59\", \"23:59\", \"23:59\"]\t\"18:00\""
	}, delimiter = '\t')
	void testCase(int n, int t, int m, String timetableStr, String result) {
		String answer = this.solution.solution(n, t, m, strToStrAry(timetableStr));

		assertEquals(result, answer, "답이 같아야 한다.");
	}

	private String[] strToStrAry(String str) {
		String[] split = str.split(",");
		return Arrays.stream(split)
			.map(s -> s.replaceAll("[]\\[\"]", ""))
			.map(String::trim)
			.toArray(String[]::new);
	}
}