package study.problem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

	@Test
	void testCase1() {
		Solution solution = new Solution();
		long answer = solution.solution(8, 12);

		assertEquals(80, answer, "답은 80이 나와야 한다.");
	}
}