package study.problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

	List<String> answerList = new ArrayList<>();

	public String[] solution(String[][] tickets) {
		boolean[] used = new boolean[tickets.length];
		dfs(0, "ICN", tickets, used, "ICN");
		Collections.sort(answerList);
		return answerList.get(0).split(" ");
	}

	private void dfs(int count, String start, String[][] tickets, boolean[] used, String answer) {
		if (count == tickets.length) {
			answerList.add(answer);
			return;
		}
		for (int i = 0; i < tickets.length; i++) {

			if (!used[i] && start.equals(tickets[i][0])) {
				used[i] = true;
				dfs(count + 1, tickets[i][1], tickets, used, answer + " " + tickets[i][1]);
				used[i] = false;
			}
		}
	}
}