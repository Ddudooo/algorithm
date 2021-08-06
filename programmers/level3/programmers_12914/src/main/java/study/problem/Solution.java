package study.problem;

public class Solution {

	private long answer = 0;

	public long solution(int n) {
		dfs(0, n);
		return answer;
	}

	private void dfs(int num, int target) {
		if (num == target) {
			answer++;
			return;
		}
		if (num > target) {
			return;
		}
		dfs(num + 1, target);
		dfs(num + 2, target);
	}
}