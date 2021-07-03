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
		"[[\"ICN\", \"JFK\"], [\"HND\", \"IAD\"], [\"JFK\", \"HND\"]];[\"ICN\", \"JFK\", \"HND\", \"IAD\"]",
		"[[\"ICN\", \"SFO\"], [\"ICN\", \"ATL\"], [\"SFO\", \"ATL\"], [\"ATL\", \"ICN\"], [\"ATL\",\"SFO\"]];[\"ICN\", \"ATL\", \"ICN\", \"SFO\", \"ATL\", \"SFO\"]"
	}
		, delimiter = ';')
	void testCase(String ticketStr, String resultStr) {
		String[] answer = this.solution.solution(ticketStrToStrAry(ticketStr));
		String[] result = strToStrAry(resultStr);
		System.out.println("answer = " + Arrays.toString(answer));
		System.out.println("result = " + Arrays.toString(result));
		assertArrayEquals(result, answer, "답이 같아야 한다.");
	}

	private String[][] ticketStrToStrAry(String str) {
		str = str.replaceAll("\\[", "");
		str = str.replaceAll("]", "");
		str = str.replaceAll("\"", "");
		String[] split = str.split(",");
		split = Arrays.stream(split).map(String::trim).toArray(String[]::new);
		String[][] result = new String[split.length / 2][2];
		int idx = 0;
		for (int i = 0; i < split.length; i = i + 2) {
			result[idx][0] = split[i];
			result[idx][1] = split[i + 1];
			idx++;
		}
		return result;
	}

	private String[] strToStrAry(String str) {
		str = str.replaceAll("\\[", "");
		str = str.replaceAll("]", "");
		str = str.replaceAll("\"", "");
		String[] split = str.split(",");
		return Arrays.stream(split).map(String::trim).toArray(String[]::new);
	}
}