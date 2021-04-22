package study.programmers30_42839;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

	private Solution solution = new Solution();

	@Test
	void test() {
		int answer = this.solution.solution("011");
		assertEquals(2, answer);
	}

	@Test
	void StringToInt() {
		int convertValue = Integer.parseInt("013");
		assertEquals(13, convertValue);
	}
}