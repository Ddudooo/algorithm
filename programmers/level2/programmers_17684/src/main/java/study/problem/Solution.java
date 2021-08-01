package study.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	public int[] solution(String msg) {
		Map<String, Integer> dictionary = init();
		List<Integer> answer = new ArrayList<>();
		int nextIdx = 27;
		int idx = 0;
		int length = msg.length();
		while (idx < length) {
			String temp = msg.substring(idx, idx + 1);
			System.out.println("temp = " + temp);
			if (++idx < length) {
				String next = temp + msg.charAt(idx);
				while (dictionary.containsKey(next) && idx < length) {
					temp = next;
					if (++idx < length) {
						next = temp + msg.charAt(idx);
					}
				}
				System.out.println("next = " + next);
				if (next.length() > 1 && !dictionary.containsKey(next)) {
					dictionary.put(next, nextIdx++);
				}
			}
			System.out.println("temp = " + temp);
			System.out.printf("length = %d, idx = %d\n", length, idx);
			answer.add(dictionary.get(temp));
			for (Integer v : answer) {
				System.out.print(v + " ");
			}
			System.out.println();
			System.out.println("===============================================");
		}
		return answer.stream().mapToInt(Integer::intValue).toArray();
	}

	private Map<String, Integer> init() {
		Map<String, Integer> dictionary = new HashMap<>();
		char word = 'A';
		int idx = 1;
		while (idx <= 26) {
			dictionary.put(String.valueOf(word), idx);
			word++;
			idx++;
		}
		return dictionary;
	}
}