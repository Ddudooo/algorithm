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
		"[\"frodo\", \"fradi\", \"crodo\", \"abc123\", \"frodoc\"]\t[\"fr*d*\", \"abc1**\"]\t2",
		"[\"frodo\", \"fradi\", \"crodo\", \"abc123\", \"frodoc\"]\t[\"*rodo\", \"*rodo\", \"******\"]\t2",
		"[\"frodo\", \"fradi\", \"crodo\", \"abc123\", \"frodoc\"]\t[\"fr*d*\", \"*rodo\", \"******\", \"******\"]\t3"
	}, delimiter = '\t')
	void testCase(String userIdStr, String bannedIdStr, int result) {
		int answer = this.solution.solution(strToStrAry(userIdStr), strToStrAry(bannedIdStr));

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