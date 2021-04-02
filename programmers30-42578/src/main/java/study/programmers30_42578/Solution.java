package study.programmers30_42578;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution {

	public int solution(String[][] clothes) {
		int answer = 1;
		Map<String, Integer> clothesMap = new HashMap<>();
		for (int i = 0; i < clothes.length; i++) {
			String[] cloth = clothes[i];
			if (clothesMap.containsKey(cloth[1])) {
				Integer cur = clothesMap.get(cloth[1]);
				clothesMap.put(cloth[1], cur + 1);
			} else {
				clothesMap.put(cloth[1], 1);
			}
		}
		Set<String> strings = clothesMap.keySet();

		for (String key : strings) {
			answer *= clothesMap.get(key) + 1;
		}

		return --answer;
	}
}