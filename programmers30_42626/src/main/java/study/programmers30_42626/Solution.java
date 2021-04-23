package study.programmers30_42626;

import java.util.PriorityQueue;

public class Solution {

	public int solution(int[] scoville, int K) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int val : scoville) {
			queue.add(val);
		}
		int answer = 0;
		try {
			while (!queue.isEmpty()) {
				Integer poll = queue.poll();
				if (poll < K) {
					queue.add(poll + (queue.poll() * 2));
					answer++;
				} else {
					break;
				}
			}
			return answer;
		} catch (Exception e) {
			return -1;
		}
	}
}