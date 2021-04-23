package study.programmers30_42747;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

	private Solution solution = new Solution();

	@Test
	void test() {
		int answer = this.solution.solution(new int[]{3, 0, 6, 1, 5});
		assertEquals(3, answer);
	}
}