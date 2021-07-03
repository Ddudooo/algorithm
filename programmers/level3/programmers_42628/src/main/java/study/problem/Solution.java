package study.problem;

import java.util.PriorityQueue;

public class Solution {

	public int[] solution(String[] operations) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (String op : operations) {
			switch (op) {
				case "D 1":
					queue = removeLast(queue);
					break;
				case "D -1":
					queue.poll();
					break;
				default:
					String[] s = op.split(" ");
					int number = Integer.parseInt(s[1]);
					queue.add(number);
			}
		}
		return getAnswer(queue);
	}

	private <T> PriorityQueue<T> removeLast(PriorityQueue<T> q) {
		PriorityQueue<T> nq = new PriorityQueue<>();
		while (q.size() > 1) {
			nq.add(q.poll());
		}
		return nq;
	}

	private int[] getAnswer(PriorityQueue<Integer> queue) {
		int[] answer = new int[2];
		if (queue.isEmpty()) {
			return answer;
		} else {
			answer[1] = queue.poll();
			int max = 0;
			if (!queue.isEmpty()) {
				while (queue.size() > 1) {
					queue.poll();
				}
				max = queue.poll();
			}
			answer[0] = max;
		}
		return answer;
	}
}