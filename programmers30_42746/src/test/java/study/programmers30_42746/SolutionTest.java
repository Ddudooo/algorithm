package study.programmers30_42746;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

	private Solution solution = new Solution();

	@Test
	void solutionTest() {
		String answer = this.solution.solution(new int[]{6, 10, 2});
		assertEquals("6210", answer);
	}
}