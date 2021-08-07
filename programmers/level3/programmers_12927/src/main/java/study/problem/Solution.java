package study.problem;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

	public long solution(int n, int[] works) {
		long answer = 0;
		Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
		for (int work : works) {
			queue.add(work);
		}
		for (int i = 0; i < n; i++) {
			int poll = queue.poll();
			queue.add(Math.max(poll - 1, 0));
		}

		while (!queue.isEmpty()) {
			int work = queue.poll();
			answer += Math.pow(work, 2);
		}
		return answer;
	}
}