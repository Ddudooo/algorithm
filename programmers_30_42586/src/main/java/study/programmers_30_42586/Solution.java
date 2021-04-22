package study.programmers_30_42586;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

	public int[] solution(int[] progresses, int[] speeds) {
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < progresses.length; i++) {
			queue.add((int) Math.ceil((100 - progresses[i]) / (double) speeds[i]));
		}
		List<Integer> done = new ArrayList<>();
		int cnt = 1;
		int cur = queue.poll();
		while (!queue.isEmpty()) {
			Integer next = queue.poll();
			if (next <= cur) {
				cnt++;
			} else {
				done.add(cnt);
				cnt = 1;
				cur = next;
			}
		}
		done.add(cnt);
		int[] answer = new int[done.size()];
		for (int i = 0; i < done.size(); i++) {
			answer[i] = done.get(i);
		}
		return answer;
	}
}