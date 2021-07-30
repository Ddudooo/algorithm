package study.problem;

import java.util.HashSet;
import java.util.Set;

public class Solution {

	private Set<String> usedWords = new HashSet<>();

	public int[] solution(int n, String[] words) {
		int[] answer = init();
		int length = words.length;
		String preWord = words[0].substring(0, 1);
		for (int i = 0; i < length; i++) {
			String word = words[i];
			if (isWrongWord(word, preWord) || isAlreadyUsed(word)) {
				answer = calculatePersonAndTurn(i + 1, n);
				break;
			}
			preWord = word;
		}
		return answer;
	}

	private int[] calculatePersonAndTurn(int idx, int n) {
		int turn = idx / n;
		int person = idx % n;
		if (person != 0) {
			turn++;
		}
		person = person == 0 ? n : person;
		return new int[]{person, turn};
	}

	private boolean isAlreadyUsed(String word) {
		boolean result = usedWords.contains(word);
		if (!result) {
			usedWords.add(word);
		}
		return result;
	}

	private boolean isWrongWord(String word, String preWord) {
		return !(getLastChar(preWord) == getFirstChar(word));
	}

	private char getFirstChar(String word) {
		return word.charAt(0);
	}

	private char getLastChar(String word) {
		return word.charAt(word.length() - 1);
	}

	private int[] init() {
		usedWords = new HashSet<>();
		int[] answer = new int[2];
		answer[0] = 0;
		answer[1] = 0;
		return answer;
	}
}