package study.programmers30_42576;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

	@Test
	void solutionTest() {
		Solution solution = new Solution();
		String[] participant = new String[]{"leo", "kiki", "eden"};
		String[] completion = new String[]{"eden", "kiki"};
		String expected = "leo";
		String answer = solution.solution(participant, completion);
		assertEquals(expected, answer);
	}
}