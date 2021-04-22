package study.programmers30_12899;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

	private Solution solution = new Solution();

	@Test
	void solutionTest() {
		String answer = this.solution.solution(3);
		assertEquals("4", answer);
	}
}