package study.problem;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

	public int solution(int[] A, int[] B) {
		PriorityQueue<Integer> qa = new PriorityQueue<>(Comparator.comparingInt(a -> -a));
		for (int v : A) {
			qa.add(v);
		}
		PriorityQueue<Integer> qb = new PriorityQueue<>(Comparator.comparingInt(a -> -a));
		for (int v : B) {
			qb.add(v);
		}
		int answer = 0;
		while (!qa.isEmpty()) {
			int aScore = qa.poll();
			if (qb.peek() > aScore) {
				qb.poll();
				answer++;
			}
		}
		return answer;
	}
}