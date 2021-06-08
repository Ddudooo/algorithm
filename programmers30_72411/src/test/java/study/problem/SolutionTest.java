package study.problem;

import org.junit.jupiter.api.Test;

class SolutionTest {

	@Test
	void testCase() {
		Solution solution = new Solution();
		String[] answers = solution
			.solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"},
				new int[]{2, 3, 4});

		for (String s : answers) {
			System.out.println(s + " ");
		}
	}
}