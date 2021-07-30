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
		"3\t[\"tank\", \"kick\", \"know\", \"wheel\", \"land\", \"dream\", \"mother\", \"robot\", \"tank\"]\t[3,3]",
		"5\t[\"hello\", \"observe\", \"effect\", \"take\", \"either\", \"recognize\", \"encourage\", \"ensure\", \"establish\", \"hang\", \"gather\", \"refer\", \"reference\", \"estimate\", \"executive\"]\t[0,0]",
		"2\t[\"hello\", \"one\", \"even\", \"never\", \"now\", \"world\", \"draw\"]\t[1,3]"
	}, delimiter = '\t')
	void testCase(int n, String wordStr, String resultStr) {
		int[] answer = this.solution.solution(n, strToStrAry(wordStr));

		assertArrayEquals(strToIntAry(resultStr), answer, "답이 같아야 한다.");
	}

	private String[] strToStrAry(String str) {
		String[] split = str.split(",");
		return Arrays.stream(split)
			.map(splitStr -> splitStr.replaceAll("\\W", ""))
			.map(String::trim)
			.toArray(String[]::new);
	}

	private int[] strToIntAry(String str) {
		return Arrays.stream(strToStrAry(str))
			.mapToInt(Integer::valueOf)
			.toArray();
	}
}