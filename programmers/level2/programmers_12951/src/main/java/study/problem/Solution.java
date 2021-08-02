package study.problem;

import java.util.stream.Collectors;

public class Solution {

	public String solution(String s) {
		final boolean[] firstChar = {true};
		return s.codePoints()
			.mapToObj(c -> (char) c)
			.map(Character::toLowerCase)
			.map(c -> {
				if (firstChar[0] && !Character.isWhitespace(c)) {
					firstChar[0] = false;
					c = Character.toUpperCase(c);
				}
				if (Character.isWhitespace(c)) {
					firstChar[0] = true;
				}
				return String.valueOf(c);
			})
			.collect(Collectors.joining(""));
	}
}