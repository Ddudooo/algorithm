package study.programmers30_42583;

import org.junit.jupiter.api.Test;

class SolutionTest {

	@Test
	void test() {
		Solution solution = new Solution();
		int answer = solution
			.solution(2, 10, new int[]{7, 4, 5, 6});
		System.out.println(answer);
	}
}