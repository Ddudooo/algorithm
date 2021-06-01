package study.problem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

	@Test
	void dfsTest() {
		Solution dfsSoultion = new Solution();
		int answer = dfsSoultion.solution(new int[]{1, 1, 1, 1, 1}, 3);
		assertEquals(5, answer, "5가 정답임");
	}
}