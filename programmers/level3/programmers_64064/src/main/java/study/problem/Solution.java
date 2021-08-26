package study.problem;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Solution {

	private final Set<Set<String>> candidate = new HashSet<>();

	public int solution(String[] user_id, String[] banned_id) {
		Set<String>[] bannedMatching = new Set[banned_id.length];
		for (int i = 0; i < banned_id.length; i++) {
			Set<String> matching = matching(banned_id[i], user_id);
			bannedMatching[i] = matching;
		}
		calculate(new HashSet<>(), 0, bannedMatching);
		return candidate.size();
	}

	private Set<String> matching(String bannedId, String... userIds) {
		Set<String> matchedIds = new HashSet<>();
		String matchPattern = bannedId.replaceAll("\\*", ".");
		for (String userId : userIds) {
			if (Pattern.matches(matchPattern, userId)) {
				matchedIds.add(userId);
			}
		}
		return matchedIds;
	}

	private void calculate(Set<String> ableBanList, int idx, Set<String>... bannedMatching) {
		if (idx == bannedMatching.length) {
			candidate.add(new HashSet<>(ableBanList));
			return;
		}

		for (String id : bannedMatching[idx]) {
			if (ableBanList.add(id)) {
				calculate(ableBanList, idx + 1, bannedMatching);
				ableBanList.remove(id);
			}
		}
	}
}