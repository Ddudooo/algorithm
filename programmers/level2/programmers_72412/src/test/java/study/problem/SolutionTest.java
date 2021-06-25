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
		"java backend junior pizza 150, " +
			"python frontend senior chicken 210, " +
			"python frontend senior chicken 150, " +
			"cpp backend senior pizza 260, " +
			"java backend junior chicken 80, " +
			"python backend senior chicken 50" +
			"&" +
			"java and backend and junior and pizza 100, " +
			"python and frontend and senior and chicken 200, " +
			"cpp and - and senior and pizza 250, " +
			"- and backend and senior and - 150, " +
			"- and - and - and chicken 100, " +
			"- and - and - and - 150" +
			"&" +
			"1,1,1,1,2,4"
	}, delimiter = '&')
	void testCase(String infos, String queries, String results) {
		assertSolution(infos, queries, results);
	}

	private void assertSolution(String infos, String queries, String results) {
		int[] answer = this.solution.solution(strToStrAry(infos), strToStrAry(queries));
		assertArrayEquals(getResults(results), answer, "답이 같아야 한다.");
	}

	private String[] strToStrAry(String str) {
		String[] strs = str.split(",");
		return Arrays.stream(strs).map(String::trim).toArray(String[]::new);
	}


	private int[] getResults(String results) {
		String[] strings = strToStrAry(results);
		return Arrays.stream(strings).mapToInt(Integer::valueOf).toArray();
	}
}