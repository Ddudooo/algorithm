package study.problem;

import org.junit.jupiter.api.Test;

class SolutionTest {

	@Test
	void testCase1() {
		Solution solution = new Solution();
		int[] answer = solution
			.solution(6, 6, new int[][]{{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}});
		for (int i : answer) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	@Test
	void testCase2() {
		Solution solution = new Solution();
		int[] answer = solution
			.solution(3, 3, new int[][]{{1, 1, 2, 2}, {1, 2, 2, 3}, {2, 1, 3, 2}, {2, 2, 3, 3}});
		for (int i : answer) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	@Test
	void testCase3() {
		Solution solution = new Solution();
		int[] answer = solution
			.solution(100, 97, new int[][]{{1, 1, 100, 97}});
		for (int i : answer) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}