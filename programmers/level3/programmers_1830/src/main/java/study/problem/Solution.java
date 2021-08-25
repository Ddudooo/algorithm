package study.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	public String solution(String sentence) {
		Map<Character, List<Integer>> lowCharMap = new HashMap<>();
		String lowChar = sentence.replaceAll("[^a-z]", "");
		for (char low : lowChar.toCharArray()) {
			lowCharMap.put(low, new ArrayList<>());
		}
		char[] characters = sentence.toCharArray();
		for (int i = 0; i < characters.length; i++) {
			char character = characters[i];
			if (Character.isLowerCase(character)) {
				lowCharMap.get(character).add(i);
			}
		}
		char[] replaced = sentence.toCharArray();
		boolean[][] used = new boolean[2][replaced.length];
		for (Character key : lowCharMap.keySet()) {
			List<Integer> points = lowCharMap.get(key);
			if (points.size() == 2) {
				// 조건 2
				int start = points.get(0);
				int end = points.get(1);
				if (end - start <= 1) {
					return "invalid";
				}
				if (isUnUsed(used[1], start, end)) {
					replaced[start] = ' ';
					replaced[end] = ' ';
					Arrays.fill(used[1], start, end + 1, true);
				} else {
					return "invalid";
				}
			} else {
				// 조건 1
				int start = points.get(0) - 1;
				int end = points.get(points.size() - 1) + 1;
				if (start < 0 || end > replaced.length) {
					return "invalid";
				}
				if (!Character.isUpperCase(replaced[start])
					|| !Character.isUpperCase(replaced[end])) {
					return "invalid";
				}
				if (isUnUsed(used[0], start, end)) {
					String word = String.valueOf(replaced).substring(start, end + 1);
					word = word.replaceAll(String.valueOf(key), "");
					for (int i = 0; i <= end - start; i++) {
						if (i >= word.length()) {
							replaced[start + i] = ' ';
						} else {
							replaced[start + i] = word.charAt(i);
						}
					}
					Arrays.fill(used[0], start, end, true);
				} else {
					return "invalid";
				}
			}
		}
		String replaceStr = String.valueOf(replaced);
		replaceStr = replaceStr.trim().replaceAll(" +", " ");
		return replaceStr;
	}

	private boolean isUnUsed(boolean[] used, int start, int end) {
		for (int i = start; i <= end; i++) {
			if (used[i]) {
				return false;
			}
		}
		return true;
	}
}