package study.programmers30_42587;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

	private Solution solution = new Solution();

	@Test
	void solutionTest() {
		int answer = this.solution.solution(new int[]{2, 1, 3, 2}, 2);
		Assertions.assertEquals(1, answer);
	}
}