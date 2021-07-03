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
		"hit; cog;[\"hot\", \"dot\", \"dog\", \"lot\", \"log\", \"cog\"];4",
		"hit; cog;[\"hot\", \"dot\", \"dog\", \"lot\", \"log\"];0",
		"hit; hhh;[\"hhh\", \"hht\"];2"
	}
		, delimiter = ';')
	void testCase(String begin, String target, String wordStr, int result) {
		String[] words = strToStrAry(wordStr);
		int answer = this.solution.solution(begin, target, words);

		assertEquals(result, answer, "답이 같아야 한다.");
	}

	private String[] strToStrAry(String str) {
		str = str.replaceAll("\\[", "");
		str = str.replaceAll("]", "");
		str = str.replaceAll("\"", "");
		String[] split = str.split(",");
		return Arrays.stream(split).map(String::trim).toArray(String[]::new);
	}
}