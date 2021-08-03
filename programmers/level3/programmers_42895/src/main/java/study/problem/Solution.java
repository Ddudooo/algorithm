package study.problem;

public class Solution {

	int answer = -1;

	public int solution(int N, int number) {
		if (N == number) {
			return 1;
		}
		dfs(N, number, 0, 0);
		return answer;
	}

	private void dfs(int n, int target, int sum, int cnt) {
		if (cnt > 8) {
			answer = -1;
			return;
		}
		if (sum == target) {
			if (answer == -1) {
				answer = cnt;
			} else {
				answer = Math.min(answer, cnt);
			}
			return;
		}
		int newNumber = n;
		for (int i = 0; i < 8 - cnt; i++) {
			dfs(n, target, sum + newNumber, cnt + 1 + i);
			dfs(n, target, sum - newNumber, cnt + 1 + i);
			dfs(n, target, sum * newNumber, cnt + 1 + i);
			dfs(n, target, sum / newNumber, cnt + 1 + i);
			newNumber = newNumber * 10 + n;
		}
	}
}