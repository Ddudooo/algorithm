package study.problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Solution {

	static Map<String, List<Integer>> peopleScores = new HashMap<>();

	public int[] solution(String[] info, String[] query) {
		for (String person : info) {
			setPersonScore(person);
		}
		for (Entry<String, List<Integer>> entry : peopleScores.entrySet()) {
			List<Integer> scores = peopleScores.get(entry.getKey());
			Collections.sort(scores);
		}

		int[] answer = new int[query.length];
		for (int i = 0; i < query.length; i++) {
			try {
				answer[i] = getCountByQuery(query[i]);
			} catch (Exception e) {
				answer[i] = 0;
			}
		}
		return answer;
	}

	public void setPersonScore(String info) {
		String[] infos = info.split(" ");
		String[] languages = new String[]{infos[0], "-"};
		String[] tasks = new String[]{infos[1], "-"};
		String[] careers = new String[]{infos[2], "-"};
		String[] soulFoods = new String[]{infos[3], "-"};

		int score = Integer.parseInt(infos[4]);

		for (String lang : languages) {
			for (String task : tasks) {
				for (String career : careers) {
					for (String food : soulFoods) {
						String key = lang + task + career + food;
						List<Integer> scores = peopleScores.getOrDefault(key, new ArrayList<>());
						scores.add(score);
						peopleScores.put(key, scores);
					}
				}
			}
		}
	}

	public int getCountByQuery(String query) throws Exception {
		String[] filters = query.split(" and | ");
		String key = filters[0] + filters[1] + filters[2] + filters[3];
		int gte = Integer.parseInt(filters[4]);

		List<Integer> scores = peopleScores.get(key);

		return gteScore(scores, gte);
	}

	private int gteScore(List<Integer> scores, int gte) {
		if (scores.get(scores.size() - 1) < gte) {
			return 0;
		}

		int mid = 0;
		int end = scores.size();
		int start = 0;

		while (end > start) {
			mid = (start + end) / 2;
			if (scores.get(mid) >= gte) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return scores.size() - start;
	}
}