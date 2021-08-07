package study.problem;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public long solution(int n, int[] works) {
		long answer = 0;
		List<Integer> workList = new ArrayList<>();
		for (int j : works) {
			workList.add(j);
		}
		boolean flag = true;
		while (flag) {
			int max = 0;
			int idx = 0;
			for (int i = 0; i < workList.size(); i++) {
				int work = workList.get(i);
				max = Math.max(max, work);
				if (max == work) {
					idx = i;
				}
			}
			if (max != 0) {
				workList.set(idx, max - 1);
				n--;
			}
			if (max == 0 || n == 0) {
				flag = false;
			}
		}
		for (int work : workList) {
			answer += Math.pow(work, 2);
		}
		return answer;
	}
}