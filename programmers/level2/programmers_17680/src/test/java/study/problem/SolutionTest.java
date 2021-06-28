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
	@CsvSource({
		"3, Jeju Pangyo Seoul NewYork LA Jeju Pangyo Seoul NewYork LA, 50",
		"3, Jeju Pangyo Seoul Jeju Pangyo Seoul Jeju Pangyo Seoul, 21",
		"2, Jeju Pangyo Seoul NewYork LA SanFrancisco Seoul Rome Paris Jeju NewYork Rome, 60",
		"5, Jeju Pangyo Seoul NewYork LA SanFrancisco Seoul Rome Paris Jeju NewYork Rome, 52",
		"2, Jeju Pangyo NewYork newyork, 16",
		"0, Jeju Pangyo Seoul NewYork LA, 25",
		"5, SEOUL SEOUL SEOUL, 7"
	})
	void testCase(int cacheSize, String citiesStr, int result) {
		assertSolution(cacheSize, citiesStr, result);
	}

	private void assertSolution(int cacheSize, String citiesStr, int result) {
		int answer = this.solution.solution(cacheSize, strToStringAry(citiesStr));
		assertEquals(result, answer, "답이 같아야 한다.");
	}

	private String[] strToStringAry(String source) {
		String[] strs = source.split(" ");
		return Arrays.stream(strs).map(String::trim).toArray(String[]::new);
	}
}