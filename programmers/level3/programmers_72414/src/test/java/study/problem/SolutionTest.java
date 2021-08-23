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
		"\"02:03:55\"\t\"00:14:15\"\t[\"01:20:15-01:45:14\", \"00:40:31-01:00:00\", \"00:25:50-00:48:29\", \"01:30:59-01:53:29\", \"01:37:44-02:02:30\"]\t\"01:30:59\"",
		"\"99:59:59\"\t\"25:00:00\"\t[\"69:59:59-89:59:59\", \"01:00:00-21:00:00\", \"79:59:59-99:59:59\", \"11:00:00-31:00:00\"]\t\"01:00:00\"",
		"\"50:00:00\"\t\"50:00:00\"\t[\"15:36:51-38:21:49\", \"10:14:18-15:36:51\", \"38:21:49-42:51:45\"]\t\"00:00:00\""
	}, delimiter = '\t')
	void testCase(String play_time, String adv_time, String logStr, String result) {
		String answer = this.solution.solution(play_time, adv_time, strToStrAry(logStr));

		String expect = result.replaceAll("\"", "");
		assertEquals(expect, answer, "답이 같아야 한다.");
	}

	private String[] strToStrAry(String str) {
		String[] split = str.split(",");
		return Arrays.stream(split)
			.map(s -> s.replaceAll("[]\\[\"]", ""))
			.map(String::trim)
			.toArray(String[]::new);
	}
}