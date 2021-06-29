package study.problem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SolutionTest {

	Solution solution;

	@BeforeEach
	void init() {
		solution = new Solution();
	}

	@ParameterizedTest
	@CsvSource(value = {
		"[[100,ryan,music,2],[200,apeach,math,2],[300,tube,computer,3],[400,con,computer,4],[500,muzi,music,3],[600,apeach,music,2]]; 2"
	}, delimiter = ';')
	void testCase(String relation, int result) {
		int answer = this.solution.solution(strToStrMultipleAry(relation));
		assertEquals(result, answer, "답이 같아야 한다.");
	}

	private String[][] strToStrMultipleAry(String input) {
		String source = input.substring(1, input.length() - 1);
		String[][] inputSource = new String[getRowCount(source)][getColumnCount(source)];
		for (int i = 0; i < inputSource.length; i++) {
			String row = source
				.substring(getIndexOfByCount(source, '[', i) + 1,
					getIndexOfByCount(source, ']', i));
			String[] columns = row.split(",");
			inputSource[i] = columns;
		}
		return inputSource;
	}

	public int getRowCount(String source) {
		String[] split = source.split("],\\[");
		return split.length;
	}

	public int getColumnCount(String source) {
		String row = source.substring(source.indexOf("["), source.indexOf("]"));
		String[] split = row.split(",");
		return split.length;
	}


	public int getIndexOfByCount(String source, char specialChar, int count) {
		int cnt = 0;
		int idx = 0;
		char[] chars = source.toCharArray();
		while (cnt <= count) {
			if (chars[idx] == specialChar) {
				cnt++;
			}
			idx++;
		}
		return idx - 1;
	}
}