package study.problem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

	@Test
	void testCase() {
		Solution solution = new Solution();
		int answer = solution.solution(new int[][]{{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}});

		assertEquals(16, answer, "답이 같아야 한다.");
	}
}