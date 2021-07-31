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
		"\"CBD\"\t[\"BACDE\", \"CBADF\", \"AECB\", \"BDA\"]\t2"
	}, delimiter = '\t')
	void testCase(String skillStr, String skillTreeStr, int result) {
		String skill = skillStr.replaceAll("\\W", "");
		int answer = this.solution.solution(skill, strToStrAry(skillTreeStr));

		assertEquals(result, answer, "답이 같아야 한다.");
	}

	private String[] strToStrAry(String str) {
		String[] split = str.split(",");
		return Arrays.stream(split)
			.map(s -> s.replaceAll("\\W", ""))
			.map(String::trim)
			.toArray(String[]::new);
	}
}