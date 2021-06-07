package study.problem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SolutionTest {

	@ParameterizedTest
	@CsvSource({
		"FRANCE, french, 16384",
		"handshake, shake hands, 65536",
		"aa1+aa2, AAAA12, 43690",
		"E=M*C^2, e=m*c^2, 65536"
	})
	void testCase(String str1, String str2, int result) {
		Solution solution = new Solution();
		int answer = solution.solution(str2, str1);

		assertEquals(result, answer, "결과갑이 답과 같아야 한다.");
	}

}