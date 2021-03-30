package study.programmers30_42862;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

	@Test
	void solution() {
		Solution solution = new Solution();
		int answer = solution.solution(5, new int[]{1, 2, 3}, new int[]{2, 3, 4});
		assertEquals(4, answer);
	}
}