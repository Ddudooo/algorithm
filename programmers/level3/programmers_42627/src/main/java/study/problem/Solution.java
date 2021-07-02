package study.problem;

import java.util.PriorityQueue;

public class Solution {

	public int solution(int[][] jobs) {
		PriorityQueue<Job> ready = new PriorityQueue<>((a, b) -> {
			if (a.start == b.start) {
				return a.duration - b.duration;
			}
			return a.start - b.start;
		});
		PriorityQueue<Job> queue = new PriorityQueue<>((a, b) -> {
			if (a.duration == b.duration) {
				return a.start - b.start;
			}
			return a.duration - b.duration;
		});
		for (int[] job : jobs) {
			ready.add(new Job(job[0], job[1]));
		}

		int answer = 0;
		int sec = 0;
		while (!ready.isEmpty() || !queue.isEmpty()) {
			while (ready.peek() != null && ready.peek().start <= sec) {
				queue.add(ready.poll());
			}

			if (queue.isEmpty()) {
				sec++;
			} else {
				Job nextJob = queue.poll();
				answer += sec - nextJob.start;
				sec += nextJob.duration;
				answer += nextJob.duration;
			}
		}
		return answer / jobs.length;
	}
}

class Job {

	int start;
	int duration;

	public Job(int start, int duration) {
		this.start = start;
		this.duration = duration;
	}
}