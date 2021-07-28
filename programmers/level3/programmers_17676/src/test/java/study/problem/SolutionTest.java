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
		"\"2016-09-15 01:00:04.001 2.0s\","
			+ "\"2016-09-15 01:00:07.000 2s\""
			+ ";"
			+ "1",
		"\"2016-09-15 01:00:04.002 2.0s\","
			+ "\"2016-09-15 01:00:07.000 2s\""
			+ ";"
			+ "2",
		"\"2016-09-15 20:59:57.421 0.351s\","
			+ "\"2016-09-15 20:59:58.233 1.181s\","
			+ "\"2016-09-15 20:59:58.299 0.8s\","
			+ "\"2016-09-15 20:59:58.688 1.041s\","
			+ "\"2016-09-15 20:59:59.591 1.412s\","
			+ "\"2016-09-15 21:00:00.464 1.466s\","
			+ "\"2016-09-15 21:00:00.741 1.581s\","
			+ "\"2016-09-15 21:00:00.748 2.31s\","
			+ "\"2016-09-15 21:00:00.966 0.381s\","
			+ "\"2016-09-15 21:00:02.066 2.62s\""
			+ ";"
			+ "7",
		"2016-09-15 20:59:56.000 0.001s,"
			+ "2016-09-15 20:59:57.000 0.001s"
			+ ";"
			+ "1"
	}, delimiter = ';')
	void testCase(String lineStr, int expect) {
		System.out.println(lineStr);
		int answer = this.solution.solution(strToAryStr(lineStr));
		assertEquals(expect, answer, "답이 같아야 한다.");
	}

	private String[] strToAryStr(String str) {
		str = str.replaceAll("\"", "");
		String[] split = str.split(",");
		return Arrays.stream(split).map(String::trim).toArray(String[]::new);
	}
}