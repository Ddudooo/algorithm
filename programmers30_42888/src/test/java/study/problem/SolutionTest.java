package study.problem;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

	@Test
	void test1() {
		Solution solution = new Solution();
		String[] answer = solution.solution(
			new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234",
				"Enter uid1234 Prodo", "Change uid4567 Ryan"});

		for (String output : answer) {
			System.out.println(output);
		}

		assertArrayEquals(
			new String[]{"Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."}
			, answer, "정답 확인!");
	}
}