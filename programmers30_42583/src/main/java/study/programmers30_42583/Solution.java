package study.programmers30_42583;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	public int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		int sum = 0;
		Queue<Integer> queue = new LinkedList<>();
		for (int truck : truck_weights) {
			while (true) {
				if (queue.isEmpty()) {
					queue.add(truck);
					sum += truck;
					answer++;
					break;
				}
				if (queue.size() == bridge_length) {
					sum -= queue.poll();
				} else {
					if (sum + truck <= weight) {
						queue.add(truck);
						sum += truck;
						answer++;
						break;
					} else {
						queue.add(0);
						answer++;
					}
				}
			}
		}
		answer += bridge_length;
		return answer;
	}
}