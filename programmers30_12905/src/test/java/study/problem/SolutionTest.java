package study.problem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

	@Test
	void testCase1() {
		Solution solution = new Solution();
		int answer = solution
			.solution(new int[][]{{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}});

		assertEquals(9, answer, "답이 일치하여야 한다.");
	}

	@Test
	void testCase2() {
		Solution solution = new Solution();
		int answer = solution
			.solution(new int[][]{{0, 0, 1, 1}, {1, 1, 1, 1}});

		assertEquals(4, answer, "답이 일치하여야 한다.");
	}
}