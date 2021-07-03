package study.problem;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution {

	boolean[] visit;

	public int solution(String begin, String target, String[] words) {
		visit = new boolean[words.length];
		int answer = bfs(begin, target, words);
		return answer;
	}

	public int bfs(String begin, String target, String[] words) {
		Queue<String> queue = new LinkedList<>();
		Map<String, Integer> cntMap = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			if (!visit[i] && isOneChange(begin, words[i])) {
				visit[i] = true;
				if (words[i].equals(target)) {
					return 1;
				} else {
					queue.add(words[i]);
					cntMap.put(words[i], 1);
				}
			}
		}
		while (!queue.isEmpty()) {
			String changeWord = queue.poll();
			Integer changeCnt = cntMap.get(changeWord);
			for (int i = 0; i < words.length; i++) {
				if (!visit[i] && isOneChange(changeWord, words[i])) {
					visit[i] = true;
					if (words[i].equals(target)) {
						return changeCnt + 1;
					} else {
						queue.add(words[i]);
						cntMap.put(words[i], changeCnt + 1);
					}
				}
			}
		}
		return 0;
	}

	private boolean isOneChange(String str, String word) {
		int cnt = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != word.charAt(i)) {
				cnt++;
				if (cnt > 1) {
					break;
				}
			}
		}
		return cnt == 1;
	}
}