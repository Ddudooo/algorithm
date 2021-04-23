package study.programmers30_42626;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

	private Solution solution = new Solution();

	@Test
	void test() {
		int answer = this.solution.solution(new int[]{1, 2, 3, 9, 10, 12}, 7);
		assertEquals(2, answer);
	}
}