package study.programmers30_42579;

import org.junit.jupiter.api.Test;

class SolutionTest {

	@Test
	void test() {
		Solution solution = new Solution();
		int[] answer = solution.solution(
			new String[]{"classic", "pop", "classic", "classic", "pop"},
			new int[]{500, 600, 150, 800, 2500});
		for (int i : answer) {
			System.out.println(i);
		}
	}

	@Test
	void test2() {
		Solution solution = new Solution();
		int[] answer = solution.solution(
			new String[]{"a", "b", "a", "b", "a"},
			new int[]{5, 5, 5, 5, 5});
		for (int i : answer) {
			System.out.println(i);
		}
	}
}