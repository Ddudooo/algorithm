package study.programmers_30_42586;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

	private Solution solution = new Solution();

	@Test
	void solutionTest() {
		int[] answer = this.solution.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});
		for (int value : answer) {
			System.out.println(value);
		}
		Assertions.assertArrayEquals(new int[]{2, 1}, answer);

		int[] answer2 = this.solution
			.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1});
		for (int value : answer2) {
			System.out.println(value);
		}
		Assertions.assertArrayEquals(new int[]{1, 3, 2}, answer2);
	}

	@Test
	void solutionTest2() {
		int[] answer = this.solution.solution(new int[]{55, 30, 99}, new int[]{5, 30, 5});
		for (int value : answer) {
			System.out.println(value);
		}
		Assertions.assertArrayEquals(new int[]{1}, answer);
	}
}