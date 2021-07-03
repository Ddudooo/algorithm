package study.problem;

public class Solution {

	boolean[] visit;

	public int solution(int n, int[][] computers) {
		visit = new boolean[n];
		int answer = 0;
		for (int i = 0; i < computers.length; i++) {
			if (!visit[i]) {
				System.out.println("visit = " + i);
				visit[i] = true;
				dfs(i, computers);
				answer++;
			}
		}
		return answer;
	}

	private void dfs(int start, int[][] computers) {
		visit[start] = true;
		for (int i = 0; i < computers[start].length; i++) {
			if (computers[start][i] != 0 && !visit[i]) {
				visit[i] = true;
				dfs(i, computers);
			}
		}
	}
}