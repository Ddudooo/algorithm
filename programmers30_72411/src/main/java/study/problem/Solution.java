package study.problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution {

	static HashMap<String, Integer> map = new HashMap<>();
	static HashMap<Integer, Integer> courseMax = new HashMap<>();

	public String[] solution(String[] orders, int[] course) {
		for (int i : course) {
			for (String order : orders) {
				create("", 0, i, 0, order.toCharArray());
			}
		}
		PriorityQueue<String> queue = createQueue();
		return queueToStringAry(queue);
	}

	private PriorityQueue<String> createQueue() {
		PriorityQueue<String> tempQueue = new PriorityQueue<>();
		Set<String> createCourse = map.keySet();
		for (String newCourse : createCourse) {
			Integer favorite = courseMax.get(newCourse.length());
			Integer newCourseChoseCnt = map.get(newCourse);
			if (newCourseChoseCnt >= favorite && newCourseChoseCnt > 1) {
				tempQueue.add(newCourse);
			}
		}
		return tempQueue;
	}

	private String[] queueToStringAry(PriorityQueue<String> tempQueue) {
		String[] answer = new String[tempQueue.size()];
		int idx = 0;
		while (!tempQueue.isEmpty()) {
			answer[idx++] = tempQueue.poll();
		}
		return answer;
	}

	public void create(String str, int cnt, int target, int idx, char[] order) {
		if (cnt == target) {
			char[] foods = courseOrderingByAlphabet(str);
			String newCourse = createCourseName(foods);
			int courseCnt = map.getOrDefault(newCourse, 0) + 1;
			map.put(newCourse, courseCnt);
			isMostFavoriteCourse(courseCnt, target);
			return;
		}
		for (int i = idx; i < order.length; i++) {
			char food = order[i];
			create(str + food, cnt + 1, target, i + 1, order);
		}
	}

	private void isMostFavoriteCourse(int courseCnt, int target) {
		courseMax.put(target, Math.max(courseMax.getOrDefault(target, courseCnt), courseCnt));
	}

	private String createCourseName(char[] foods) {
		StringBuilder sb = new StringBuilder();
		for (char c : foods) {
			sb.append(c);
		}
		return sb.toString();
	}

	private char[] courseOrderingByAlphabet(String course) {
		char[] foods = course.toCharArray();
		Arrays.sort(foods);
		return foods;
	}
}